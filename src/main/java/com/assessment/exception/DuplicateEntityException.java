package com.assessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateEntityException extends Exception {

    private String entityName;
    private String duplicatePropertyName;
    private String duplicatePropertyValue;

    public DuplicateEntityException() {
        super();
    }

    public DuplicateEntityException(String entityName, Throwable cause) {
        super(null, cause);
        this.entityName = entityName;
    }

    public DuplicateEntityException(String entityName, String duplicatePropertyName, String duplicatePropertyValue, Throwable cause) {
        super(null, cause);
        this.entityName = entityName;
        this.duplicatePropertyName = duplicatePropertyName;
        this.duplicatePropertyValue = duplicatePropertyValue;
    }

    @Override
    public String getMessage(){
        if (duplicatePropertyName == null || duplicatePropertyValue == null){
            return entityName + " with entered attributes already exists.";
        }
        return entityName + " with '" + duplicatePropertyName + "' of '" + duplicatePropertyValue + "' already exists.";
    }

}
