package com.ssma.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artist {
	private int id;
	private String regDate;
	private String updateDate;
	private String name;
	private String gender;
	private String birth;

}
