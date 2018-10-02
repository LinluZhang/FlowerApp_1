package suwu.flowerapp.exception;

import suwu.flowerapp.response.WrongResponse;

public class CannotGetFlowerTypesException extends  Exception{
    private WrongResponse response = new WrongResponse(10017, "Cannot get flower types");

    public WrongResponse getResponse() {
        return response;
    }

}
