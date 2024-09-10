import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import ru.netology.Post
import ru.netology.WallService
import kotlin.test.BeforeTest

class WallServiceTest {

    @BeforeTest
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        var resultFirst = WallService.add(Post(1, "New day"))
        var resultSecond = WallService.add(Post(1, "What are you doing?"))
        assertNotEquals(0, resultFirst)
        assertNotEquals(1, resultSecond)
    }


    @Test
    fun update() {
        WallService.add(Post(1, "New day"))
        WallService.add(Post(1, "What are you doing?"))
        val resultFirst = WallService.update(Post(2, "Something"))
        val resultSecond = WallService.update(Post(4, "Wonderful new day!"))
        assertTrue(resultFirst)
        assertFalse(resultSecond)
    }
}

