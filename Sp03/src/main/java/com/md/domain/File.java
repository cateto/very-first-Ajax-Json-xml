package com.md.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class File {

	private long f_num;
	private String fname;
	private String ofname;
	private long fsize;
	private int seq;

}
