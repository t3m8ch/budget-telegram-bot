package org.t3m8ch.budgettelegrambot.handlers

import org.springframework.stereotype.Component
import org.t3m8ch.budgettelegrambot.services.IncomeService
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.bots.AbsSender

@Component
class AddIncomeHandler(private val incomeService: IncomeService) : Handler {
    override fun filter(update: Update): Boolean {
        return update.message?.text?.startsWith("доход") ?: false &&
                update.message.isUserMessage
    }

    override fun handle(update: Update, sender: AbsSender) {
        val incomeAmount = update.message.text.split(" ")
            .getOrNull(1)
            ?.toBigDecimalOrNull()

        val userId = update.message.from.id

        if (incomeAmount == null) {
            sender.execute(
                SendMessage.builder()
                    .text("Доход нужно писать числом")
                    .chatId(userId)
                    .build()
            )
            return
        }

        incomeService.add(incomeAmount, userId)

        sender.execute(
            SendMessage.builder()
                .text("Доход добавлен")
                .chatId(userId)
                .build()
        )
    }
}
