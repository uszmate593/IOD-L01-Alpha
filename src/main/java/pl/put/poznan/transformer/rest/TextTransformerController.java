package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Arrays;


@RestController
@RequestMapping("/{text}")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {
        logger.info("Przychodzi zapytanie GET na endpoint '/{text}'");
        // log the parameters
        logger.debug("Tekst: {}", text);
        logger.debug("Transformacje: {}", Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String text,
                      @RequestBody String[] transforms) {

        logger.info("Przychodzi zapytanie POST na endpoint '/{text}'");
        logger.debug("Przesłany tekst do transformacji: {}",text);
        logger.debug("Przesłane transformacje do wykonania na tekście: {}",Arrays.toString(transforms));


        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }



}


