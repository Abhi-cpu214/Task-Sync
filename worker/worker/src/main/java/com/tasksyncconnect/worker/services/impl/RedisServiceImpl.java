package com.tasksyncconnect.worker.services.impl;

import com.tasksyncconnect.worker.dtos.EmailDTO;
import com.tasksyncconnect.worker.dtos.MessageDTO;
import com.tasksyncconnect.worker.mappers.MessageDTOToEmailDTOMapper;
import com.tasksyncconnect.worker.services.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class RedisServiceImpl implements RedisService {

    private final MessageDTOToEmailDTOMapper messageDTOToEmailDTOMapper;

    private final RedisTemplate<String, MessageDTO> redisTemplate;

    public RedisServiceImpl(
            RedisTemplate<String, MessageDTO> redisTemplate,
            MessageDTOToEmailDTOMapper messageDTOToEmailDTOMapper) {
        this.redisTemplate = redisTemplate;
        this.messageDTOToEmailDTOMapper = messageDTOToEmailDTOMapper;
    }

    @Override
    public List<EmailDTO> getEmailDTOs(String time) {
        Map<Object, Object> entries = redisTemplate.opsForHash().entries(time);
        List<EmailDTO> emailDTOS = new ArrayList<>();
        for(Object value: entries.values()) {
            MessageDTO messageDTO = (MessageDTO) value;
            EmailDTO emailDTO = messageDTOToEmailDTOMapper.convertToEmailDTO(messageDTO);
            emailDTOS.add(emailDTO);
        }
        return emailDTOS;
    }

    @Override
    public void save(String time, MessageDTO messageDTO) {
        redisTemplate.opsForHash().put(time, messageDTO.getId().toString(), String.valueOf(messageDTO));
    }

    @Override
    public void deleteHash(String time) {
        redisTemplate.delete(time);
    }
}
