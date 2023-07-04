package com.sample.address.service;

import java.util.List;

import com.sample.address.entity.Address;



public interface AddressService {
	List<Address> findAll();

	void insertAddress(Address res);

	void updateAddress(Address res);

	void executeUpdateAddress(Address res);

	void deleteAddress(Address res);
	
}
