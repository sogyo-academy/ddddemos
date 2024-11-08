package demos.oop.order.smartconstructor;

class Main {
    public static void main(String[] args) {
        Order order = new Order("Good order");
        order.add("1234", 6);

        order.add("1234", 2);
        order.add("ABCD", 9);

        try {
            order.add("1234", -9);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            order.add("ABCD", 20);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            OrderLine illegalOrderLine = new OrderLine("1234", -100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Oops");
    }
}
