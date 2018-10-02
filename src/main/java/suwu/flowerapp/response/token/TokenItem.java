package suwu.flowerapp.response.token;

import java.util.Date;

public class TokenItem {
    private int id;
    private int credits;
    private double minLimit;
    private double price;
    private Date startDate;
    private Date endDate;

    public TokenItem(){ }

    public TokenItem(int _id, int _credits, double _minLimit, double _price, Date _startDate, Date _endDate){
        this.id = _id;
        this.credits = _credits;
        this.minLimit = _minLimit;
        this.price = _price;
        this.startDate = _startDate;
        this.endDate = _endDate;
    }

    public void setId(int _id){ this.id = _id; }

    public int getId(){ return id; }

    public void setCredits(int _credits){ this.credits = _credits; }

    public int getCredits(){ return credits; }

    public void setMinLimit( double _minLimit){ this.minLimit = _minLimit; }

    public double getMinLimit(){ return minLimit; }

    public void setPrice(double _price){ this.price = _price; }

    public double getPrice(){ return price; }

    public void setStartDate(Date _startDate){ this.startDate = _startDate; }

    public Date getStartDate(){ return startDate; }

    public void setEndDate(Date _endDate){ this.endDate = _endDate; }

    public Date getEndDate(){ return endDate; }
}

