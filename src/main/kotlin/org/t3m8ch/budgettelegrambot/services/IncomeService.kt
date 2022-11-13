package org.t3m8ch.budgettelegrambot.services

import java.math.BigDecimal

interface IncomeService {
    fun add(amount: BigDecimal, userId: Long)
}
