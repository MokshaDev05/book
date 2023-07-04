package com.sample.address.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sample.address.dao.AddressDaoImpl;
import com.sample.address.entity.Address;


@Service
public class AddressServiceImpl implements AddressService{
	@Resource 
	AddressDaoImpl AddressDao;
	@Override
	public List<Address> findAll() {
		return AddressDao.findAll();
	}
	@Override
	public void insertAddress(Address res) {
		AddressDao.insertAddress(res);
		
	}
	@Override
	public void updateAddress(Address res) {
		AddressDao.updateAddress(res);
		
	}
	@Override
	public void executeUpdateAddress(Address res) {
		AddressDao.executeUpdateAddress(res);
		
	}

	@Override
	public void deleteAddress(Address res) {
		AddressDao.deleteAddress(res);
		
	}
}
