package com.lhwdev.discord.bot.management

import com.lhwdev.discord.bot.management.config.sSecretInfo
import com.lhwdev.discord.bot.management.config.sServerInfo
import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.event.gateway.ReadyEvent
import dev.kord.core.on


suspend fun botMain() {
	val kord = Kord(token = sSecretInfo.token) {
		
	}
	
	kord.on<ReadyEvent> {
		val guildId = Snowflake(sServerInfo.servers.values.first().id)
		val guild = kord.getGuild(guildId)!!
		val channel = guild.getSystemChannel()!!
		channel.createMessage { content = "ㅎㅇ" }
	}
	
	kord.login {
		presence {
			listening("서버 권한")
		}
	}
}
