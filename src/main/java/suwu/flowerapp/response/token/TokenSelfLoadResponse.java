package suwu.flowerapp.response.token;

import suwu.flowerapp.response.Response;

import java.util.List;

public class TokenSelfLoadResponse extends Response {
    private List<TokenItem> tokenItemList;

    public TokenSelfLoadResponse(){}

    public TokenSelfLoadResponse(List<TokenItem> _tokenItemList){
        this.tokenItemList = _tokenItemList;
    }

    public void setTokenItemList(List<TokenItem> _tokenItemList){
        this.tokenItemList = _tokenItemList;
    }

    public List<TokenItem> getTokenItemList(){
        return tokenItemList;
    }
}
