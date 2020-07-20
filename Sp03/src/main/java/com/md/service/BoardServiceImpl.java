package com.md.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import com.md.domain.Board;
import com.md.domain.File;
import com.md.mapper.BoardMapper;

import com.md.vo.ListResult;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Override
	public ArrayList<Board> listS(int cp, int ps) {
		HashMap<String, Object> range = new HashMap<String, Object>();
		int range1 = (cp-1)*ps;
		int range2 =  cp*ps;
		range.put("startRow", range1);
		range.put("endRow", range2);
		return boardMapper.list(range);
	}
	
	Board selectBySeq(int seq){
		return boardMapper.selectBySeq(seq);
	}
	
	ArrayList<Board> selectByWriter(int cp, int ps, String keyword){
		HashMap<String, Object> inform = new HashMap<String, Object>();
		int range1 = (cp-1)*ps;
		int range2 =  cp*ps;
		inform.put("keyword", keyword);
		inform.put("startRow", range1);
		inform.put("endRow", range2);		
		return boardMapper.selectByWriter(inform);
	}

	ArrayList<Board> selectBySubject(int cp, int ps, String keyword){
		HashMap<String, Object> inform = new HashMap<String, Object>();
		int range1 = (cp-1)*ps;
		int range2 =  cp*ps;
		inform.put("keyword", keyword);
		inform.put("startRow", range1);
		inform.put("endRow", range2);		
		return boardMapper.selectBySubject(inform);
	}
	
	@Override
	public long totalS() {
		return boardMapper.total();
	}

	@Override
	public Board contentS(int seq) {
		return boardMapper.content(seq);
	}

	@Override
	public void delS(int seq) {
		boardMapper.del(seq);
	}

	
	@Override
	public boolean insertS(Board dto) {
		return boardMapper.insert(dto);
	}

	@Override
	public boolean updateS(Board dto) {
		return boardMapper.update(dto);
	}

	@Override
	public ListResult getListResultS(int cp, int ps) {
		ArrayList<Board> list = listS(cp, ps);
		long totalCount = totalS();
		long totalPageCount = totalCount/ps; 
		if(totalCount%ps != 0) totalPageCount++;

		return new ListResult(cp, totalCount, ps, list, totalPageCount);
	}
	
	public ListResult getSearchResultS(int cp, int ps, String writer, String subject) {
		ArrayList<Board> list = new ArrayList<Board>();
		if(subject==null) list = selectByWriter(cp, ps, writer);
		if(writer==null) list = selectBySubject(cp, ps, subject);
		long totalCount = totalS();
		long totalPageCount = totalCount/ps; 
		if(totalCount%ps != 0) totalPageCount++;
		
		return new ListResult(cp, totalCount, ps, list, totalPageCount);
	}
	
	@Transactional // 파일 업로드와 보드 업로드 같이 실행
	@Override
	public boolean insertFileS(Board dto, ArrayList<MultipartFile> files) {	
		if(insertS(dto)) {
			for(MultipartFile file : files) {
				String ofname = file.getOriginalFilename();
				if(ofname != null) {
					ofname = ofname.trim();
					if(ofname.length() != 0) {
						String fname = fileUploadService.saveStore(file);
						long fsize = file.getSize();
						boardMapper.insertFile(new File(-1L, fname, ofname, fsize, -1));
						
					}
				}else {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	@Override
	public ArrayList<File> selectFileBySeqS(int seq) {
		return boardMapper.selectFileBySeq(seq);
	}
	
	@Override
	public void delFileS(long f_num) {
		boardMapper.delFile(f_num);
	}
	
}
