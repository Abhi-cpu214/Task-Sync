package com.tasksyncconnect.worker.services;

import com.tasksyncconnect.worker.dtos.EmailDTO;

public interface EmailSender {
    void send(EmailDTO emailDTO);
}
