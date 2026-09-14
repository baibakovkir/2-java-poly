package deals;

public class Expenditure extends Deal {

    public Expenditure(String goodName, int price) {
        super("Покупка " + goodName + " на " + price + " руб.", price, 0);
    }
}
