package com.lhwdev.discord.bot.management.config

import kotlinx.serialization.Serializable


@Serializable
class ServerInfo(
	val servers: Map<String, Server>,
	val admins: LongArray
) {
	@Serializable
	class Server(val id: Long)
}


val sServerInfo by config("server-info", ServerInfo.serializer())
