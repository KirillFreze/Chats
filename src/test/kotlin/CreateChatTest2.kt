import org.junit.Test

import org.junit.Assert.*

class CreateChatTest2 {

    @Test
    fun deleteChat() {
        val createChat = CreateChat
        createChat.addChat(1,Message(1,"hi"))
        val result = createChat.deleteChat(1)
        assertTrue(result)
    }
    @Test(expected = NoChatExeption::class)
    fun shouldThrow() {
        val createChat = CreateChat
        val result = createChat.deleteChat(1)
        assertFalse(result)

    }
}