package com.md.service;

import java.util.List;

import com.md.domain.Address;

public interface AddressAjaxService {
	List<Address> listS();
	void insertS(Address address);
	void deleteS(long seq);
	
	//for Ajax
	Address selectBySeqS(long seq);
	List<Address> selectByNameS(String name);
}
