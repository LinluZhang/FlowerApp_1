package suwu.flowerapp.entity.token;

import suwu.flowerapp.publicdatas.token.TokenState;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "token")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "startDate")
    private TokenState tokenState;

    @Column(name = "credits")
    private int credits;

    @Column(name = "minLimit")
    private double minLimit;

    @Column(name = "price")
    private double price;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    public Token(){

    }

    public Token(TokenState _tokenState, int _credits, double _minLimit, double _price, Date _startDate, Date _endDate){
        this.tokenState = _tokenState;
        this.credits = _credits;
        this.minLimit = _minLimit;
        this.price = _price;
        this.startDate = _startDate;
        this.endDate = _endDate;
    }

    public void setId(int _id){ this.id = _id; }

    public int getId(){ return id; }

    public void setTokenState(TokenState _tokenState){ this.tokenState = _tokenState; }

    public TokenState getTokenState(){ return tokenState; }

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
