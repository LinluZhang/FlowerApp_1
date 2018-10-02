package suwu.flowerapp.response.token;

import suwu.flowerapp.response.Response;

public class TokenDeleteResponse extends Response {
    private int tokenId;

    public TokenDeleteResponse(){}

    public TokenDeleteResponse(int _tokenId){
        this.tokenId = _tokenId;
    }

    public void setTokenId(int _tokenId){
        this.tokenId = _tokenId;
    }

    public int getTokenId(){
        return tokenId;
    }
}
