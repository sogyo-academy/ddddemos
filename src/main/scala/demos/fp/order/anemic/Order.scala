package demos.fp.order.anemic

case class Order(lines: List[OrderLine] = List(), orderId: String)
