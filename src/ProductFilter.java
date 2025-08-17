import java.util.List;

interface ProductFilter {
    List<Product> filterByKeyword(String keyword);

    List<Product> filterByPrice(double minPrice, double maxPrice);

    List<Product> filterByManufacturer(String manufacturer);

    List<Product> filter(List<Product> products, String keyword);
}