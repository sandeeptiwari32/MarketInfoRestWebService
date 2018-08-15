package com.marketinfo.stocks;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "StockExchangeInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class StockInfo {
    
    @XmlElement(name = "StockName")
    public String stockName;
    
    @XmlElement(name = "CurrentPrice")
    public String latestPrice;
    
    @XmlElement(name = "PriceChange")
    private String priceChange;
    
    @XmlElement(name = "PriceChangeInPercant")
    public String priceChangeInPercant;
    
    @XmlElement(name = "Price")
    private String price;
    
    public StockInfo()
    {
        
    }
    
    public StockInfo(String stockName, String latestPrice, String priceChange, String priceChangeInPercant, String high, String low, String price)
    {
        this.stockName = stockName;
        this.latestPrice = latestPrice;
        this.priceChange = priceChange;
        this.priceChangeInPercant = priceChangeInPercant;
        this.price = price;
    }
    
    public String getStockName() {
        return stockName;
    }
    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
    public String getLastPrice() {
        return latestPrice;
    }
    public void setLastPrice(String latestPrice) {
        this.latestPrice = latestPrice;
    }
    public String getPriceChange() {
        return priceChange;
    }
    public void setPriceChange(String priceChange) {
        this.priceChange = priceChange;
    }
    
    public String getPriceChangeInPercant() {
        return priceChangeInPercant;
    }
    public void setPriceChangeInPercant(String priceChangeInPercant) {
        this.priceChangeInPercant = priceChangeInPercant;
    }
    
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    
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
                this.setPriceChange(val);
                break;
            case 3:
                this.setPriceChangeInPercant(val);  
                break;
            case 4:
                this.setPrice(val);
                break;
        }
    }
}
