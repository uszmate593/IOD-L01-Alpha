package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

import java.util.List;
;
@RestController
@RequestMapping("/api/transform")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);



    @GetMapping(produces = "application/json")
    public List<String> getAvailableOperations() {
        return Arrays.asList("upper", "lower", "capitalize"); // Dodaj inne dostępne operacje
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Map<String, Object> post(@RequestBody Map<String, Object> request) {
        String text = (String) request.get("text");
        String[] transforms = ((String) request.get("transforms")).split(",");
        logger.debug(text);
        logger.debug(String.join(",", transforms));

        TextTransformer transformer = new TextTransformer(transforms);
        String transformedText = transformer.transform(text);

        return createResponseMap(transformedText, transforms);
    }

    private Map<String, Object> createResponseMap(String text, String[] transforms) {
        Map<String, Object> response = new HashMap<>();
        response.put("text", text);
        response.put("transforms", transforms);
        return response;
    }
}