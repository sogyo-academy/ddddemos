package demos.oop.order.nohiding;

class Main {
    public static void main(String[] args) {
        Order order = new Order("Good order");
        order.add("1234", 6);

        order.add("1234", 2);
        order.add("ABCD", 9);

        // order.add("1234", -9);
        // order.add("ABCD", 20);

        OrderLine illegalOrderLine = new OrderLine("1234", -100);
        Order illegalOrder = new Order("Bad order");
        illegalOrder.getLines().add(illegalOrderLine);
        illegalOrder.getLines().add(illegalOrderLine);

        System.out.println("Oops");
    }
}
