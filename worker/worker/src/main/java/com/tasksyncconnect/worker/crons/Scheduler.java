package com.tasksyncconnect.worker.crons;

import com.tasksyncconnect.worker.dtos.EmailDTO;
import com.tasksyncconnect.worker.services.EmailSender;
import com.tasksyncconnect.worker.services.RedisService;
import com.tasksyncconnect.worker.services.impl.RedisServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class Scheduler {

    private final RedisService redisService;
    private final EmailSender emailSender;

    public Scheduler(RedisServiceImpl redisService, EmailSender emailSender) {
        this.redisService = redisService;
        this.emailSender = emailSender;
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    @SchedulerLock(name = "TaskScheduler_scheduledTask", lockAtMostFor = "PT5M")
    public void scheduledTask() {

        log.info("Current Time :: {}", new Date());
        for(int min = 1 ; min <= 5 ; min++) {
            LocalDateTime timeAgo = LocalDateTime.now().minusMinutes(min);
            Date timeAgoDate = Date.from(timeAgo.atZone(ZoneId.systemDefault()).toInstant());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            String strDate = dateFormat.format(timeAgoDate);
            List<EmailDTO> emailDTOS = redisService.getEmailDTOs(strDate);
            emailDTOS.forEach(emailDTO -> {
                try {
                    emailSender.send(emailDTO);
                    log.info("Mail Sent to :: " + emailDTO.getEmail());
                } catch (Exception e) {
                    log.error("Error while sending Mail :: {}", e.getMessage());
                }
            });
            redisService.deleteHash(strDate);
        }
    }
}