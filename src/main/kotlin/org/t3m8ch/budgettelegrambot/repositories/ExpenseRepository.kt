package org.t3m8ch.budgettelegrambot.repositories

import org.springframework.data.repository.CrudRepository
import org.t3m8ch.budgettelegrambot.models.ExpenseModel

interface ExpenseRepository : CrudRepository<ExpenseModel, String> {
    fun findAllByUserId(userId: Long): List<ExpenseModel>
}
