package com.md.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.md.domain.Address;
import com.md.mapper.AddressAjaxMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressAjaxServiceImpl implements AddressAjaxService {
	
	private AddressAjaxMapper mapper;
	
	@Override
	public List<Address> listS() {
		return mapper.list();
	}

	@Override
	public void insertS(Address address) {
		mapper.insert(address);
	}

	@Override
	public void deleteS(long seq) {
		mapper.delete(seq);
	}
	
	@Override
	public Address selectBySeqS(long seq) {
		return mapper.selectBySeq(seq);
	}
	
	@Override
	public List<Address> selectByNameS(String name){
		return mapper.selectByName(name);
	}

}
