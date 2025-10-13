package dev.arbjerg.FreedomLink.api

import org.springframework.web.servlet.HandlerInterceptor

/**
 * This interface allows intercepting HTTP requests to the FreedomLink server. Override the methods to add your own logic.
 */
interface RestInterceptor : HandlerInterceptor
