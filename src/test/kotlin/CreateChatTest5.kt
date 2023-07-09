import org.junit.Test

import org.junit.Assert.*

class CreateChatTest5 {

    @Test
    fun getMessage() {
        val createChat = CreateChat
        createChat.addChat(1, Message(1, "hi"))
        val message = createChat.getMessage(1, 1)[0]
        val result = message.statusRead
        assertTrue(result)
    }

    @Test(expected = NoChatExeption::class)
    fun shouldThrow() {
        val createChat = CreateChat
        createChat.addChat(1, Message(1, "hi"))
        createChat.getMessage(2, 1)[0]

    }


}