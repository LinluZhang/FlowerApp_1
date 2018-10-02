package suwu.flowerapp.response.flower;

import suwu.flowerapp.response.Response;

public class FlowerPostResponse extends Response {
    private String info;

    public FlowerPostResponse(){}

    public FlowerPostResponse(String _info){ this.info = _info; }

    public void setInfo(String _info){ this.info = _info; }

    public String getInfo(){ return info; }
}
