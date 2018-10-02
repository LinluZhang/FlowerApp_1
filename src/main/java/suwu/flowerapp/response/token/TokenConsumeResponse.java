package suwu.flowerapp.response.token;

import suwu.flowerapp.response.Response;

public class TokenConsumeResponse extends Response {
    private int tokenId;

    public TokenConsumeResponse(){}

    public TokenConsumeResponse(int _tokenId){
        this.tokenId = _tokenId;
    }

    public void setTokenId(int _tokenId){
        this.tokenId = _tokenId;
    }

    public int getTokenId(){
        return tokenId;
    }
}
