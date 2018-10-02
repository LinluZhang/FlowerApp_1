package suwu.flowerapp.response.token;

import suwu.flowerapp.response.Response;

public class TokenAddResponse extends Response {
    private int tokenId;

    public TokenAddResponse(){}

    public TokenAddResponse(int _tokenId){
        this.tokenId = _tokenId;
    }

    public void setTokenId(int _tokenId){
        this.tokenId = _tokenId;
    }

    public int getTokenId(){
        return tokenId;
    }
}
