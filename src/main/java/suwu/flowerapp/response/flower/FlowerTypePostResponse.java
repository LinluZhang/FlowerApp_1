package suwu.flowerapp.response.flower;

import suwu.flowerapp.response.Response;

public class FlowerTypePostResponse extends Response {
    private String info;

    public FlowerTypePostResponse(){}

    public FlowerTypePostResponse(String _info){ this.info = _info; }

    public void setInfo(String _info){ this.info = _info; }

    public String getInfo(){ return info; }
}
