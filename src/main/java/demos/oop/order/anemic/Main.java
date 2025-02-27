package demos.oop.order.anemic;

class Main {
    public static void main(String[] args) {
        Order order = new Order("Good order");
        OrderService service = new OrderService(order);
        service.addToOrder("1234", 6);

        service.addToOrder("1234", 2);
        service.addToOrder("ABCD", 9);

        try {
            service.addToOrder("1234", -9);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            service.addToOrder("ABCD", 20);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        order.getLines().get(0).setAmount(9000);

        OrderLine illegalOrderLine = new OrderLine("1234", -100);
        Order illegalOrder = new Order("Bad order");
        illegalOrder.getLines().add(illegalOrderLine);
        illegalOrder.getLines().add(illegalOrderLine);

        System.out.println("Oops");
    }
}
