package demos.oop.order.nohiding;

class OrderLine {
    private String productId;
    private int amount;

    public OrderLine(String productId, int amount) {
        this.productId = productId;
        this.amount = amount;
    }

    public void validate() {
        if (this.amount <= 0 || this.amount > 10) {
            throw new RuntimeException("Order line amount must be positive and at most 10");
        }
    }

    public void add(int extraAmount) {
        int newAmount = this.amount + extraAmount;
        if (extraAmount <= 0) {
            throw new RuntimeException("Amount to increase must be positive");
        } else {
            this.amount = newAmount;
            this.validate();
        }
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
