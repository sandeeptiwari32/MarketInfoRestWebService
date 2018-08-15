package com.marketinfo.stocks;

public class StockFactory {
    public static final String STOCK_MARKET_INFO = "STOCK_MARKET_INFO";
    public static final String STOCK_EXCHANGE_INFO = "STOCK_EXCHNAGE_INFO";
    
    public static StockInfo getInstance(String type)
    {
        if(STOCK_MARKET_INFO.equalsIgnoreCase(type))
        {
            return new StockInfo();
        }
        if(STOCK_EXCHANGE_INFO.equalsIgnoreCase(type))
        {
            return new StockExchangeInfo();
        }
        return null; 
    }
}
