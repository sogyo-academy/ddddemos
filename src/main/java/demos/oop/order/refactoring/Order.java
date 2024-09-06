package demos.oop.order.refactoring;

import java.util.HashMap;
import java.util.List;

class Order {
    private HashMap<String, OrderLine> linesById;
    private String orderId;

    public Order(String orderId) {
        this.orderId = orderId;
        this.linesById = new HashMap<String, OrderLine>();
    }

    public void add(String productId, int amount) {
        if (this.linesById.containsKey(productId)) {
            this.linesById.get(productId).add(amount);
        } else {
            this.linesById.put(productId, new OrderLine(productId, amount));
        }
    }

    public List<OrderLine> getLines() {
        return List.copyOf(this.linesById.values());
    }
    
    public String getOrderId() {
        return orderId;
    }
}
