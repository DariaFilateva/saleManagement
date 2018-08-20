package task2.salestatistic;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import task1.salemanagement.SaleManagement;
import task1.salemanagement.SalePoints;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
        File statisticByDate = new File("statisticByDate.txt");
        File statisticByOffice = new File("statisticByOffice.txt");
        Assert.assertTrue(statisticByDate.exists());
        Assert.assertTrue(statisticByOffice.exists());
    }
}
