package com.tasksyncconnect.worker.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailDTO {
    private final String email;
    private final String subject;
    private final String body;
}
