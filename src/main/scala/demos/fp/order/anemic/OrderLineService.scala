package demos.fp.order.anemic

object OrderLineService:
    def createOrderLine(productId: String, amount: Int): OrderLine =
        if amount <= 0 || amount > 10 then throw Exception("Cannot create order line")
        else OrderLine(productId = productId, amount = amount)

    def addToOrderLine(orderLine: OrderLine, extraAmount: Int): OrderLine =
        val newAmount = orderLine.amount + extraAmount
        if extraAmount <= 0 || orderLine.amount + extraAmount > 10 then
            throw Exception("Cannot increase order line amount")
        else OrderLine(productId = orderLine.productId, amount = newAmount)
