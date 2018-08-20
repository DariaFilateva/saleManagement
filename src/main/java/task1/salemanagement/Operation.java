package task1.salemanagement;

import task1.randomUtils.RandomUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Operation {

    private Date date;
    private String salePoint;
    private Double sum;
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy-hh:mm");
    private static String PATTERN_TO_REPORT = "%s %s %s";
    private static String DELIMITER = " ";

    private static int SUM_MIN = 10000;
    private static int SUM_MAX = 100000;

    public Operation(SalePoints salePoints) {
        this.sum = createSum();
        this.salePoint = createSalePoint(salePoints);
        this.date = createDate();
    }

    public Operation(Date date, String salePoint, Double sum) {
        this.date = date;
        this.salePoint = salePoint;
        this.sum = sum;
    }

    public Operation(String stringFromFile) {
        String[] dataToOperation = stringFromFile.split(DELIMITER);
        try {
            this.date = format.parse(dataToOperation[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.salePoint = dataToOperation[2];
        this.sum = new Double(dataToOperation[3]);
    }

    @Override
    public String toString() {
        return String.format(PATTERN_TO_REPORT, format.format(date), salePoint, sum.toString());
    }

    public Date getDate() {
        return date;
    }

    public String getSalePoint() {
        return salePoint;
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

