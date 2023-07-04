package com.sample.address.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sample.address.entity.Address;
import com.sample.address.mapper.AddressRowMapper;


@Repository
public class AddressDaoImpl implements AddressDao{
	
	public AddressDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template; 
	@Override
	public List<Address> findAll() {
		return template.query("select * from address", new AddressRowMapper());
	}
	@Override
	public void insertAddress(Address res) {
		 final String sql = "insert into address(addressId, addressName , addressDetail) values(:addressId,:addressName,:addressDetail)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("addressId", res.getAddressId())
					.addValue("addressName", res.getAddressName())
					
					.addValue("addressDetail", res.getAddressDetail());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void updateAddress(Address res) {
		 final String sql = "update address set addressName=:addressName, addressDetail=:addressDetail where addressId=:addressId";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
	        		.addValue("addressId", res.getAddressId())
					.addValue("addressName", res.getAddressName())
					
					.addValue("addressDetail", res.getAddressDetail());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void executeUpdateAddress(Address res) {
		 final String sql = "update address set addressName=:addressName, addressDetail=:addressDetail, where addressId=:addressId";
			 

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("addressId", res.getAddressId());
		 map.put("addressName", res.getAddressName());
	
		 map.put("addressDetail", res.getAddressDetail());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
	@Override
	public void deleteAddress(Address res) {
		 final String sql = "delete from address where addressId=:addressId";
			 

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("addressId",res.getAddressId());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
}
