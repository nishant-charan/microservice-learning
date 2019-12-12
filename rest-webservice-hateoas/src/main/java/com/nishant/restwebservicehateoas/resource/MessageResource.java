package com.nishant.restwebservicehateoas.resource;

import com.nishant.restwebservicehateoas.model.Message;
import com.nishant.restwebservicehateoas.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messenger")
public class MessageResource {

    @Autowired
    private MessageService messageService;

    @GetMapping("/messages")
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/messages/{messageId}")
    public Message getMessageById(@PathVariable("messageId") Long messageId) {
        return messageService.getMessageById(messageId);
    }

    @PostMapping(value = "/addMessage", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message addMessage(@RequestBody Message message) {
        System.out.println("Message : " + message.getAuthor() + " --- " + message.getCreated());
        return messageService.addMessage(message);
    }

    @
    public Message removeMessage(@PathVariable("messageId") Long messageId) {
        return messageService.removeMessage(messageId);
    }
}
