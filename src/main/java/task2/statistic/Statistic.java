package task2.statistic;

import task1.salemanagement.Operation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public abstract class Statistic {


    private static String DELIMITER = " ";


    protected ArrayList<Operation> operations;
    protected Map<?, ?> data;
    protected String fileToStatistic;

    public Statistic(ArrayList<Operation> operations, String fileToStatistic) {
        this.operations = operations;
        this.fileToStatistic = fileToStatistic;
    }

    protected abstract Map<?, ?> createStatistic();

    protected abstract Map<?, ?> sortStatistic();

    public void print() {
        data = this.sortStatistic();
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileToStatistic);
            for (Map.Entry<?, ?> entry : data.entrySet()) {
                writer.write(entry.getKey() + DELIMITER + entry.getValue() + System.getProperty("line.separator"));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<?, ?> getData() {
        return data;
    }
}
