package dev.arbjerg.FreedomLink.api

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManager

/**
 * Allows modification of FreedomLink's [AudioPlayerManager]
 *
 *
 * Note: Beans of type [AudioSourceManager] are automatically loaded by
 * FreedomLink, in which case using this interface is redundant.
 */
interface AudioPlayerManagerConfiguration {
    /**
     * Creates a new custom configured [AudioPlayerManager] based on [manager].
     */
    fun configure(manager: AudioPlayerManager): AudioPlayerManager
}
