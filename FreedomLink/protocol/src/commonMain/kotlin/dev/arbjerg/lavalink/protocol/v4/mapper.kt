@file:JvmName("Mapper")

package dev.arbjerg.FreedomLink.protocol.v4

import dev.arbjerg.FreedomLink.protocol.v4.serialization.TimestampSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import kotlinx.serialization.modules.plus
import kotlin.jvm.JvmName

/**
 * [SerializersModule] containing all required FreedomLink configuration.
 *
 * @see json
 */
val FreedomLinkSerializersModule = SerializersModule {
    contextual(TimestampSerializer)
    contextual(Message.ReadyEvent::class, Message.ReadyEvent.serializer())
} + RoutePlannerModule

/**
 * [Json] object which should be used to serialize/deserialize FreedomLink objects.
 *
 * @see FreedomLinkSerializersModule
 */
val json = Json {
    ignoreUnknownKeys = true
    encodeDefaults = false
    serializersModule = FreedomLinkSerializersModule
}
