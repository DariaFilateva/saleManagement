package task2.salestatistic;

import task1.salemanagement.Operation;
import task2.statistic.Statistic;
import task2.statistic.StatisticByDate;
import task2.statistic.StatisticByOffice;

import java.io.*;
import java.util.*;

public class SaleStatistic {

    private Statistic statisticByDate;
    private Statistic statisticByOffice;

    private ArrayList<Operation> operations;

    public SaleStatistic(String reportFile, String statisticByDateFile, String statisticByOfficeFile) {
        this.operations = getOperationFromFile(reportFile);
        statisticByDate = new StatisticByDate(operations, statisticByDateFile);
        statisticByOffice = new StatisticByOffice(operations, statisticByOfficeFile);
    }

    public void report() {
        statisticByOffice.print();
        statisticByDate.print();
    }

    private ArrayList<Operation> getOperationFromFile(String reportFile) {
        ArrayList<Operation> operations = new ArrayList<>();
        try {
            FileInputStream fstream = new FileInputStream(reportFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                operations.add(new Operation(strLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return operations;
    }
}
