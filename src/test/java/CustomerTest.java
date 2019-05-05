import org.junit.Test;

import static org.hamcrest.Matchers.is;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.junit.Assert.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

//소비자가 최대 3개를 살수있음
public class CustomerTest {
    //소비자의 가방의 개수가 0인지확인
    @Test
    public void CustomorInventoryISZero(){
        Customer customer =new Customer();
        assertThat(customer.getInventory(),is(3));
    }

}