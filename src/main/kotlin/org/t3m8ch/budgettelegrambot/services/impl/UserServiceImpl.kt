package org.t3m8ch.budgettelegrambot.services.impl

import org.springframework.stereotype.Service
import org.t3m8ch.budgettelegrambot.models.UserModel
import org.t3m8ch.budgettelegrambot.repositories.UserRepository
import org.t3m8ch.budgettelegrambot.services.UserService

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {
    override fun create(telegramId: Long): UserModel {
        val user = UserModel(telegramId = telegramId)
        return userRepository.save(user)
    }
}
