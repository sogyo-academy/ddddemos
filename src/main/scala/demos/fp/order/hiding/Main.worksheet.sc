import demos.fp.order.hiding.{Order, OrderLine}

val order = Order(orderId = "Good order")
val updatedOrder = order.add("1234", 6)

val anotherUpdate = updatedOrder.add("1234", 2)
val yetAnotherUpdate = updatedOrder.add("ABCD", 9)

updatedOrder.add("1234", -9)
updatedOrder.add("ABCD", 20)

//val pervertedOrderLine = updatedOrder.lines(0).copy(amount = 9000)
//val pervertedOrder = updatedOrder.copy(_lines=List(pervertedOrderLine))
//
val illegalOrderLine = new OrderLine(productId = "1234", amount = -100)
val illegalOrder = Order(orderId = "Bad order", lines = List(illegalOrderLine, illegalOrderLine))
