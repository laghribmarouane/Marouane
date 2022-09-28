package com.example.authentificationapp.model;

public class AuthentificationModel {
    int status;
    boolean authSuccess;
    String token;

    public AuthentificationModel(int status, boolean authSuccess, String token) {
        this.status = status;
        this.authSuccess = authSuccess;
        this.token = token;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isAuthSuccess() {
        return authSuccess;
    }

    public void setAuthSuccess(boolean authSuccess) {
        this.authSuccess = authSuccess;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
