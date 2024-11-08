package demos.fp.order.refactoring

class OrderLine private (val productId: String, val amount: Int):
    def add(extraAmount: Int): OrderLine =
        val newAmount = this.amount + extraAmount
        if extraAmount <= 0 || this.amount + extraAmount > 10 then throw Exception("Cannot increase order line amount")
        else OrderLine(productId = this.productId, amount = newAmount)

    override def toString: String = s"OrderLine(productId=${this.productId}, amount=${this.amount})"


object OrderLine:
    def apply(productId: String, amount: Int): OrderLine =
        if amount <= 0 || amount > 10 then throw Exception("Cannot create order line")
        else new OrderLine(productId = productId, amount = amount)
