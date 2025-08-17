import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart implements CartOperations {
    private final List<Product> products = new ArrayList<>();

    @Override
    public void addToCart(Product product) {
        products.add(product);
        System.out.println(product.getName() + " добавлен в корзину.");
    }

    @Override
    public void removeFromCart(Product product) {
        if (products.remove(product))
            System.out.println(product.getName() + " удалён из корзины.");
    }

    @Override
    public double calculateTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}