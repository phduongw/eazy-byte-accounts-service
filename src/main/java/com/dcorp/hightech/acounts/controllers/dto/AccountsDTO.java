package com.dcorp.hightech.acounts.controllers.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountsDTO {

    Long customerId;

    String accountType;

    String branchAddress;

}
