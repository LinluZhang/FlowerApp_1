package suwu.flowerapp.exception;


import suwu.flowerapp.response.WrongResponse;

public class SystemException extends Exception {
    private WrongResponse response = new WrongResponse(10001, "System is error.");

    public WrongResponse getResponse() {
        return response;
    }
}
