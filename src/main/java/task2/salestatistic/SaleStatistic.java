package task2.salestatistic;

import task1.salemanagement.Operation;

import java.io.*;
import java.util.*;

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
        // сделать общий метод печатанья в файл, в кач-ве пар-ра передам файл, мапу что печатать надо
        createStatisticByDate();
     //   createStatisticByOffice();
    }

  /*  private void createStatisticByOffice() {
        Map<String, Double> sortingOffices = findCommonOffices();
        FileWriter writer = null;
        try {
            writer = new FileWriter(statisticByOfficeFile);
            for (Map.Entry<String, Double> office : sortingOffices.entrySet()) {
                writer.write(office.getKey() + " " + office.getValue().toString() + System.getProperty("line.separator"));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

 /*   private Map<String, Double> findCommonOffices() {
        Map<String, Double> sortingOffices = new HashMap<>();
        for (Operation operation : operations) {
            if (sortingOffices.containsKey(operation.getSalePoint())) {
                Double newSum = sortingOffices.get(operation.getSalePoint()) + operation.getSum();
                sortingOffices.put(operation.getSalePoint(), newSum);
            } else {
                sortingOffices.put(operation.getSalePoint(), operation.getSum());
            }
        }
        return sortStatisticByOrder(sortingOffices);
    }*/

   /* private Map<String, Double> sortStatisticByOrder(Map<String, Double> sortingOffices) {
        Map<String, Double> result = new LinkedHashMap<>();
        List<Map.Entry<String, Double>> list = new ArrayList(sortingOffices.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (Map.Entry<String, Double> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }*/

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
