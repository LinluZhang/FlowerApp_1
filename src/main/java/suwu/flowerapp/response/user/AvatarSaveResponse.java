package suwu.flowerapp.response.user;

import suwu.flowerapp.response.Response;

public class AvatarSaveResponse extends Response {
    private String info;

    public AvatarSaveResponse() {
        this.info = "success";
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
