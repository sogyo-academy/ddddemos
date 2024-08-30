package demos.oop.order.anemic;

class OrderLineService {

    private OrderLine orderLine;

    public OrderLineService(OrderLine orderLine) {
        this.orderLine = orderLine;
    }

    public void validate() {
        if (this.orderLine.getAmount() <= 0 || this.orderLine.getAmount() > 10) {
            throw new RuntimeException("Order line exceeds the maximum amount");
        }
    }

    public void addToOrderLine(int extraAmount) {
        int newAmount = this.orderLine.getAmount() + extraAmount;
        if (extraAmount <= 0) {
            throw new RuntimeException("Amount to increase must be positive");
        } else {
            this.orderLine.setAmount(newAmount);
            this.validate();
        }
    }

}
