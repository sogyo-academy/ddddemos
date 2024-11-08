package demos.oop.order.hiding;

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
            OrderLine newOrderLine = new OrderLine(productId, amount);
            newOrderLine.validate();
            this.lines.add(newOrderLine);
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
