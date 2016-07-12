package learn.microservices.smrl.service

import org.junit.Assert
import org.junit.Test
import java.util.*

class DefaultKeyConverterServiceTest {

    val service: KeyConverterService = DefaultKeyConverterService()

    @Test
    fun givenIdMustBeConvertableBothWays() {
        val rand = Random()
        for(i in 0..1000L) {
            val initialId = Math.abs(rand.nextLong())
            val link = service.idToKey(initialId)
            val id = service.keyToId(link)
            Assert.assertEquals(initialId, id)
        }
    }
}