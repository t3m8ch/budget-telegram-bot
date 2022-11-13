package org.t3m8ch.budgettelegrambot.services

import org.t3m8ch.budgettelegrambot.models.UserModel

interface UserService {
    fun create(telegramId: Long): UserModel
}