package com.sample.address.dao;

import java.util.List;

import com.sample.address.entity.Address;

public interface AddressDao{

	List<Address> findAll();

	void insertAddress(Address res);

	void updateAddress(Address res);

	void executeUpdateAddress(Address res);

	public void deleteAddress(Address res);
}
