class Order {
    private Cart cart;
    private String status;

    public Order(Cart cart) {
        this.cart = cart;
        this.status = "Создан";
    }

    public void trackOrder() {
        System.out.println("Статус заказа: " + status);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cart getCart() {
        return cart;
    }
}