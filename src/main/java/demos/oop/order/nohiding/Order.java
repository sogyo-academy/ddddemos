package demos.oop.order.nohiding;

import java.util.List;
import java.util.ArrayList;

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
        return lines;
    }

    public void setLines(List<OrderLine> lines) {
        this.lines = lines;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}
