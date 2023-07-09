import org.junit.Test

import org.junit.Assert.*

class CreateChatTest {

    @Test
    fun addChat() {
        val createChat = CreateChat
        val result = createChat.addChat(1,Message(1,"Hello"))
        assertTrue(result)
    }

}