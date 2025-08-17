import java.util.List;
import java.util.stream.Collectors;

class NameFilter implements ProductFilter {
    @Override
    public List<Product> filter(List<Product> products, String keyword) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}