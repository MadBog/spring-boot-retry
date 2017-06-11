package ro.madbog.retry.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class ApiResource {

    @GetMapping
    public ResponseEntity<String> get() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        if (randomNumber % 3 == 0) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("SUCCESS");
    }
}
