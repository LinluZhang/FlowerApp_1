package suwu.flowerapp.response.user;

import suwu.flowerapp.response.Response;

public class PhoneNumberGetResponse extends Response {
    private String phoneNumber;

    public PhoneNumberGetResponse() {
    }

    public PhoneNumberGetResponse(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
