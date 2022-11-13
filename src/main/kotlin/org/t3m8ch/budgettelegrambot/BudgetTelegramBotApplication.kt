package org.t3m8ch.budgettelegrambot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BudgetTelegramBotApplication

fun main(args: Array<String>) {
    runApplication<BudgetTelegramBotApplication>(*args)
}
