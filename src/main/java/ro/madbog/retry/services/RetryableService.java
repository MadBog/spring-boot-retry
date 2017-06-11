package ro.madbog.retry.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class RetryableService {

    private final RestTemplate restTemplate;

    @Autowired
    public RetryableService(final RestTemplate restTemplate) {
        this.restTemplate = Objects.requireNonNull(restTemplate, "restTemplate must not be null");
    }

    @Retryable
    public String retryable() {
        return restTemplate.getForObject("http://localhost:8080/api/", String.class);
    }

    @Recover
    public String recover() {
        return "RECOVERED";
    }
}
