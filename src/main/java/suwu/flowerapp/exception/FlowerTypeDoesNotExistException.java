package suwu.flowerapp.exception;

import suwu.flowerapp.response.WrongResponse;

public class FlowerTypeDoesNotExistException extends Exception {
    private WrongResponse response = new WrongResponse(10018, "Cannot get flower types");

    public WrongResponse getResponse() {
        return response;
    }
}
