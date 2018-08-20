package task2.statistic;

import org.testng.annotations.DataProvider;
import task1.salemanagement.Operation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StatisticTestData {

    @DataProvider(name = "operationsByDate")
    public static Iterator<Object[]> getInputData() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{getOperation1(), 1});
        data.add(new Object[]{getOperation2(), 2});
        return data.iterator();
    }

    @DataProvider(name = "operationsByOffices")
    public static Iterator<Object[]> getInputData2() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{getOperation1(), 2});
        data.add(new Object[]{getOperation2(), 4});
        return data.iterator();
    }

    public static ArrayList<Operation> getOperation1() {
        ArrayList<Operation> operations = new ArrayList<>();
        operations.add(new Operation(new Date(11111), "SP1", new Double(13000)));
        operations.add(new Operation(new Date(11111), "SP1", new Double(13000)));
        operations.add(new Operation(new Date(11111), "SP1", new Double(16000)));
        operations.add(new Operation(new Date(11111), "SP2", new Double(20000)));
        return operations;
    }

    public static ArrayList<Operation> getOperation2() {
        ArrayList<Operation> operations = new ArrayList<>();
        operations.add(new Operation(new Date(11111), "SP1", new Double(13000)));
        operations.add(new Operation(new Date(11111), "SP2", new Double(13000)));
        operations.add(new Operation(new Date(), "SP3", new Double(16000)));
        operations.add(new Operation(new Date(), "SP4", new Double(20000)));
        return operations;
    }
}
