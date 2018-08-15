package com.marketinfo.stocks;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "StockExchangeInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class StockExchangeInfo extends StockInfo{
    
    @XmlElement(name = "HighPrice")
    private String high;
    
    @XmlElement(name = "LowPrice")
    private String low;
    
    @XmlElement(name = "Price")
    private String price;
    
    public StockExchangeInfo()
    {
        
    }
    
    public StockExchangeInfo(String stockName, String latestPrice, String priceChangeInPercant, String high, String low, String price)
    {
        this.stockName = stockName;
        this.latestPrice = latestPrice;
        this.priceChangeInPercant = priceChangeInPercant;
        this.high = high;
        this.low = low;
        this.price = price;
    }
    
    public String getHigh() {
        return high;
    }
    public void setHigh(String high) {
        this.high = high;
    }
    public String getLow() {
        return low;
    }
    public void setLow(String low) {
        this.low = low;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    } 
    @Override
    public void updateValue(String val, int j) {
        switch(j)
        {
            case 0:
                this.setStockName(val);
                break;
            case 1:
                this.setLastPrice(val);
                break;
            case 2:
                this.setPriceChangeInPercant(val);
                break;
            case 3:
                this.setHigh(val);
                break;
            case 4:
                this.setLow(val);  
                break;
            case 5:
                this.setPrice(val);
                break;
        }
    }
}
