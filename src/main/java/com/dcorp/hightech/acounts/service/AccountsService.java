package com.dcorp.hightech.acounts.service;

import com.dcorp.hightech.acounts.controllers.dto.CustomerDTO;

public interface AccountsService {

    void createAccount(CustomerDTO request);

}
