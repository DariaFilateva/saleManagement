package task1.salemanagement;

import task1.randomUtils.RandomUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Operation {

    private Date date;
    private String salePoint;
    private Double sum;
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
    private static String PATTERN_TO_REPORT = "%s %s %s";

    private static int SUM_MIN = 10000;
    private static int SUM_MAX = 100000;

    public Operation(SalePoints salePoints) {
        this.sum = createSum();
        this.salePoint = createSalePoint(salePoints);
        this.date = createDate();
    }

    @Override
    public String toString() {
        return String.format(PATTERN_TO_REPORT, format.format(date), salePoint, sum.toString());
    }

    private String createSalePoint(SalePoints salePoints) {
        return salePoints.getRandomSalePoints();
    }

    private Double createSum() {
        return (double) RandomUtils.getRandom(SUM_MIN, SUM_MAX);
    }

    private Date createDate() {
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

