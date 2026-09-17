import deals.Deal;
import taxes.TaxSystem;

public class Company {
    private final String title;
    private TaxSystem taxSystem;
    private int debit = 0;
    private int credit = 0;

    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public void shiftMoney(int amount) {
        if (amount > 0) {
            debit += amount;
        } else if (amount < 0) {
            credit += Math.abs(amount);
        }
    }

    public void payTaxes() {
        int tax = taxSystem.calcTaxFor(this.debit, this.credit);
        System.out.println("Компания " + this.title + " уплатила налог в размере: " + tax + " руб.");
        this.debit = 0;
        this.credit = 0;
    }

    public int applyDeals(Deal[] deals) {
        int totalCreditChange = 0;
        int totalDebitChange = 0;
        for (Deal deal : deals) {
            totalCreditChange += deal.getCreditChange();
            totalDebitChange += deal.getDebitChange();
        }
        credit += totalCreditChange;
        debit += totalDebitChange;
        int totalDebit = debit;
        int totalCredit = credit;
        payTaxes();
        return totalDebit - totalCredit;
    }
}
