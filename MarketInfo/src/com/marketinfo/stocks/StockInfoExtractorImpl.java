package com.marketinfo.stocks;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Path("/stockinfo")
public class StockInfoExtractorImpl implements StockInfoExtractor {
    private String URL = "https://www.moneycontrol.com/stocks/marketinfo/";
    @Override
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/{marketType}")
    public ArrayList<StockInfo> getInfoByStockExchange(@PathParam("marketType") String marketType ) {
        try {
            StringBuffer buffURL = new StringBuffer(URL);
            buffURL.append("marketcap/").append(marketType).append("/index.html");
            return this.getAllStockInfo(buffURL,StockFactory.STOCK_EXCHANGE_INFO);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/{cri}/{marketType}/{sec}")
    public ArrayList<StockInfo> getInfoBySectorType(@PathParam("cri") String cri, @PathParam("marketType") String marketType , @PathParam("sec") String sec ) {
        try {
            StringBuffer buffURL = new StringBuffer(URL);
            buffURL.append(cri+"/").append(marketType).append("/"+sec+".html");
            return this.getAllStockInfo(buffURL,StockFactory.STOCK_MARKET_INFO);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    private ArrayList<StockInfo> getAllStockInfo(StringBuffer buffURL, String type) throws IOException {
        ArrayList<StockInfo> stocklLst = new ArrayList<>(); 
        Document doc = Jsoup.connect(buffURL.toString()).get();
        Elements element = doc.getElementsByClass("tbldata14 bdrtpg").get(0).getElementsByTag("tr");
        for(int i = 1;i<element.size();i++)
        {
            StockInfo si = StockFactory.getInstance(type);
            Element siElement = element.get(i);
            Elements tdElement = siElement.getElementsByTag("td");
            for(int j = 0;j<tdElement.size();j++)
            {
                String val;
                if(j==0)
                    val = tdElement.get(j).getElementsByTag("b").get(0).childNode(0).toString();
                else
                    val = tdElement.get(j).childNode(0).toString();
                si.updateValue(val, j);
            }
            stocklLst.add(si);
        }
        return stocklLst;
    }
}
