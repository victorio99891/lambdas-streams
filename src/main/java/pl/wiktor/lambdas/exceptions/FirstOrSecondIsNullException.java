package pl.wiktor.lambdas.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FirstOrSecondIsNullException extends RuntimeException {

    public FirstOrSecondIsNullException(String message) {
        super(message);
        log.error(this.getClass().getName() + " has been thrown with message " + this.getMessage());
    }
}
