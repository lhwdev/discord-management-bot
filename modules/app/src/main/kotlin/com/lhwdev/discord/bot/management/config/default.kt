package com.lhwdev.discord.bot.management.config

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.KSerializer
import java.io.File
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


val configYaml: Yaml = Yaml.default


class Config<T>(private val value: T) : ReadWriteProperty<Any?, T> {
	override fun getValue(thisRef: Any?, property: KProperty<*>): T = value
	
	override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
		TODO()
	}
}


fun <T> config(name: String, serializer: KSerializer<T>): Config<T> {
	val value = File("config/$name.yaml").inputStream().use {
		configYaml.decodeFromStream(serializer, it)
	}
	return Config(value)
}
