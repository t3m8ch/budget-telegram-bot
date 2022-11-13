package org.t3m8ch.budgettelegrambot.services.impl

import org.springframework.stereotype.Service
import org.t3m8ch.budgettelegrambot.models.IncomeModel
import org.t3m8ch.budgettelegrambot.repositories.IncomeRepository
import org.t3m8ch.budgettelegrambot.services.IncomeService
import java.math.BigDecimal

@Service
class IncomeServiceImpl(private val incomeRepository: IncomeRepository) : IncomeService {
    override fun add(amount: BigDecimal, userId: Long) {
        val income = IncomeModel(amount = amount, userId = userId)
        incomeRepository.save(income)
    }
}
