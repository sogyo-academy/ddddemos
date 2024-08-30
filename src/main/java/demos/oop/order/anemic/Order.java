package demos.oop.order.anemic;

import java.util.List;
import java.util.ArrayList;

class Order {
    private List<OrderLine> lines;
    private String orderId;

    public Order(String orderId) {
        this.orderId = orderId;
        this.lines = new ArrayList<OrderLine>();
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
