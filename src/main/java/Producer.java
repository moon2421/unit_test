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
}
