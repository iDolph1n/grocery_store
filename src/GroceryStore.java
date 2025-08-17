import java.util.List;
import java.util.Scanner;

public class GroceryStore implements ProductFilter {
    private final List<Product> products;
    private final CartOperations cart;

    public GroceryStore(List<Product> products, CartOperations cart) {
        this.products = products;
        this.cart = cart;
    }

    @Override
    public List<Product> filterByKeyword(String keyword) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

    @Override
    public List<Product> filterByPrice(double minPrice, double maxPrice) {
        return products.stream()
                .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                .toList();
    }

    @Override
    public List<Product> filterByManufacturer(String manufacturer) {
        return products.stream()
                .filter(p -> p.getManufacturer().equalsIgnoreCase(manufacturer))
                .toList();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Меню магазина ===");
            System.out.println("1. Показать все товары");
            System.out.println("2. Фильтровать товары");
            System.out.println("3. Добавить товар в корзину");
            System.out.println("4. Удалить товар из корзины");
            System.out.println("5. Показать корзину");
            System.out.println("6. Оформить заказ");
            System.out.println("0. Выход");
            System.out.print("\nВыберите действие: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1" -> products.forEach(System.out::println);
                case "2" -> filterMenu(scanner);
                case "3" -> addToCartMenu(scanner);
                case "4" -> {
                    List<Product> items = cart.getProducts();

                    if (items.isEmpty()) {
                        System.out.println("Корзина пуста.");
                        break;
                    }

                    System.out.println("Товары в корзине:");
                    for (int i = 0; i < items.size(); i++) {
                        Product p = items.get(i);
                        System.out.println((i + 1) + ". " + p.getName() + " - " + p.getPrice() + " руб.");
                    }

                    System.out.print("\nВведите название товара для удаления: ");
                    String name = scanner.nextLine();

                    Product toRemove = null;
                    for (Product p : items) {
                        if (p.getName().equalsIgnoreCase(name)) {
                            toRemove = p;
                            break;
                        }
                    }

                    if (toRemove != null) {
                        cart.removeFromCart(toRemove);
                    } else {
                        System.out.println("Товар с таким названием не найден.");
                    }
                }
                case "5" -> showCart();
                case "6" -> checkout();
                case "0" -> {
                    System.out.println("До свидания!");
                    return;
                }
                default -> System.out.println("Неверная опция.");
            }
        }
    }

    private void filterMenu(Scanner scanner) {
        System.out.println("\nФильтровать по: \n1) Ключевое слово \n2) Цене \n3) Производителю");
        System.out.println();
        System.out.print("Выберите действие: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> {
                System.out.print("Введите ключевое слово: ");
                String keyword = scanner.nextLine();
                filterByKeyword(keyword).forEach(System.out::println);
            }
            case "2" -> {
                System.out.print("Минимальная цена: ");
                double min = Double.parseDouble(scanner.nextLine());
                System.out.print("Максимальная цена: ");
                double max = Double.parseDouble(scanner.nextLine());
                filterByPrice(min, max).forEach(System.out::println);
            }
            case "3" -> {
                System.out.print("Производитель: ");
                String manufacturer = scanner.nextLine();
                filterByManufacturer(manufacturer).forEach(System.out::println);
            }
            default -> System.out.println("Неверная опция фильтрации.");
        }
    }

    private void addToCartMenu(Scanner scanner) {
        System.out.print("Введите название товара для добавления: ");
        String name = scanner.nextLine();
        products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .ifPresentOrElse(cart::addToCart,
                        () -> System.out.println("Товар не найден."));
    }

    private void showCart() {
        System.out.println("Содержимое корзины:");
        if (cart instanceof Cart c) {
            c.getProducts().forEach(System.out::println);
        }
        System.out.println("Итоговая сумма: " + cart.calculateTotal() + " руб.");
    }

    private void checkout() {
        double total = cart.calculateTotal();
        if (total > 0) {
            System.out.println("Заказ оформлен. \nИтоговая сумма: " + total + " руб.");
        } else {
            System.out.println("Корзина пуста.");
        }
    }

    @Override
    public List<Product> filter(List<Product> products, String keyword) {
        return List.of();
    }
}