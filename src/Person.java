import java.util.ArrayList;
import java.util.List;

public class Person {

    private final String name;
    private final int age;
    private final List<BankCard> bankCards = new ArrayList<>();
    private Account account;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void logIn(String login, String password) {
        this.account = new Account(login, password);
    }

    public void logOut() {
        this.account = null;
    }

    public void addCard(BankCard bankCard) {
        bankCards.add(bankCard);
    }

    public void addCard(Account account) {
        bankCards.add(new BankCard(account));
    }

    public void showbankCards() {
        for (BankCard bankCard : this.bankCards) {
            System.out.println(bankCard.toString());
        }
    }

    public List<BankCard> getBankCards() {
        return bankCards;
    }

    public Account getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        if (this.account != null) {
            return "-> Ім'я людини: " + name + "; Вік людини: " + age + "\n"
                + "Цій людині належить обліковий запис: " + account.toString() + " <-";
        } else {
            return "-> Ім'я людини: " + name + "; Вік людини: " + age + "\n"
                + "В цієї людини немає облікового запису <-";
        }
    }
}
