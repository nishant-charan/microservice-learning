package com.nishant.restwebservicehateoas.service;

import com.nishant.restwebservicehateoas.database.DatabaseClass;
import com.nishant.restwebservicehateoas.model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MessageService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
        messages.put(1L, new Message(1L, "Hello World", "Nishant"));
        messages.put(2L, new Message(2L, "Hello World", "Bibhakar"));
    }

    public List<Message> getAllMessages() {
        return new ArrayList<Message>(messages.values());
    }

    public Message getMessageById(long messageId) {
        return messages.get(messageId);
    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long messageId) {
        return messages.remove(messageId);
    }
}
