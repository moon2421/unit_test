import org.junit.Test;

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
    @Test(expected = Exception.class)
    public void moneyTesting() throws Exception {
        // customer의 돈이 0원 이하인 경우 Exception이 제대로 발생하는지 확인
        Customer customer = new Customer();
        customer.spendMoney(30000);
        customer.showMoney();
    }
    @Test(expected = IllegalAccessException.class)
    public void overMoneySpend() throws IllegalAccessException {
        Customer customer = new Customer();
        customer.spendMoney(100000);
    }
    @Test //Customer가 휴대폰을 살수있는지 없는지 금액확인
    public void CustomorIsBuyCellphone(){
        Customer customer =new Customer();
        Producer p=new Producer();
        assertThat(customer.getMoney(), greaterThanOrEqualTo(p.cellphone.price));
    }

    @Test //Customer가 옷을 살수있는지 없는지 금액확인
    public void CustomorIsBuyCloth(){
        Customer customer =new Customer();
        Producer p=new Producer();
        assertThat(customer.getMoney(), greaterThanOrEqualTo(p.cloth.price));
    }

    @Test //Customer가 과일을 살수있는지 없는지 금액확인
    public void CustomorIsBuyFruit(){
        Customer customer =new Customer();
        Producer p=new Producer();
        assertThat(customer.getMoney(), greaterThanOrEqualTo(p.fruit.price));
    }


    @Test //Customer의 Inventory가 3개이하인지 확인 최대 3개살수있으므로
    public void CustomeorIsLessThree(){
        Customer customer=new Customer();
        assertThat(customer.getInventory(),lessThanOrEqualTo(3));
    }


    //집이 다팔렸는지 확인
    @Test
    public void HouseIsSoldOut(){
        Producer p = new Producer();
        p.sellCellPhone(1);
        assertThat(p.cellphone.stock,is(4)); // 5개 중 1개가 팔림을 확인(Money + 5000)
        p.sellCloth(5);
        assertThat(p.cloth.stock, is(45)); // 50 - 5 = 45 (Money + 10000)
        p.sellFruit(10);
        assertThat(p.fruit.stock, is(0)); // 10 - 10 = 0 (Money + 5000)
        assertTrue(p.getMoney() == 20000);
    }
    @Test
    public void testingMockObject() throws IllegalAccessException { // mock 객체를 이용해 spendMoney함수가 5번 호출되는지 확인
        Customer customer = mock(Customer.class);
        customer.spendMoney(100);
        customer.spendMoney(10000);
        customer.spendMoney(1500);
        customer.spendMoney(3100);
        customer.spendMoney(2100);
        verify(customer, times(5)).spendMoney(anyInt());
    }

    @Test
    public void onlyReturnTwoCount() {  // Customer클래스의 getCount 함수 실행시 반드시 2를 반환하는지 확인
        Customer customer = mock(Customer.class);
        when(customer.getCount()).thenReturn(2);
        assertTrue(customer.getCount()==2);
    }

    @Test(expected = IllegalAccessException.class)
    public void checkFullInventory() throws IllegalAccessException {
        Customer customer = new Customer();
        customer.spendMoney(5000);
        customer.spendMoney(2000);
        customer.spendMoney(16000);
        customer.spendMoney(1000);
    }

    @Test(expected = RuntimeException.class)
    public void testDoThrow() throws IllegalAccessException {
        // 0을 입력시 IllegalArgumentException 발생
        Customer customer = mock(Customer.class);
        doThrow(new RuntimeException()).when(customer).spendMoney(0);
        customer.spendMoney(0);
    }

    @Test
    public void testMockVerifyWithTimes() { // 해당 함수 몇번 호출 했는지 확인
        Producer producer = mock(Producer.class);
        producer.sellFruit(5);
        producer.sellFruit(3);
        producer.sellCellPhone(2);
        producer.sellCloth(2);
        verify(producer, times(2)).sellFruit(anyInt()); // 몇개를 팔았는지에 상관없이 sellFruit 함수 호출 횟수가 2번이 맞는지 확인
    }

}