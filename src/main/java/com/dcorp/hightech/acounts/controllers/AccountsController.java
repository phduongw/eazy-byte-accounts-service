package com.dcorp.hightech.acounts.controllers;

import com.dcorp.hightech.acounts.constants.AccountConstants;
import com.dcorp.hightech.acounts.controllers.dto.CustomerDTO;
import com.dcorp.hightech.acounts.controllers.dto.ResponseDTO;
import com.dcorp.hightech.acounts.service.AccountsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {

    private final AccountsService accountsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO request) {
        accountsService.createAccount(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDTO> fetchAccountDetails(
            @RequestParam
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits") String mobileNumber
    ) {
        CustomerDTO customer = accountsService.fetchAccount(mobileNumber);

        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @PutMapping("update")
    public ResponseEntity<ResponseDTO> updateAccountDetails(@Valid @RequestBody CustomerDTO request) {
        boolean isUpdated = accountsService.updateAccount(request);

        return responseOfModifyingObject(isUpdated);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteAccountDetails(
            @RequestParam
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits") String mobileNumber
    ) {
        boolean isDeleted = accountsService.deleteAccount(mobileNumber);
        return responseOfModifyingObject(isDeleted);
    }

    private ResponseEntity<ResponseDTO> responseOfModifyingObject(boolean isUpdated) {
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO(AccountConstants.STATUS_500, AccountConstants.MESSAGE_500));
    }
}
