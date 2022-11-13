package org.t3m8ch.budgettelegrambot

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.t3m8ch.budgettelegrambot.handlers.Handler
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update

@Component
class TelegramBot(private val handlers: List<Handler>) : TelegramLongPollingBot() {
    @Value("\${tg-bot.username}")
    private lateinit var tgBotUsername: String

    @Value("\${tg-bot.token}")
    private lateinit var tgBotToken: String

    override fun getBotToken(): String {
        return tgBotToken
    }

    override fun getBotUsername(): String {
        return tgBotUsername
    }

    override fun onUpdateReceived(update: Update) {
        for (handler in handlers) {
            if (handler.filter(update)) {
                handler.handle(update, this)
                break
            }
        }
    }
}
