package com.sample.address.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.address.entity.Address;
import com.sample.address.service.AddressService;

@RestController
public class AddressController {

	@Resource 
	AddressService addressService;
	
	@GetMapping(value = "/address")
	public List<Address> getAddress() {
		return addressService.findAll();
	
	}
	
	@PostMapping(value = "/address")
	public void createUser(@RequestBody Address res) {
		addressService.insertAddress(res);
	
	}
	
	@PutMapping(value = "/address")
	public void updateAddress(@RequestBody Address res) {
		addressService.updateAddress(res);
		
	
	}
	@PutMapping(value = "/executeUpdateAddress")
	public void executeUpdateAddress(@RequestBody Address res) {
		addressService.executeUpdateAddress(res);
	
	}
	
	@DeleteMapping(value = "/address")
	public void deleteAddress(@RequestBody Address res) {
		addressService.deleteAddress(res);
	
	}
	
	
	
}
