import org.junit.Test

import org.junit.Assert.*

class CreateChatTest3 {

    @Test
    fun updateMessage() {
        val createChat = CreateChat
        createChat.addChat(1,Message(1,"hi"))
        val result = createChat.updateMessage(1,1,"Hello")
        assertTrue(result)
    }
    @Test(expected = NoChatExeption::class)
    fun shouldThrow() {
        val createChat = CreateChat
        createChat.addChat(1,Message(1,"hi"))
        val result = createChat.updateMessage(2,1,"Hello")
        assertTrue(result)

    }
}