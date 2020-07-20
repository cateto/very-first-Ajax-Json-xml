package com.md.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

import com.md.domain.Board;
import com.md.domain.File;

public interface BoardMapper {
	long total();
	ArrayList<Board> list(HashMap<String, Object> range);
	Board selectBySeq(int seq);
	ArrayList<Board> selectByWriter(HashMap<String, Object> range);	
	ArrayList<Board> selectBySubject(HashMap<String, Object> range);	
	Board content(int seq);
	void del(int seq);
	boolean insert(Board dto);
	boolean update(Board dto);
	void insertFile(File file);
	ArrayList<File> selectFileBySeq(int seq);
	void delFile(long f_num);
	
	
}
