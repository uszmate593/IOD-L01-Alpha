		document.addEventListener("DOMContentLoaded", function() {
		    var transformValues = [];

		    function addItemToTransformList(buttonText, buttonValue) {
		        transformValues.push(buttonValue);

		        var transformsList = document.getElementById("transformsList");
		        var listItem = document.createElement("li");
		        listItem.textContent = buttonText;
		        transformsList.appendChild(listItem);
		    }

		    function resetListAndArray() {
		        transformValues = [];
		        var transformsList = document.getElementById("transformsList");
		        transformsList.innerHTML = '';

		        console.log(transformValues);
		    }

		    var normalButtons = document.querySelectorAll("#buttons .button");
		    normalButtons.forEach(function(button) {
		        button.addEventListener("click", function() {
		            var buttonText = this.textContent;
		            var buttonValue = this.getAttribute("data-value");
		            addItemToTransformList(buttonText, buttonValue);
		        });
		    });


		    var resetButton = document.getElementById("resetButton");
		    resetButton.addEventListener("click", function() {
		        resetListAndArray();
		    });

		    function makeHttpRequest() {
		        var apiUrl = 'http://localhost:8080/json/';

		        var inputText = document.getElementById("text-input").value.replace(/\n/g, ' ');

		        var transforms = transformValues.join(',');

		        var fullApiUrl = `${apiUrl}${inputText}?transforms=${transforms}`;

		        fetch(fullApiUrl)
		            .then(response => response.json())
		            .then(data => {
		                var outputText = data.text || "No OutputText found";

		                var outputDiv = document.getElementById("output");
		                outputDiv.textContent = outputText;
		            })
		            .catch(error => {
		                console.error('Error:', error);
		            });
		    }

		    var convertButton = document.querySelector(".lbutton");
		    convertButton.addEventListener("click", function() {
		        makeHttpRequest();
		    });

		});