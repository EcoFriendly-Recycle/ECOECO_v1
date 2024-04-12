package com.recycle.ecoeco.manager.customer.service;

import com.recycle.ecoeco.manager.customer.model.dao.CustomerMapper;
import com.recycle.ecoeco.manager.customer.model.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerMapper customerMapper;
    public CustomerService(CustomerMapper customerMapper){
        this.customerMapper=customerMapper;
    }

    public List<CustomerDTO> findCustomerList(){
        return findCustomerList();
    }
}
