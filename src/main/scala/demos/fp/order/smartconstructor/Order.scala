package demos.fp.order.smartconstructor

class Order private(val lines: List[OrderLine] = List(), val orderId: String):
    def add(productId: String, amount: Int): Order =
        val existingOrderLineAndIndex = this.lines.zipWithIndex.find(_._1.productId == productId)
        val updatedLines = existingOrderLineAndIndex match
            case None =>
                val newLine = OrderLine(productId, amount)
                this.lines.appended(newLine)
            case Some((existingOrderLine, index)) =>
                val updatedLine = existingOrderLine.add(amount)
                this.lines.updated(index, updatedLine)
        new Order(lines = updatedLines, orderId=this.orderId)


object Order:
    def apply(orderId: String): Order = new Order(orderId = orderId)
