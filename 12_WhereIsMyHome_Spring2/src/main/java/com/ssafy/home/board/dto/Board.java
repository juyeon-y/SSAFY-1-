package com.ssafy.home.board.dto;

import java.util.Date;
import java.util.List;

public class Board {
	private int code, originNo, groupOrd, groupLayer;
	private String title, content, writer;
	private Date reg_datetime;
	private List<FileInfoDto> fileInfos;

	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board(int code, int originNo, int groupOrd, int groupLayer, String title, String content, String writer,
			Date reg_datetime, List<FileInfoDto> fileInfos) {
		super();
		setCode(code);
		setOriginNo(originNo);
		setGroupOrd(groupOrd);
		setGroupLayer(groupLayer);
		setTitle(title);
		setContent(content);
		setWriter(writer);
		setReg_datetime(reg_datetime);
		setFileInfos(fileInfos);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		if (code > -1)
			this.code = code;
	}

	public int getOriginNo() {
		return originNo;
	}

	public void setOriginNo(int originNo) {
		if (originNo > -1)
			this.originNo = originNo;
	}

	public int getGroupOrd() {
		return groupOrd;
	}

	public void setGroupOrd(int groupOrd) {
		if (groupOrd > -1)
			this.groupOrd = groupOrd;
	}

	public int getGroupLayer() {
		return groupLayer;
	}

	public void setGroupLayer(int groupLayer) {
		if (groupLayer > -1)
			this.groupLayer = groupLayer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title != null)
			this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		if (content != null)
			this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		if (writer != null)
			this.writer = writer;
	}

	public Date getReg_datetime() {
		return reg_datetime;
	}

	public void setReg_datetime(Date reg_datetime) {
		if (reg_datetime != null)
			this.reg_datetime = reg_datetime;
	}

	public List<FileInfoDto> getFileInfos() {
		return fileInfos;
	}

	public void setFileInfos(List<FileInfoDto> fileInfos) {
		if (fileInfos != null)
			this.fileInfos = fileInfos;
	}

}