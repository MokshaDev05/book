package com.sample.address.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.address.entity.Address;



public class AddressRowMapper implements RowMapper<Address> {

	@Override
	public Address mapRow(ResultSet rs, int arg1) throws SQLException {
		Address res = new Address();
		res.setAddressId(rs.getString("AddressId"));
		res.setAddressName(rs.getString("AddressName"));
		
		res.setAddressDetail(rs.getString("AddressDetail"));
 
        return res;
	}


}
