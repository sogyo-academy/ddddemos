package demos.oop.order.anemic;

class OrderLine {
    private String productId;
    private int amount;

    public OrderLine(String productId, int amount) {
        this.productId = productId;
        this.amount = amount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
