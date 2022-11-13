package org.t3m8ch.budgettelegrambot.repositories

import org.springframework.data.repository.CrudRepository
import org.t3m8ch.budgettelegrambot.models.UserModel

interface UserRepository : CrudRepository<UserModel, String>
