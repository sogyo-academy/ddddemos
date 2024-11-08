package demos.fp.order.refactoring

import scala.collection.immutable.HashMap

class Order private(private val linesById: HashMap[String, OrderLine] = HashMap(), val orderId: String):
    def add(productId: String, amount: Int): Order =
        val existingOrderLine = this.linesById.get(productId)
        val updatedLines = existingOrderLine match
            case None =>
                val newLine = OrderLine(productId, amount)
                this.linesById + (productId -> newLine)
            case Some(orderLine) =>
                val updatedLine = orderLine.add(amount)
                this.linesById + (productId -> updatedLine)
        new Order(linesById = updatedLines, orderId=this.orderId)

    def lines: List[OrderLine] = List.from(this.linesById.values)

    override def toString: String = s"Order(lines=${this.lines}, orderId=${this.orderId})"


object Order:
    def apply(orderId: String): Order = new Order(orderId = orderId)
