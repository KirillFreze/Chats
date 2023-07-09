data class Message(
    val idMessage: Int,
    var message: String,
    var statusRead: Boolean = false,
    var statusDelete: Boolean = false
)

data class Chat(
    val messages: MutableList<Message> = mutableListOf()
)

class NoChatExeption : RuntimeException()
object CreateChat {
    private val chats: MutableMap<Int, Chat> = mutableMapOf()
    private var unicId = 1

    fun addChat(userId: Int, message: Message): Boolean {
        if (chats.containsKey(userId)) {
            chats[userId]?.messages?.add(message.copy(idMessage = unicId++))
            return true
        } else {
            val chat = Chat()
            chat.messages.add(message.copy(idMessage = unicId++))
            chats[userId] = chat
            return false
        }
    }

    fun deleteChat(userId: Int): Boolean {
        if (chats.containsKey(userId)) {
            chats.remove(userId)
            return true
        } else {
            throw NoChatExeption()
            return false
        }
    }

    fun printChats() = println(chats)
    fun lastMessage() =
        chats.values.map { chat -> chat.messages.lastOrNull { !it.statusDelete }?.message ?: "No message" }

    fun getMessage(userId: Int, count: Int): List<Message> {
        val chat = chats[userId] ?: throw NoChatExeption()
        return chat.messages.filter { !it.statusDelete }.takeLast(count).onEach { it.statusRead = true }

    }

    fun updateMessage(userId: Int, messageId: Int, text: String): Boolean {
        val chat = chats[userId] ?: throw NoChatExeption()
        chat.messages.lastOrNull { it.idMessage.equals(messageId) }?.message = text
        return true
    }

    fun deleteMessage(userId: Int, messageId: Int): Boolean {
        val chat = chats[userId] ?: throw NoChatExeption()
        chat.messages.removeAll { it.idMessage.equals(messageId) }
        return true
    }

}


fun main(args: Array<String>) {
    CreateChat.addChat(1, Message(1, "Hello"))
    CreateChat.addChat(2, Message(1, "Dust"))
    CreateChat.addChat(1, Message(1, "Hi"))
    CreateChat.addChat(1, Message(1, "Print"))
    CreateChat.addChat(2, Message(1, "Jack"))
    CreateChat.addChat(1, Message(1, "Best"))
    CreateChat.printChats()
    CreateChat.getMessage(1, 3)
    CreateChat.printChats()
    CreateChat.deleteChat(1)
    CreateChat.printChats()
    CreateChat.updateMessage(2, 5, "Jon")
    CreateChat.printChats()
    CreateChat.deleteMessage(2, 2)
    CreateChat.printChats()
}