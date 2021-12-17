package com.lhwdev.discord.bot.management.config

import kotlinx.serialization.Serializable


@Serializable
class SecretInfo(
	val token: String
)


val sSecretInfo by config("secret-info", SecretInfo.serializer())
