package suwu.flowerapp.response.token;

import java.util.Date;

public class SimpleTokenItem {
    private int id;
    private double price;
    private Date startDate;
    private Date endDate;

    public SimpleTokenItem(){}

    public SimpleTokenItem(int _id, double _price, Date _startDate, Date _endDate){
        this.id = _id;
        this.price = _price;
        this.startDate = _startDate;
        this.endDate = _endDate;
    }

    public void setId(int _id){ this.id = _id; }

    public int getId(){ return id; }

    public void setPrice(double _price){ this.price = _price; }

    public double getPrice(){ return price; }

    public void setStartDate(Date _startDate){ this.startDate = _startDate; }

    public Date getStartDate(){ return startDate; }

    public void setEndDate(Date _endDate){ this.endDate =_endDate; }

    public Date getEndDate(){ return endDate; }
}
