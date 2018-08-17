package salemanagement;

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

    public String getPathReportFile() {
        return pathReportFile;
    }

    public void setPathReportFile(String pathReportFile) {
        this.pathReportFile = pathReportFile;
    }

    public void report() {

    }

}
