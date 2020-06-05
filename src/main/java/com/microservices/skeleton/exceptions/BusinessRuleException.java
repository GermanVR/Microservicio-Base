package com.microservices.skeleton.exceptions;

/**
 * @author German Vazquez Renteria
 * @id GermanVR
 * @url https://github.com/GermanVR
 */
public abstract class BusinessRuleException extends SkeletonApiException {

    private static final long serialVersionUID = 1L;

    /**
     * @param exception
     */
    public BusinessRuleException(String exception) {
        super(exception);
    }

    @Override
    public Integer getHttpStatus() {
        return 412;
    }

}
