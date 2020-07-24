package com.md.mapper;

import org.apache.ibatis.annotations.Insert;

public interface TxSample2Mapper {
	
	@Insert("insert into tbl_sample2 values(#{data})")
	public void insertT2(String data);


}
