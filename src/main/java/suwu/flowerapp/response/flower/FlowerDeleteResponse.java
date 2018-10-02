package suwu.flowerapp.response.flower;

import suwu.flowerapp.response.Response;

public class FlowerDeleteResponse extends Response {
    private String info;

    public FlowerDeleteResponse(){}

    public FlowerDeleteResponse(String _info){ this.info = _info; }

    public void setIfo(String _info){ this.info = _info; }

    public String getInfo(){ return info; }
}
