package com.dcorp.hightech.acounts.controllers;

import com.dcorp.hightech.acounts.constants.AccountConstants;
import com.dcorp.hightech.acounts.controllers.dto.CustomerDTO;
import com.dcorp.hightech.acounts.controllers.dto.ResponseDTO;
import com.dcorp.hightech.acounts.service.AccountsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {

    private final AccountsService accountsService;

    @PostMapping
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO request) {
        accountsService.createAccount(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

}
