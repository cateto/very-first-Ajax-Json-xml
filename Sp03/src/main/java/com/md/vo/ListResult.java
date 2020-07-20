package com.md.vo;

import java.util.ArrayList;

import com.md.domain.Board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListResult {

	private int currentPage;
	private long totalCount;
	private int pageSize;
	private ArrayList<Board> list;
	private long totalPageCount;
	
}
