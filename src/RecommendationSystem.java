import java.util.List;
import java.util.stream.Collectors;

class RecommendationSystem {
    public List<Product> recommend(Product product, List<Product> allProducts) {
        return allProducts.stream()
                .filter(p -> !p.equals(product) && p.getManufacturer().equals(product.getManufacturer()))
                .collect(Collectors.toList());
    }
}