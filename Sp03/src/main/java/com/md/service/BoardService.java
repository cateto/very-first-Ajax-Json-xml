package com.md.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import com.md.domain.Board;
import com.md.domain.File;
import com.md.vo.ListResult;

public interface BoardService {

	public ArrayList<Board> listS(int cp, int ps);
	public long totalS();
	public Board contentS(int seq);
	public void delS(int seq);
	public boolean insertS(Board dto);
	public boolean updateS(Board dto);
	public ListResult getListResultS(int cp, int ps);
	public boolean insertFileS(Board board, ArrayList<MultipartFile> files);
	public ArrayList<File> selectFileBySeqS(int seq);
	void delFileS(long f_num);
}
