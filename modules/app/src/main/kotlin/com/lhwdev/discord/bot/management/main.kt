package com.lhwdev.discord.bot.management


suspend fun main() {
	when(System.getProperty("kind")) {
		null, "bot" -> botMain()
	}
}
