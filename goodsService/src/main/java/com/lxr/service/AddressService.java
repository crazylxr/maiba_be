package com.lxr.service;

import com.lxr.entity.Address;
import com.lxr.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address save(Address address, String userId) {
        address.setPkId(UUID.randomUUID().toString());
        address.setUserId(userId);
        address.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return addressRepository.save(address);
    }

    public List<Address> findAll(String userId) {
        return addressRepository.findAllByUserId(userId);
    }
}
