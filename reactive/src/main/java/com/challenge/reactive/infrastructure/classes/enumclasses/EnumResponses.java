package com.challenge.reactive.infrastructure.classes.enumclasses;

public enum EnumResponses {
    SUCCESS("SUCCESS", "successfully created"),
    SUCCESS_ASSING("SUCCESS_ASSING", "successfully assigned"),
    SUCCESS_DELETE("SUCCESS", "successfully deleted"),
    ERROR_001("E001", "Error deleting object"),
    ERROR_002("E002", "Error Updating object"),
    ERROR_003("E003", "Error getting object"),
    ERROR_004("E004", "Error saving object")
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
