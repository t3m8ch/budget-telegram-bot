package org.t3m8ch.budgettelegrambot.services.impl

import org.springframework.stereotype.Service
import org.t3m8ch.budgettelegrambot.models.ExpenseModel
import org.t3m8ch.budgettelegrambot.repositories.ExpenseRepository
import org.t3m8ch.budgettelegrambot.services.ExpenseService
import java.math.BigDecimal

@Service
class ExpenseServiceImpl(private val expenseRepository: ExpenseRepository) : ExpenseService {
    override fun add(amount: BigDecimal, userId: Long) {
        val expense = ExpenseModel(amount = amount, userId = userId)
        expenseRepository.save(expense)
    }
}
