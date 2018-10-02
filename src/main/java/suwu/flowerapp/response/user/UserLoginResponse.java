package suwu.flowerapp.response.user;

import suwu.flowerapp.response.Response;

public class UserLoginResponse extends Response {
    private String token;

    public UserLoginResponse() {
    }

    public UserLoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
