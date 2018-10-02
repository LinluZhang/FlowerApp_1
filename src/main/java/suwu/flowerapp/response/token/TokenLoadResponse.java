package suwu.flowerapp.response.token;

import suwu.flowerapp.response.Response;
import java.util.List;

public class TokenLoadResponse extends Response {
    private List<SimpleTokenItem> simpleTokenItems;

    public TokenLoadResponse(){}

    public TokenLoadResponse(List<SimpleTokenItem> _simpleTokenItems){
        this.simpleTokenItems = _simpleTokenItems;
    }

    public void setSimpleTokenItems(List<SimpleTokenItem> _simpleTokenItems){
        this.simpleTokenItems = _simpleTokenItems;
    }

    public List<SimpleTokenItem> getSimpleTokenItems(){
        return simpleTokenItems;
    }
}
