package demos.fp.order.anemic

object OrderService:
    def addToOrder(order: Order, productId: String, amount: Int): Order =
        val existingOrderLineAndIndex =
            order.lines.zipWithIndex.filter(_._1.productId == productId).headOption
        val updatedLines = existingOrderLineAndIndex match
            case None =>
                val newLine = OrderLineService.createOrderLine(productId, amount)
                order.lines.appended(newLine)
            case Some((existingOrderLine, index)) =>
                val updatedLine = OrderLineService.addToOrderLine(existingOrderLine, amount)
                order.lines.updated(index, updatedLine)
        order.copy(lines = updatedLines)
