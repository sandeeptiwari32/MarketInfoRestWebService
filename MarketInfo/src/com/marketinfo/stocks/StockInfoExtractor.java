package com.marketinfo.stocks;

import java.util.ArrayList;

public interface StockInfoExtractor {
    public ArrayList<StockInfo> getInfoByStockExchange(String cri, String marketType);
    public ArrayList<StockInfo> getInfoBySectorType(String cri, String marketType, String sec);
    
}
