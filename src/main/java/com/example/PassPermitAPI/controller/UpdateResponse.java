package com.example.PassPermitAPI.controller;

import com.example.PassPermitAPI.model.PassPermit;

public class UpdateResponse {
    private String message;
    private PassPermit passPermit;

    public UpdateResponse(String message, PassPermit passPermit) {
        this.message = message;
        this.passPermit = passPermit;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PassPermit getPassPermit() {
        return passPermit;
    }

    public void setPassPermit(PassPermit passPermit) {
        this.passPermit = passPermit;
    }
}
