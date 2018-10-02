package suwu.flowerapp.exception;

import suwu.flowerapp.response.WrongResponse;

public class FlowerTypeIdNotExistedException extends Exception {
    private WrongResponse response = new WrongResponse(10031, "Flower type is not existed.");

    public WrongResponse getResponse() {
        return response;
    }
}
