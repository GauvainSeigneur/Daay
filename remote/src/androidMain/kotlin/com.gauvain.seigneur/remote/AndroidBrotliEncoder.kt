package com.gauvain.seigneur.remote

import com.gauvain.seigneur.remote.http.BrotliEncoder
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.jvm.javaio.toByteReadChannel
import io.ktor.utils.io.jvm.javaio.toInputStream
import org.brotli.dec.BrotliInputStream
import kotlin.coroutines.CoroutineContext

internal class AndroidBrotliEncoder : BrotliEncoder {

    override val name: String = "br"

    override fun decode(
        source: ByteReadChannel,
        coroutineContext: CoroutineContext,
    ): ByteReadChannel = BrotliInputStream(source.toInputStream()).toByteReadChannel()

    override fun encode(
        source: ByteReadChannel,
        coroutineContext: CoroutineContext,
    ): ByteReadChannel = source // Not implemented as a client we should not use it

    override fun encode(
        source: ByteWriteChannel,
        coroutineContext: CoroutineContext,
    ): ByteWriteChannel = source // Not implemented as a client we should not use it
}
