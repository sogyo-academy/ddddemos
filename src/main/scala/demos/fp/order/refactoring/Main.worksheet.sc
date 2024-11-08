import demos.fp.order.smartconstructor.{Order, OrderLine}

val order = Order(orderId = "Good order")
val updatedOrder = order.add("1234", 6)

val anotherUpdate = updatedOrder.add("1234", 2)
val yetAnotherUpdate = updatedOrder.add("ABCD", 9)

updatedOrder.add("1234", -9)
updatedOrder.add("ABCD", 20)
