package task2.salestatistic;

import task1.salemanagement.Operation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SaleStatistic {

    private String statisticByDateFile;
    private String statisticByOfficeFile;

    private List<Operation> operations;

    public SaleStatistic(String reportFile, String statisticByDateFile, String statisticByOfficeFile) {
        this.operations = getOperationFromFile(reportFile);
        this.statisticByDateFile = statisticByDateFile;
        this.statisticByOfficeFile = statisticByOfficeFile;
    }

    public void report() {
        createStatisticByDate();
        createStatisticByOffice();
    }

    private void createStatisticByOffice() {
    }

    private void createStatisticByDate() {
    }

    private List<Operation> getOperationFromFile(String reportFile) {
        List<Operation> operations = new ArrayList<>();
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
