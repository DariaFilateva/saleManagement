package salemanagement;

import randomUtils.RandomUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Operation {

    private Date date;
    private String salePoint;
    private Double sum;
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");

    private static int SUM_MIN = 10000;
    private static int SUM_MAX = 100000;

    public Operation(SalePoints salePoints) {
        this.sum = createSum();
        this.salePoint = createSalePoint(salePoints);
        this.date = createDate();
    }

    public Double getSum() {
        return sum;
    }

    private String createSalePoint(SalePoints salePoints) {
        return salePoints.getRandomSalePoints();
    }

    private Double createSum() {
        return (double) RandomUtils.getRandom(SUM_MIN, SUM_MAX);
    }

    public Date createDate() {
        Date dateNow = new Date();
        int yearNow = dateNow.getYear();
        return new Date(RandomUtils.getRandom(yearNow - 1, yearNow),
                RandomUtils.getRandom(0, 12),
                RandomUtils.getRandom(1, 31),
                RandomUtils.getRandom(0, 23),
                RandomUtils.getRandom(0, 59),
                RandomUtils.getRandom(0, 59));
    }
}
