import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Молоко", 95, "\"Домик в деревне\"", 4.7),
                new Product("Хлеб", 65, "\"Смак\"", 4.9),
                new Product("Сыр", 185, "\"Белебеевский\"", 4.1)
        );

        CartOperations cart = new Cart();
        GroceryStore shop = new GroceryStore(products, cart);
        shop.start();
    }
}