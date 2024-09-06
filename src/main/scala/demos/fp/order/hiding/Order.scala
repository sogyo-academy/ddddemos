package demos.fp.order.hiding

case class Order(private val _lines: List[OrderLine] = List(), orderId: String):
    def add(productId: String, amount: Int): Order =
        val existingOrderLineAndIndex = this._lines.zipWithIndex.find(_._1.productId == productId)
        val updatedLines = existingOrderLineAndIndex match
            case None =>
                val newLine = OrderLine(productId, amount)
                this._lines.appended(newLine)
            case Some((existingOrderLine, index)) =>
                val updatedLine = existingOrderLine.add(amount)
                this._lines.updated(index, updatedLine)
        this.copy(_lines = updatedLines)

    def lines: List[OrderLine] = this._lines
