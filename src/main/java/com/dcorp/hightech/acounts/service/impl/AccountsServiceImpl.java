package com.dcorp.hightech.acounts.service.impl;

import com.dcorp.hightech.acounts.constants.AccountConstants;
import com.dcorp.hightech.acounts.controllers.dto.CustomerDTO;
import com.dcorp.hightech.acounts.entities.AccountsEntity;
import com.dcorp.hightech.acounts.entities.CustomerEntity;
import com.dcorp.hightech.acounts.exception.CustomerAlreadyExistsException;
import com.dcorp.hightech.acounts.mapper.CustomerMapper;
import com.dcorp.hightech.acounts.repositories.AccountsRepository;
import com.dcorp.hightech.acounts.repositories.CustomerRepository;
import com.dcorp.hightech.acounts.service.AccountsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
@AllArgsConstructor
public class AccountsServiceImpl implements AccountsService {

    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;
    private final Random random = new Random();
    @Override
    public void createAccount(CustomerDTO request) {
        CustomerEntity initialCustomer = CustomerMapper.mapToCustomerEntity(request, new CustomerEntity());
        Optional<CustomerEntity> optionalCustomer = customerRepository.findByMobileNumber(initialCustomer.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with given mobile number " + initialCustomer.getMobileNumber());
        }

        initialCustomer.setCreatedAt(LocalDateTime.now());
        initialCustomer.setCreatedBy("Anonymous");
        CustomerEntity customer = customerRepository.save(initialCustomer);

        accountsRepository.save(createNewAccount(customer));
    }

    private AccountsEntity createNewAccount(CustomerEntity customer) {
        AccountsEntity account = new AccountsEntity();
        account.setCustomerId(customer.getCustomerId());
        long randomAccountNumber = 1000000000L + random.nextInt(900000000);

        account.setAccountNumber(randomAccountNumber);
        account.setAccountType(AccountConstants.SAVINGS);
        account.setBranchAddress(AccountConstants.ADDRESS);
        account.setCreatedAt(LocalDateTime.now());
        account.setCreatedBy("Anonymous");

        return account;
    }
}
