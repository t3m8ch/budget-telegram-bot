package org.t3m8ch.budgettelegrambot.handlers

import org.springframework.stereotype.Component
import org.t3m8ch.budgettelegrambot.services.RevenueService
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.bots.AbsSender

@Component
class GetRevenueHandler(private val revenueService: RevenueService) : Handler {
    override fun filter(update: Update): Boolean {
        return update.message?.text == "выгода" &&
                update.message.isUserMessage
    }

    override fun handle(update: Update, sender: AbsSender) {
        val userId = update.message.from.id
        val revenue = revenueService.getRevenueForAllTime(userId)

        sender.execute(
            SendMessage.builder()
                .text("Выгода: $revenue")
                .chatId(userId)
                .build()
        )
    }
}
