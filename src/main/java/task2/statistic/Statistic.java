package task2.statistic;

import task1.salemanagement.Operation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public abstract class Statistic{

    Map<?,?> data;
    private static String DELIMITER = " ";
    protected ArrayList<Operation> operations;

    public Statistic(ArrayList<Operation> operations) {
        this.operations = operations;
    }

    public abstract Map<?, ?> createStatistic();

    public abstract Map<?, ?> sortStatistic();

    public void print(String file) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            for (Map.Entry<?, ?> entry : data.entrySet()) {
                writer.write(entry.getKey() + DELIMITER + entry.getValue() + System.getProperty("line.separator"));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
