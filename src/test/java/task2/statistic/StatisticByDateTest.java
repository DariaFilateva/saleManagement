package task2.statistic;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import task1.salemanagement.Operation;
import task1.salemanagement.SalePoints;
import task2.salestatistic.SaleStatistic;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class StatisticByDateTest {

    @Test(dataProvider = "operationsByDate", dataProviderClass = StatisticTestData.class)
    public void testCreateStatistic(ArrayList<Operation> operations, int expectedSize) throws Exception {
        Statistic statistic = new StatisticByDate(operations, "statisticByDateTest.txt");
        Assert.assertEquals(statistic.getData().size(), expectedSize);
    }
}