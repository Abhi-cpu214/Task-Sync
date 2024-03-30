package com.tasksyncconnect.worker.controller;

import com.tasksyncconnect.worker.dtos.MessageDTO;
import com.tasksyncconnect.worker.services.RedisService;
import com.tasksyncconnect.worker.services.impl.RedisServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/test/v1")
public class TestController {

    private final RedisService redisService;

    public TestController(RedisServiceImpl redisService) {
        this.redisService = redisService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveInRedis(@RequestBody MessageDTO messageDTO) {
        try {
            LocalDateTime time = LocalDateTime.now().plusMinutes(10);
            Date timeDate = Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            String strDate = dateFormat.format(timeDate);
            log.info(String.valueOf(messageDTO));
            redisService.save(strDate, messageDTO);
            return new ResponseEntity<>("Saved In DB", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
