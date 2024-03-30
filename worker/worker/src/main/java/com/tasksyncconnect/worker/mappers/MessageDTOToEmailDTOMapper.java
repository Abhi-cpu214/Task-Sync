package com.tasksyncconnect.worker.mappers;

import com.tasksyncconnect.worker.dtos.EmailDTO;
import com.tasksyncconnect.worker.dtos.MessageDTO;
import org.springframework.stereotype.Component;

@Component
public class MessageDTOToEmailDTOMapper {
    public EmailDTO convertToEmailDTO(MessageDTO message) {
        return new EmailDTO(message.getEmail(), message.getSubject(), message.getBody());
    }
}
