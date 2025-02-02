package com.challenge.reactive.infrastructure.classes.enumclasses;

public enum EnumResponses {
    SUCCESS("SUCCESS", "successfully created"),
    SUCCESS_ASSING("SUCCESS_ASSING", "successfully assigned"),
    SUCCESS_DELETE("SUCCESS", "successfully deleted"),
    ERROR_000("E000", "Error creating Bootcamp"),
    ERROR_001("E001", "Bootcamp not found"),
    ERROR_002("E002", "Please verify the data and try again"),
    ERROR_003("E003", "Error assigning Capabilities to Bootcamp"),
    ERROR_004("E004", "Error deleting Capability from Bootcamp")
    ;

    private String code;
    private String message;

    EnumResponses(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
