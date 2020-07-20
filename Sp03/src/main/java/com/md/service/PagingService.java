package com.md.service;

import java.util.List;

import com.md.domain.Paging;
import com.md.domain.PagingVo;

public interface PagingService {
	List<Paging> selectPerPageS(PagingVo pagingVo);
	long selectCountS();
	Paging selectCountS(long seq);
	void insertS(Paging paging);
	void deleteS(long seq);
	void deleteAllS();
}
