package suwu.flowerapp.exception;

import suwu.flowerapp.response.WrongResponse;

public class TokenIdDoesNotExistException extends Exception {
    private WrongResponse response = new WrongResponse(10057, "Token id doesn't exit");

    public WrongResponse getResponse() {
        return response;
    }

}
