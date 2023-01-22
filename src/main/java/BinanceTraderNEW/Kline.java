package BinanceTraderNEW;

public class Kline {
    public long openTime;
    public double openPrice;
    public double highPrice;
    public double lowPrice;
    public double closePrice;
    public double volume;
    public long closeTime;
    public double quoteVolume;
    public int numTrades;
    public double takerBaseAssetVolume;
    public double takerBuyQuoteAssetVolume;

    public Kline(String openTime, String openPrice, String highPrice, String lowPrice, String closePrice, String volume, String closeTime, String quoteVolume, String numTrades, String takerBaseAssetVolume, String takerBuyQuoteAssetVolume) {
        this.openTime = Long.parseLong(openTime);
        this.openPrice = Double.parseDouble(openPrice);
        this.highPrice = Double.parseDouble(highPrice);
        this.lowPrice = Double.parseDouble(lowPrice);
        this.closePrice = Double.parseDouble(closePrice);
        this.volume = Double.parseDouble(volume);
        this.closeTime = Long.parseLong(closeTime);
        this.quoteVolume = Double.parseDouble(quoteVolume);
        this.numTrades = Integer.parseInt(numTrades);
        this.takerBaseAssetVolume = Double.parseDouble(takerBaseAssetVolume);
        this.takerBuyQuoteAssetVolume = Double.parseDouble(takerBuyQuoteAssetVolume);
    }
}