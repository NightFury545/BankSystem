
public class BankCard {

    private Account account;

    public BankCard(Account account) {
        this.account = account;
    }

    public BankCard() {
    }

    public void replenishTheBalance(double amount) {
        if (this.account != null) {
            this.account.addToBalance(amount);
            System.out.println("На ваш баланс було додано " + amount + " гривень");
            System.out.println("Поточна сума грошей на вашому балансі: " + account.getBalance());
        } else {
            System.out.println("Неможливо поповнити баланс: карточка не пов'язана з обліковим записом");
        }
    }

    public void withdrawFromTheBalance(double amount, Product product) {
        if (this.account != null) {
            if (this.account.getBalance() > amount) {
                this.account.subtractFromTheBalance(amount);
                System.out.println("Ви купили " + product.getProductName());
                System.out.println("З вашого балансу було знято " + amount + " гривень");
                System.out.println("Поточна сума грошей на вашому балансі: " + account.getBalance());
            } else {
                System.out.println("На балансі недостатньо грошей...");
            }
        } else {
            System.out.println("Неможливо зняти з балансу: карточка не пов'язана з обліковим записом");
        }
    }

    @Override
    public String toString() {
        if (account != null) {
            return "Банківська картка належить обліковому запису: " + account.toString();
        } else {
            return "Банківська картка не належить жодному обліковому запису...";
        }
    }
}
