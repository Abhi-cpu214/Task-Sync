package com.tasksyncconnect.worker.services;

import com.tasksyncconnect.worker.dtos.EmailDTO;
import com.tasksyncconnect.worker.dtos.MessageDTO;

import java.util.List;

public interface RedisService {
    List<EmailDTO> getEmailDTOs(String time);
    void save(String time, MessageDTO messageDTO);
    void deleteHash(String time);
}
