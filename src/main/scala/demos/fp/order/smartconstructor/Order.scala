package demos.fp.order.smartconstructor

class Order private(private val _lines: List[OrderLine] = List(), val orderId: String):
    def add(productId: String, amount: Int): Order =
        val existingOrderLineAndIndex = this._lines.zipWithIndex.find(_._1.productId == productId)
        val updatedLines = existingOrderLineAndIndex match
            case None =>
                val newLine = OrderLine(productId, amount)
                this._lines.appended(newLine)
            case Some((existingOrderLine, index)) =>
                val updatedLine = existingOrderLine.add(amount)
                this._lines.updated(index, updatedLine)
        new Order(_lines = updatedLines, orderId=this.orderId)

    def lines: List[OrderLine] = this._lines


object Order:
    def apply(orderId: String): Order = new Order(orderId = orderId)
