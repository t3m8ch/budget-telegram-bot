package org.t3m8ch.budgettelegrambot.repositories

import org.springframework.data.repository.CrudRepository
import org.t3m8ch.budgettelegrambot.models.IncomeModel

interface IncomeRepository : CrudRepository<IncomeModel, String> {
    fun findAllByUserId(userId: Long): List<IncomeModel>
}
