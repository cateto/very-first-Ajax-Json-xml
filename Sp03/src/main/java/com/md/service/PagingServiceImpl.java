package com.md.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.md.domain.Paging;
import com.md.domain.PagingVo;
import com.md.mapper.PagingMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PagingServiceImpl implements PagingService {
	
	private PagingMapper mapper;
	
	@Override
	public List<Paging> selectPerPageS(PagingVo pagingVo) {
		// TODO Auto-generated method stub
		return mapper.selectPerPage(pagingVo);
	}

	@Override
	public long selectCountS() {
		// TODO Auto-generated method stub
		return mapper.selectCount();
	}

	@Override
	public Paging selectCountS(long seq) {
		// TODO Auto-generated method stub
		return mapper.selectCount(seq);
	}

	@Override
	public void insertS(Paging paging) {
		// TODO Auto-generated method stub
		mapper.insert(paging);
	}

	@Override
	public void deleteS(long seq) {
		// TODO Auto-generated method stub
		mapper.delete(seq);
	}

	@Override
	public void deleteAllS() {
		// TODO Auto-generated method stub
		mapper.deleteAll();
	}

}
