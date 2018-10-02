package suwu.flowerapp.exception;

import suwu.flowerapp.response.WrongResponse;

public class PortDoesNotExistException extends Exception {
    private WrongResponse response = new WrongResponse(10005, "Port does not exists.");

    public WrongResponse getResponse() {
        return response;
    }
}