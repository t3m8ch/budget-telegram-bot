package org.t3m8ch.budgettelegrambot.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document("Expenses")
data class ExpenseModel(
    @Id val id: String = ObjectId.get().toString(),
    val amount: BigDecimal,
    val userId: Long,
)
