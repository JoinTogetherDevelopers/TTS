package org.dorageecorp.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoneProjectException extends RuntimeException {
    private String message;

    public NoneProjectException(String message) {
        this.message = message;
    }
}
