package deals;

public class Sale extends Deal {

    public Sale(String goodName, int price) {
        super("Продажа " + goodName + " на " + price + " руб.", 0, price);
    }
}
