package com.dcorp.hightech.acounts.controllers.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorResponse {

    String apiPath;

    HttpStatusCode errorCode;

    String errorMessage;

    LocalDateTime errorTime;

}
