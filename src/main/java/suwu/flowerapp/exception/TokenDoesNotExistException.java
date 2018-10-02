package suwu.flowerapp.exception;

import suwu.flowerapp.response.WrongResponse;

public class TokenDoesNotExistException extends Exception {
    private WrongResponse response = new WrongResponse(10034, "Token in not existed.");

    public WrongResponse getResponse() {
        return response;
    }
}
