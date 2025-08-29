package online.agatstudio.demo.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    private static final Logger LOG = LogManager.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception e) {
        LOG.error("Handling Exception {}", e.getMessage(), e);
        return ResponseEntity.internalServerError().body("Ooops! Something went wrong!");
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(Exception e) {
        LOG.error("Handling UserNotFoundException {}", e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ooops! User not found!");
    }
}
