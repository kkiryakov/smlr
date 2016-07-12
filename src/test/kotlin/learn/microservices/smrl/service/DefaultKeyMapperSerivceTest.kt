package learn.microservices.smrl.service

import org.junit.Assert.*
import org.junit.Test

class DefaultKeyMapperSerivceTest {

    val service: KeyMapperService = DefaultKeyMapperService()

    private val KEY = "aAbBcCdD"
    private val LINK = "https://github.com/kkiryakov"
    private val LINK_NEW = "http://google.com"

    @Test
    fun clientCanAddNewKeyWithLink() {
        assertEquals(KeyMapperService.Add.Success(KEY, LINK), service.add(KEY, LINK))
        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }

    @Test
    fun clientCanNotAddExistingKey() {
        service.add(KEY, LINK)
        assertEquals(KeyMapperService.Add.AlreadyExist(KEY), service.add(KEY, LINK_NEW))
        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }

    @Test
    fun clientCanNotTakeTakeLinkIfKeyIsNotFoundInService() {
        assertEquals(KeyMapperService.Get.NotFound(KEY), service.getLink(KEY))
    }
}
