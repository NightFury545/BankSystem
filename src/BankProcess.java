import java.util.Scanner;

public final class BankProcess {

    static public void startProcess(Person person) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Авторизуйтесь...");
        boolean isRegistered = false;
        while (!isRegistered) {
            System.out.println("Введіть Логін: ");
            String login = scanner.next();
            System.out.println("Введіть пароль: ");
            String password = scanner.next();
            if (startRegistration(login, password)) {
                person.logIn(login, password);
                isRegistered = true;
            } else {
                System.out.println("Спробуйте ще раз!");
            }
        }
        while (true) {
            System.out.println("-------------------------------------------------------");
            System.out.println("1. Створити банківську картку для облікового запису");
            System.out.println("2. Переглянути баланс облікового запису");
            System.out.println("3. Поповнити баланс облікового запису");
            System.out.println("4. Купити товар");
            System.out.println("5. Показати всю інформацію про людину, обліковий запис та банківську картку");
            System.out.println("--------------------------------------------------------");
            System.out.println("Оберіть пункт, написавши відповідну цифру:");
            int choiceMenu = scanner.nextInt();
            switch (choiceMenu) {
                case 1:
                    System.out.println("Бажаєте створити банківську картку? +/-");
                    String choice = scanner.next();
                    if (choice.equals("+")) {
                        person.addCard(new BankCard(person.getAccount()));
                        System.out.println(
                            "Банківська картка успішно створена та додана до вашого облікового запису");
                    } else {
                        break;
                    }
                    break;
                case 2:
                    System.out.println(person.getAccount().getBalance());
                    break;
                case 3:
                    System.out.println("Введіть суму для поповнення:");
                    double amount = scanner.nextDouble();
                    if (!person.getBankCards().isEmpty()) {
                        person.getBankCards().get(0).replenishTheBalance(amount);
                    } else {
                        System.out.println("У вас ще немає банківської картки!");
                    }
                    break;
                case 4:
                    Generator.showProducts();
                    System.out.println("Введіть відповідну цифру, щоб купити товар:");
                    int number = scanner.nextInt();
                    buyProducts(number, person);
                    break;
                case 5:
                    System.out.println(person.toString() + "\n" + person.getBankCards().get(0).toString());
                    break;
                default:
                    System.out.println("Ви обрали невірний пункт в меню...");
                    break;
            }
        }
    }

    private static boolean startRegistration(String login, String password) {
        if (login.length() <= 12 && !login.isEmpty()) {
            if (password.length() <= 16 && password.length() >= 8) {
                System.out.println("Обліковий запис успішно створено!");
                return true;
            } else {
                System.out.println(
                    "Пароль повинен бути меншим за 16 символів та більшим за 8 символів");
                return false;
            }
        } else {
            System.out.println("Логін повинен бути меншим за 12 символів та більшим за 1 символ");
            return false;
        }
    }


    private static void buyProducts(int number, Person person) {
        for (Product product : Generator.getProducts()) {
            if (number == product.getIndexInTheList()) {
                if (!person.getBankCards().isEmpty()) {
                    person.getBankCards().get(0)
                        .withdrawFromTheBalance(product.getPrice(), product);
                    return;
                } else {
                    System.out.println("У вас ще немає банківської картки!");
                }
            }
        }
        System.out.println("Ви ввели невірну цифру...");
    }
}
