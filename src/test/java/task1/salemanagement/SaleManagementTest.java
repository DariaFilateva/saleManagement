package task1.salemanagement;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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

        List<String> report = new ArrayList<>();
        try {
            FileInputStream fstream = new FileInputStream("report.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                report.add(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(report.size(), 20);
    }


}