package com.microservices.skeleton.exceptions;

/**
 * @author German Vazquez Renteria
 * @id GermanVR
 * @url https://github.com/GermanVR
 */
public abstract class SkeletonApiException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final String APPLICATION_ID = "DUMMY";
    private static final String APPLICATION_TYPE = "E";

    public static String getApplicationId() {
        return APPLICATION_ID;
    }

    public static String getApplicationType() {
        return APPLICATION_TYPE;
    }

    public final String getId() {
        return String.format("%s-%s-%s", SkeletonApiException.getApplicationId(), SkeletonApiException.getApplicationType(), getHttpStatus());
    }

    public abstract Integer getHttpStatus();

    public SkeletonApiException(String exception) {
        super(exception);
    }

}