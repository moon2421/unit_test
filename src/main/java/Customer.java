import java.util.List;

public class Customer {
    private int money;
    private static final int inventory = 3; // 물건 적재 최대 개수
    private int count; // 현재 가지고 있는 물건 개수
    private List<Producer> CanbuyInventory;

    public Customer(){  //사용자는 물건을 3개만살수있음
        this.money=30000;
        this.count = 0;
    }


    public void showMoney() throws Exception {
        if(this.money <= 0)
            throw new Exception();
        System.out.println("현재 가진돈 "+money);

    }
    public int getMoney(){
        return this.money;
    }

    public int getInventory(){
        return this.inventory;
    }

}
