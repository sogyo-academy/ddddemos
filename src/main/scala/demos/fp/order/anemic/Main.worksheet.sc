import demos.fp.order.anemic.{Order, OrderLine, OrderService}

val order = Order(orderId = "Good order")
val updatedOrder = OrderService.addToOrder(order, "1234", 6)

val anotherUpdate = OrderService.addToOrder(updatedOrder, "1234", 2)
val yetAnotherUpdate = OrderService.addToOrder(updatedOrder, "ABCD", 9)

// OrderService.addToOrder(updatedOrder, "1234", -9)
// OrderService.addToOrder(updatedOrder, "ABCD", 20)

val illegalOrderLine = OrderLine(productId = "1234", amount = -100)
val illegalOrder = Order(orderId = "Bad order", lines = List(illegalOrderLine, illegalOrderLine))
