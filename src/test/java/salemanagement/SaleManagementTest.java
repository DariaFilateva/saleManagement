package salemanagement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SaleManagementTest {

    private SaleManagement saleManagement;

    @BeforeClass
    public void init() throws Exception {
        SalePoints salePoints = new SalePoints("/Applications/saleManagement/src/main/resources/salepoints.txt");
        saleManagement = new SaleManagement(salePoints, "20", "report.txt");
    }

    @Test
    public void testReport() throws Exception {
        saleManagement.report();
    }

}