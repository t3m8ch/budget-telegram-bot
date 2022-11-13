package org.t3m8ch.budgettelegrambot.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document("Users")
data class UserModel(
    @Id val telegramId: Long,
    val createdAt: Instant = Instant.now(),
    val updatedAt: Instant = Instant.now(),
)
