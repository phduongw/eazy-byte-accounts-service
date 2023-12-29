package com.dcorp.hightech.acounts.controllers.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDTO {

    String name;

    String email;

    String mobileNumber;

}
