package no.domainName.firstspringboot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//THis is a class that returns a bad request when exception is thrown
@ControllerAdvice
public class PartsControllerAdvice {
    private Logger logger = LoggerFactory.getLogger(PartsControllerAdvice.class);
    @ExceptionHandler(value = AddPartsException.class)
    //When exception is handled I want to pass it a ResponseEntity<String>
    public ResponseEntity<String> handleAddPartsException(AddPartsException e){
        logger.error("PartsException because fish" + e.getMessage());
        return ResponseEntity.badRequest().body("Sorry, fish are not parts");
    }
}
