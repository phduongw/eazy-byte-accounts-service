package com.dcorp.hightech.acounts.controllers.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountsDTO {

    @NotEmpty(message = "Account Number can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account Number must be 10 digits")
    Long accountNumber;

    @NotEmpty(message = "Account Type can't be a bull or empty")
    String accountType;

    @NotEmpty(message = "Branch Address can't be a null or empty")
    String branchAddress;

}
