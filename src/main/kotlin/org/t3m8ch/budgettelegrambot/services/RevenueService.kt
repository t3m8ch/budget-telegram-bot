package org.t3m8ch.budgettelegrambot.services

import java.math.BigDecimal

interface RevenueService {
    fun getRevenueForAllTime(userId: Long): BigDecimal
}
