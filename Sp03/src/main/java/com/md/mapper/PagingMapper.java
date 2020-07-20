package com.md.mapper;

import java.util.List;

import com.md.domain.Paging;
import com.md.domain.PagingVo;

public interface PagingMapper {
	List<Paging> selectPerPage(PagingVo pagingVo);
	long selectCount();
	Paging selectCount(long seq);
	void insert(Paging paging);
	void delete(long seq);
	void deleteAll();
}
