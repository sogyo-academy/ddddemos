package demos.oop.order.anemic;

import java.util.List;

class OrderService {

    private Order order;

    public OrderService(Order order) {
        this.order = order;
    }

    public void addToOrder(String productId, int amount) {
        OrderLine existingOrderLine = this.findExistingOrderLine(productId);
        if (existingOrderLine == null) {
            OrderLine newOrderLine = new OrderLine(productId, amount);
            OrderLineService service = new OrderLineService(newOrderLine);
            service.validate();
            this.order.getLines().add(newOrderLine);
        } else {
            OrderLineService service = new OrderLineService(existingOrderLine);
            service.addToOrderLine(amount);
        }
    }

    private OrderLine findExistingOrderLine(String productId) {
        List<OrderLine> lines = this.order.getLines();
        for (OrderLine orderLine : lines) {
            if (orderLine.getProductId().equals(productId)) {
                return orderLine;
            }
        }
        return null;
    }
}
