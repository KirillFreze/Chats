import org.junit.Test

import org.junit.Assert.*

class CreateChatTest4 {

    @Test
    fun deleteMessage() {
        val createChat = CreateChat
        createChat.addChat(1,Message(1,"hi"))
        val result = createChat.deleteMessage(1,1)
        assertTrue(result)
    }
    @Test(expected = NoChatExeption::class)
    fun shouldThrow() {
        val createChat = CreateChat
        createChat.addChat(1,Message(1,"hi"))
        val result = createChat.deleteMessage(2,1)
        assertTrue(result)

    }
}