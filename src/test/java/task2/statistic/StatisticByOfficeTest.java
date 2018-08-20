package task2.statistic;

import org.testng.Assert;
import org.testng.annotations.Test;
import task1.salemanagement.Operation;

import java.util.ArrayList;

public class StatisticByOfficeTest {

    @Test(dataProvider = "operationsByOffices", dataProviderClass = StatisticTestData.class)
    public void testCreateStatistic(ArrayList<Operation> operations, int expectedSize) throws Exception {
        Statistic statistic = new StatisticByOffice(operations, "statisticByDateTest.txt");
        Assert.assertEquals(statistic.getData().size(), expectedSize);
    }
}