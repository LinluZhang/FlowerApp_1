package suwu.flowerapp.parameters.token;

import java.util.Date;

public class TokenBuyParameters {
    private int tokenId;
    private double price;
    private Date startDate;
    private Date endDate;

    public TokenBuyParameters(){}

    public TokenBuyParameters(int _tokenId, double _price, Date _startDate, Date _endDate){
        this.tokenId = _tokenId;
        this.price = _price;
        this.startDate = _startDate;
        this.endDate = _endDate;
    }

    public void setTokenId(int _tokenId){ this.tokenId = _tokenId; }

    public int getTokenId(){ return tokenId; }

    public void setPrice(double _price){ this.price = _price; }

    public double getPrice(){ return price; }

    public void setStartDate(Date _startDate){ this.startDate = _startDate; }

    public Date getStartDate(){ return startDate; }

    public void setEndDate(Date _endDate){ this.endDate = _endDate; }

    public Date getEndDate(){ return endDate; }
}
