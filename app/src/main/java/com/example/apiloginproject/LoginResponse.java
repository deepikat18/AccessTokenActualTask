package com.example.apiloginproject;



public class LoginResponse {
    private static LoginResponse    instance;

    public String status;
    public String msg;
    public int id;
    public String username;
    public int roles;
    public String currentTimeStamp;
    public int tokenTime;
    public String accessToken;
    public String tokenType;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public static LoginResponse getInstance() {
        if (instance == null) {
            instance = new LoginResponse();
        }
        return instance;
    }

    public String getMsg() {
        return msg;
    }



    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoles() {
        return roles;
    }

    public void setRoles(int roles) {
        this.roles = roles;
    }

    public String getCurrentTimeStamp() {
        return currentTimeStamp;
    }

    public void setCurrentTimeStamp(String currentTimeStamp) {
        this.currentTimeStamp = currentTimeStamp;
    }

    public int getTokenTime() {
        return tokenTime;
    }

    public void setTokenTime(int tokenTime) {
        this.tokenTime = tokenTime;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
