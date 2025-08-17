import java.util.List;

public interface CartOperations {
    void addToCart(Product product);      // Добавить товар в корзину

    void removeFromCart(Product product); // Удалить товар из корзины

    double calculateTotal();              // Посчитать итоговую сумму

    List<Product> getProducts();
}