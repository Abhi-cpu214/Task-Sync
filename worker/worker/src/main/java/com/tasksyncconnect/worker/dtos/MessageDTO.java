package com.tasksyncconnect.worker.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDTO {
    private final Integer id;
    private final Date date;
    private final String email;
    private final String subject;
    private final String body;
}
