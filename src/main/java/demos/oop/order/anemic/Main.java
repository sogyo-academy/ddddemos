package demos.oop.order.anemic;

class Main {
    public static void main(String[] args) {
        Order order = new Order("Good order");
        OrderService service = new OrderService(order);
        service.addToOrder("1234", 6);

        service.addToOrder("1234", 2);
        service.addToOrder("ABCD", 9);

        // service.addToOrder("1234", -9);
        // service.addToOrder("ABCD", 20);

        OrderLine illegalOrderLine = new OrderLine("1234", -100);
        Order illegalOrder = new Order("Bad order");
        illegalOrder.getLines().add(illegalOrderLine);
        illegalOrder.getLines().add(illegalOrderLine);

        System.out.println("Oops");
    }
}
