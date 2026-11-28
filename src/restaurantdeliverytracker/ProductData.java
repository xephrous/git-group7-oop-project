package restaurantdeliverytracker;

import java.util.ArrayList;
import java.util.List;

public class ProductData {

    private static final List<Product> products = new ArrayList<>();

    public static void addProduct(Product product) {
        products.add(product);
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static void removeProduct(String productId) {
        products.removeIf(product -> product.getProductId().equals(productId));
    }
}
