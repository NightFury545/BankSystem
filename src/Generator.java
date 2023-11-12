import java.util.ArrayList;
import java.util.List;

public class Generator {

    private static final int countOfPersons = 5;
    private static final int countOfAccounts = 5;
    private static final int countOfBankCards = 5;

    private static final List<Product> products = new ArrayList<>();

    public static void generate() {
        for (int i = 0; i < countOfPersons; i++) {
            System.out.println(new Person("Руслан" + i, 13 + i));
        }

        for (int i = 0; i < countOfAccounts; i++) {
            System.out.println(new Account("account" + i, "password" + i));
        }

        for (int i = 0; i < countOfBankCards; i++) {
            System.out.println(new BankCard());
        }

        showProducts();
    }

    public static void showProducts() {
        makeProducts();
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    private static void makeProducts() {
        products.add(new Product("Макарони", 55, 1));
        products.add(new Product("Пельмені", 45, 2));
        products.add(new Product("Вареники", 30, 3));
        products.add(new Product("Гречка", 150, 4));
        products.add(new Product("Сіль", 5, 5));
        products.add(new Product("Цукор", 10, 6));
        products.add(new Product("Паста", 60, 7));
        products.add(new Product("Риба", 195, 8));
        products.add(new Product("М'ясо", 190, 9));
        products.add(new Product("Рис", 75, 10));
    }

    public static List<Product> getProducts() {
        return products;
    }
}
