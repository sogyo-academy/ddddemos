package demos.oop.order.smartconstructor;

import java.util.ArrayList;
import java.util.List;

class Order {
    private List<OrderLine> lines;
    private String orderId;

    public Order(String orderId) {
        this.orderId = orderId;
        this.lines = new ArrayList<OrderLine>();
    }

    public void add(String productId, int amount) {
        OrderLine existingOrderLine = this.findExistingOrderLine(productId);
        if (existingOrderLine == null) {
            this.lines.add(new OrderLine(productId, amount));
        } else {
            existingOrderLine.add(amount);
        }
    }

    private OrderLine findExistingOrderLine(String productId) {
        for (OrderLine orderLine : this.lines) {
            if (orderLine.getProductId().equals(productId)) {
                return orderLine;
            }
        }
        return null;
    }

    public List<OrderLine> getLines() {
        return List.copyOf(this.lines);
    }
    
    public String getOrderId() {
        return orderId;
    }
}
