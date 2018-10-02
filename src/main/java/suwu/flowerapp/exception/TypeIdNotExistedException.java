package suwu.flowerapp.exception;

import suwu.flowerapp.response.WrongResponse;

public class TypeIdNotExistedException extends Exception{
    private WrongResponse response = new WrongResponse(10004, "Flower type is not existed.");

    public WrongResponse getResponse() {
        return response;
    }
}
