package com.md.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.md.mapper.TxSample1Mapper;
import com.md.mapper.TxSample2Mapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class TxSampleServiceImpl implements TxSampleService {
	
	@Autowired
	private TxSample1Mapper mapper1;
	
	@Autowired
	private TxSample2Mapper mapper2;
	
	
	@Transactional // autocommit을 제어하지 않아도 하나의 작업단위로 묶여진다.
	@Override
	public void doDmlN(String data) {
		log.info("#TxSampleServiceImpl doDmlN() Step 1");
		mapper1.insertT1(data);
		log.info("#TxSampleServiceImpl doDmlN() Step 2");
		mapper2.insertT2(data);
		log.info("#TxSampleServiceImpl doDmlN() Step 3");
	}

}
