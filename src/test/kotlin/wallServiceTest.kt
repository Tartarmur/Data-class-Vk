import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import ru.netology.Post
import ru.netology.wallService
import kotlin.test.BeforeTest

class wallServiceTest {

    @BeforeTest
    fun clearBeforeTest() {
        wallService.clear()
    }

    @Test
    fun add() {
        var resultFirst = wallService.add(Post(1, "New day"))
        var resultSecond = wallService.add(Post(1, "What are you doing?"))
        assertNotEquals(0, resultFirst)
        assertNotEquals(1, resultSecond)
    }


    @Test
    fun update() {
        wallService.add(Post(1, "New day"))
        wallService.add(Post(1, "What are you doing?"))
        val resultFirst = wallService.update(Post(2, "Something"))
        val resultSecond = wallService.update(Post(4, "Wonderful new day!"))
        assertTrue(resultFirst)
        assertFalse(resultSecond)
    }
}

