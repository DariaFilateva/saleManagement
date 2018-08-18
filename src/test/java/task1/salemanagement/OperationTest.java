package task1.salemanagement;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OperationTest {

    private SalePoints salePoints;

    @BeforeClass
    public void init() throws Exception {
        salePoints = new SalePoints("/Applications/saleManagement/src/task1.main/resources/salepoints.txt");
    }


    @Test
    public void testConstructor() throws Exception {
        Operation operation = new Operation(salePoints);
        Assert.assertNotNull(operation.toString());
    }

    @Test
    public void testConstructorFromFile() throws Exception {
        Operation operation = new Operation("1 01.01.2018-06:29 SP4 71604.0");
        Assert.assertNotNull(operation);
    }

}