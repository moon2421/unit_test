public class Producer {
    private static int money = 0;
    Cloth cloth=new Cloth();
    Fruit fruit=new Fruit();
    Cellphone cellphone =new Cellphone();



    class Cloth{
        int price=2000;
        int stock=50;
    }
    class Fruit{
        int price=500;
        int stock=10;
    }
    class Cellphone{
        int price=5000;
        int stock=5;
    }

    public static int getMoney() {
        return money;
    }
    public void sellCellPhone(int num) {
        this.cellphone.stock -= num;
        this.money += (5000 * num);
    }
    public void sellCloth(int num) {
        this.cloth.stock -= num;
        this.money += (2000 * num);
    }
    public void sellFruit(int num) {
        this.fruit.stock -= num;
        this.money += (500 * num);
    }
}
