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
    @Test
    fun deleteChatFalse() {
        val createChat = CreateChat
        createChat.addChat(1,Message(1,"hi"))
        val result = createChat.deleteChat(2)
        assertFalse(result)
    }

}