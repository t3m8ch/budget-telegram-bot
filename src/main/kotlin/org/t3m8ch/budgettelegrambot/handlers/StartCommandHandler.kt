package org.t3m8ch.budgettelegrambot.handlers

import org.springframework.stereotype.Component
import org.t3m8ch.budgettelegrambot.services.UserService
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.bots.AbsSender

@Component
class StartCommandHandler(private val userService: UserService) : Handler {
    override fun filter(update: Update): Boolean {
        return update.message?.text == "/start" && update.message.isUserMessage
    }

    override fun handle(update: Update, sender: AbsSender) {
        userService.create(update.message.from.id)

        val text = """
            Добро пожаловать в бот!
            Для добавления дохода напишите <i>доход 300</i>
            Для добавления расхода напишите <i>расход 300</i>
        """.trimIndent()

        val sendMessage = SendMessage.builder()
            .text(text)
            .parseMode("HTML")
            .chatId(update.message.chatId)
            .build()

        sender.execute(sendMessage)
    }
}
