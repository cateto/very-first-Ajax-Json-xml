package com.md.controller;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.file.filesetting.Path;
import com.md.domain.Board;
import com.md.domain.File;
import com.md.service.BoardService;
import com.md.service.BoardServiceImpl;
import com.md.service.FileUploadService;
import com.md.vo.ListResult;

import lombok.extern.log4j.Log4j;

@RequestMapping("/board/*")
@Log4j
@Controller
public class BoardController {
	
	@Resource
	private BoardService service;

	
	@GetMapping("/list.do")
	public ModelAndView list(Integer cp, Integer ps) {
		if(cp==null) cp=1;
		if(ps==null) ps=3;	
		
		ListResult list = service.getListResultS(cp, ps);
		ModelAndView mv = new ModelAndView("board/BoardList", "listResult", list);
		if(list.getList().size()==0){
			if(cp>1){
				return new ModelAndView("redirect:list.do?cp="+(cp-1));
			}else{
				return new ModelAndView("redirect:list.do", "listResult", list);
			}
		}else{
			return mv;
		}
	}
	
	@PostMapping("/list.do")
	public ModelAndView list(Integer cp, Integer ps, String writer, String subject) {
		if(cp==null) cp=1;
		if(ps==null) ps=10;
		BoardServiceImpl service2 = (BoardServiceImpl)service;
		ListResult list = service2.getSearchResultS(cp, ps, writer, subject);
		return new ModelAndView("board/BoardList", "listResult", list);
	
	}
	
	@GetMapping("/write.do")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/write.do")
	public ModelAndView write(Board dto, ArrayList<MultipartFile> files) {
		boolean flag = service.insertFileS(dto, files);
		
		return new ModelAndView("board/WriteOK","flag", flag);
	}

	@RequestMapping("/content.do")
	public ModelAndView content(@RequestParam int seq) {
		Board board = service.contentS(seq);
		ArrayList<File> fList = service.selectFileBySeqS(seq);
		ModelAndView mv = new ModelAndView("board/BoardContent");
		mv.addObject("board", board);
		log.info("hello: "+fList);
		mv.addObject("fList", fList);
		
		return mv;
	}
	
	@RequestMapping("/del.do")
	public String del(@RequestParam int seq) {
		service.delS(seq);
		return "redirect:list.do?cp=1&ps=3";
	}
	
	@GetMapping("/update.do")
	public ModelAndView content2(@RequestParam int seq) {
		Board board = service.contentS(seq);
		return new ModelAndView("board/BoardContentUpd", "board", board);
	}
	@PostMapping("/update.do")
	public ModelAndView content2(Board dto) {
		boolean flag = service.updateS(dto);
		return new ModelAndView("board/BoardContentUpd_post", "flag", flag);
	}
	@GetMapping("file_download")
	public ModelAndView fileDownload(String fname) {
		java.io.File file = new java.io.File(Path.FILE_STORE, fname);
		if(file.exists()) {
			return new ModelAndView("fileDownloadView", "downloadFile", file);
		}else {
			return new ModelAndView("redirect:content.do");
		}
	}
	@GetMapping("file_del")
	public String fileDel(String fname, long f_num, int seq) {
		java.io.File file = new java.io.File(Path.FILE_STORE, fname);
		if(file.exists()) {
			file.delete();
			service.delFileS(f_num);
		}
		
		return "redirect:content.do?seq="+seq;
	}
}
