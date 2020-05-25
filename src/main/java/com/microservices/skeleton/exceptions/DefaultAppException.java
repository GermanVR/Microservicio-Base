package com.microservices.skeleton.exceptions;

/**
 * @author German Vazquez Renteria
 * @id GermanVR
 * @url https://github.com/GermanVR
 */
public class DefaultAppException extends BusinessRuleException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public DefaultAppException(String exception) {
        super(exception);
    }

}
