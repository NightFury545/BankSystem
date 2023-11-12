
import java.util.Random;

public class Account {

    private final int id = new Random().nextInt(999);
    private String login;
    private String password;
    private double balance;

    private MonetaryCurrency currency;

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    private enum MonetaryCurrency {
        USD, EUR, UAH
    }

    public double getBalance() {
        return balance;
    }

    public void addToBalance(double balance) {
        this.balance += balance;
    }

    public void subtractFromTheBalance(double balance) {
        this.balance -= balance;
    }

    @Override
    public String toString() {
        return "Логін: " + login + "; Пароль: " + password + "; ID: " + id;
    }
}
