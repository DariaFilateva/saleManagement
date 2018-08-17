package salemanagement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaleManagement {

    private String pathReportFile;
    private List<Operation> operations;

    public SaleManagement(SalePoints salePoints, String operationCount, String pathReportFile) {
        this.pathReportFile = pathReportFile;
        this.operations = createOperations(operationCount, salePoints);
    }

    private List<Operation> createOperations(String operationCount, SalePoints salePoints) {
        int operationsCount = new Integer(operationCount);
        List<Operation> operations = new ArrayList<>();
        for (int i = 0; i < operationsCount; i++) {
            Operation operation = new Operation(salePoints);
            operations.add(operation);
        }
        return operations;
    }

    public void report() {
        FileWriter writer = null;
        try {
            writer = new FileWriter(pathReportFile);
            int i = 1;
            for (Operation operation : operations) {
                writer.write(i + operation.toString() + System.getProperty("line.separator"));
                i++;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
