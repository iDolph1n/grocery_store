import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroceryStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Product> products = new ArrayList<>();
        products.add(new Product("Молоко", 95, "Домик в деревне", 4.7));
        products.add(new Product("Хлеб", 65, "Смак", 4.9));
        products.add(new Product("Сыр", 185, "Белебеевский", 4.1));

        Cart cart = new Cart();
        RecommendationSystem recommender = new RecommendationSystem();

        while (true) {
            System.out.println("\n1. Просмотр товаров");
            System.out.println("2. Фильтровать товары");
            System.out.println("3. Добавить товар в корзину");
            System.out.println("4. Просмотреть корзину");
            System.out.println("5. Оформить заказ");
            System.out.println("6. Отследить заказ");
            System.out.println("7. Получить рекомендации");
            System.out.println("0. Выход");
            System.out.println();
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1 -> products.forEach(System.out::println);
                case 2 -> {
                    System.out.print("Введите ключевое слово для поиска: ");
                    String keyword = scanner.nextLine();
                    ProductFilter filter = new NameFilter();
                    List<Product> filtered = filter.filter(products, keyword);
                    filtered.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("Введите название товара для добавления в корзину: ");
                    String name = scanner.nextLine();
                    products.stream()
                            .filter(p -> p.getName().equalsIgnoreCase(name))
                            .findFirst()
                            .ifPresentOrElse(cart::addProduct, () -> System.out.println("Товар не найден"));
                }
                case 4 -> {
                    cart.getItems().forEach(System.out::println);
                    System.out.println("Сумма: " + cart.calculateTotal() + " руб.");
                }
                case 5 -> {
                    Order order = new Order(cart);
                    System.out.println("Заказ оформлен.");
                    order.trackOrder();
                }
                case 6 -> {
                    System.out.println("Введите название товара для рекомендаций: ");
                    String name = scanner.nextLine();
                    products.stream()
                            .filter(p -> p.getName().equalsIgnoreCase(name))
                            .findFirst()
                            .ifPresentOrElse(
                                    p -> {
                                        List<Product> rec = recommender.recommend(p, products);
                                        System.out.println("Рекомендации:");
                                        rec.forEach(System.out::println);
                                    },
                                    () -> System.out.println("Товар не найден")
                            );
                }
                case 0 -> {
                    System.out.println("Выход из программы");
                    return;
                }
                default -> System.out.println("Неверный выбор");
            }
        }
    }
}