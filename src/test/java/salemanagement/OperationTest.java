package salemanagement;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class OperationTest {

    private SalePoints salePoints;

    @BeforeClass
    public void init() throws Exception {
        salePoints = new SalePoints("/Applications/saleManagement/src/main/resources/salepoints.txt");
    }


    @Test
    public void testConstructor() throws Exception {
        Operation operation = new Operation(salePoints);
        Assert.assertNotNull(operation.toString());
    }

}