package com.bitsnbyte.productlist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class ExceptionResponseDTO {
    private String apiPath;
    private String errorMessage;
    private HttpStatus statusCode;
    private LocalDateTime errorTime;
}
