package ro.madbog.retry.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ro.madbog.retry.services.RetryableService;

import java.util.Objects;

@Component
public class ApiPingScheduler {

    private final RetryableService retryableService;

    @Autowired
    public ApiPingScheduler(final RetryableService retryableService) {
        this.retryableService = Objects.requireNonNull(retryableService, "retryableService must not be null");
    }

    @Scheduled(fixedRate = 10000)
    public void scheduledTask() {
        System.out.println("start-------------");
        final String ret = retryableService.retryable();
        System.out.println("SERVICE returned : " + ret);
        System.out.println("stop -------------");
    }
}
