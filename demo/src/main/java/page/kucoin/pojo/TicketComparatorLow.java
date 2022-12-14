package page.kucoin.pojo;

import page.kucoin.pojo.TickerData;

import java.util.Comparator;

public class TicketComparatorLow implements Comparator<TickerData> {
    @Override
    public int compare(TickerData o1, TickerData o2) {
        float result = Float.compare(Float.parseFloat(o1.getChangeRate()), Float.parseFloat(o2.getChangeRate()));
        return (int) result;
    }
}
