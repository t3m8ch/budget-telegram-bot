package org.t3m8ch.budgettelegrambot.services.impl

import org.springframework.stereotype.Service
import org.t3m8ch.budgettelegrambot.repositories.ExpenseRepository
import org.t3m8ch.budgettelegrambot.repositories.IncomeRepository
import org.t3m8ch.budgettelegrambot.services.RevenueService
import java.math.BigDecimal

@Service
class RevenueServiceImpl(
    private val incomeRepository: IncomeRepository,
    private val expenseRepository: ExpenseRepository,
) : RevenueService {
    override fun getRevenueForAllTime(userId: Long): BigDecimal {
        val totalIncome = incomeRepository.findAllByUserId(userId).sumOf { it.amount }
        val totalExpense = expenseRepository.findAllByUserId(userId).sumOf { it.amount }

        return totalIncome - totalExpense
    }
}
