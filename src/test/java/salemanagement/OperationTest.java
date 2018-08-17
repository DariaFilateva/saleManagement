package salemanagement;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

public class OperationTest {

   @Mock
   SalePoints salePoints;


    @Test
    public void testConstructor() throws Exception {
        Operation operation = new Operation(salePoints);
       Assert.assertNotNull(operation.getSum());

    }


}