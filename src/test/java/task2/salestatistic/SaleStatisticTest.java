package task2.salestatistic;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import task1.salemanagement.SaleManagement;
import task1.salemanagement.SalePoints;

import static org.testng.Assert.*;

public class SaleStatisticTest {

    private SaleStatistic saleStatistic;

    @BeforeClass
    public void init() throws Exception {
        saleStatistic = new SaleStatistic("report.txt", "statisticByDate.txt", "statisticByOffice.txt");
    }

    @Test
    public void testReport() throws Exception {
        saleStatistic.report();
    }

}