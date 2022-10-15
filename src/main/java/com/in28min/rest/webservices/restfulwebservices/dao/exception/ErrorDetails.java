package com.in28min.rest.webservices.restfulwebservices.dao.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
    
    // implement timestamp, message, details
    private LocalDateTime timestamp;
    private String message;
    private String details;
    
    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

}
