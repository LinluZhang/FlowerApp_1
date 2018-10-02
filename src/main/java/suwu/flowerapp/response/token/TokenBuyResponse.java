package suwu.flowerapp.response.token;

import suwu.flowerapp.response.Response;

public class TokenBuyResponse extends Response {
    private String info;

    public TokenBuyResponse(){}

    public TokenBuyResponse(String _info){ this.info = _info; }

    public void setInfo(String _info){ this.info = _info; }

    public String getInfo(){ return info; }
}
