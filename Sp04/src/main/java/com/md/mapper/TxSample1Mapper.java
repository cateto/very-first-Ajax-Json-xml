package com.md.mapper;

import org.apache.ibatis.annotations.Insert;

public interface TxSample1Mapper {
	
	@Insert("insert into tbl_sample1 values(#{data})")
	public void insertT1(String data);


}
