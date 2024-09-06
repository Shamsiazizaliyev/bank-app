package az.ingress.bankapp.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException exception,
                                                                      HttpServletRequest request,
                                                                      HttpServletResponse response) {
        Map<String, String> error = new HashMap<>();
        error.put("timestamp", LocalDate.now().toString());
        error.put("status", String.valueOf(response.getStatus()));
        error.put("message", exception.getMessage());
        error.put("path", request.getContextPath());
        //System.out.println(exception.getMessage());
        //exception.printStackTrace();
        return ResponseEntity.status(345).body(error);
    }
}
