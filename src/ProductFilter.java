import java.util.List;

interface ProductFilter {
    List<Product> filter(List<Product> products, String keyword);
}