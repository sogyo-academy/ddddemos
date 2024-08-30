package demos.fp.order.nohiding

case class Order(lines: List[OrderLine] = List(), orderId: String):
    def add(productId: String, amount: Int): Order =
        val existingOrderLineAndIndex =
            this.lines.zipWithIndex.filter(_._1.productId == productId).headOption
        val updatedLines = existingOrderLineAndIndex match
            case None =>
                val newLine = OrderLine(productId, amount)
                this.lines.appended(newLine)
            case Some((existingOrderLine, index)) =>
                val updatedLine = existingOrderLine.add(amount)
                this.lines.updated(index, updatedLine)
        this.copy(lines = updatedLines)
