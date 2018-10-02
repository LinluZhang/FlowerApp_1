package suwu.flowerapp.exception;

import suwu.flowerapp.response.WrongResponse;

public class FlowerIdNotExistedException extends Exception {
    private WrongResponse response = new WrongResponse(10022, "Flower id is not existed.");

    public WrongResponse getResponse() {
        return response;
    }
}
