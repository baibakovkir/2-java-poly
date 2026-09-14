import deals.Deal;
import deals.Expenditure;
import deals.Sale;
import taxes.ExpenseTaxSystem;
import taxes.IncomeTaxSystem;

public class Main {
    public static void main(String[] args) {
        Company moneyCompany = new Company("Ромашка", new IncomeTaxSystem());
        moneyCompany.shiftMoney(5000);
        moneyCompany.shiftMoney(-1500);
        moneyCompany.payTaxes();

        moneyCompany.setTaxSystem(new ExpenseTaxSystem());
        moneyCompany.shiftMoney(5000);
        moneyCompany.shiftMoney(-1500);
        moneyCompany.payTaxes();

        Deal[] deals = {
                new Sale("Ноутбук", 10000),
                new Expenditure("Кофе", 2000)
        };

        Company incomeCompany = new Company("Ромашка на доходах", new IncomeTaxSystem());
        int incomeResult = incomeCompany.applyDeals(deals);
        System.out.println("Доходы минус расходы: " + incomeResult + " руб.");
        System.out.println();

        Company expenseCompany = new Company("Ромашка доходы минус расходы", new ExpenseTaxSystem());
        int expenseResult = expenseCompany.applyDeals(deals);
        System.out.println("Доходы минус расходы: " + expenseResult + " руб.");
    }
}
