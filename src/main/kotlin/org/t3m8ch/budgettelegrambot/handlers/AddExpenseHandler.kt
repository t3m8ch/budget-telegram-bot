package org.t3m8ch.budgettelegrambot.handlers

import org.springframework.stereotype.Component
import org.t3m8ch.budgettelegrambot.services.ExpenseService
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.bots.AbsSender

@Component
class AddExpenseHandler(private val expenseService: ExpenseService) : Handler {
    override fun filter(update: Update): Boolean {
        return update.message?.text?.startsWith("расход") ?: false &&
                update.message.isUserMessage
    }

    override fun handle(update: Update, sender: AbsSender) {
        val expenseAmount = update.message.text.split(" ")
            .getOrNull(1)
            ?.toBigDecimalOrNull()

        val userId = update.message.from.id

        if (expenseAmount == null) {
            sender.execute(
                SendMessage.builder()
                    .text("Расход нужно писать числом")
                    .chatId(userId)
                    .build()
            )
            return
        }

        expenseService.add(expenseAmount, userId)

        sender.execute(
            SendMessage.builder()
                .text("Расход добавлен")
                .chatId(userId)
                .build()
        )
    }
}
