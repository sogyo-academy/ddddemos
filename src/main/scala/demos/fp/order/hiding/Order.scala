package demos.fp.order.hiding

class Order(val lines: List[OrderLine] = List(), orderId: String):
    def add(productId: String, amount: Int): Order =
        val existingOrderLineAndIndex = this.lines.zipWithIndex.find(_._1.productId == productId)
        val updatedLines = existingOrderLineAndIndex match
            case None =>
                val newLine = OrderLine(productId, amount)
                this.lines.appended(newLine)
            case Some((existingOrderLine, index)) =>
                val updatedLine = existingOrderLine.add(amount)
                this.lines.updated(index, updatedLine)
        Order(lines = updatedLines, orderId = this.orderId)

    override def toString: String = s"Order(lines=${this.lines}, orderId=${this.orderId})"
