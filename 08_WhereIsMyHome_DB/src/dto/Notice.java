package dto;

import java.sql.Date;

public class Notice {
	int idx;
	String title, contents;
	int hits;
	String writer;
	Date date;
	
	public Notice(int idx, String title, String contents, int hits, String writer, Date date) {
		super();
		setIdx(idx);
		setTitle(title);
		setContents(contents);
		setHits(hits);
		setWriter(writer);
		setDate(date);
	}
	
	public Notice(int idx, String title, String contents, String writer) {
		super();
		setIdx(idx);
		setTitle(title);
		setContents(contents);
		setWriter(writer);
	}
	

	public Notice(String title, String contents, String writer) {
		super();
		this.title = title;
		this.contents = contents;
		this.writer = writer;
	}

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		//인덱스값은 DB에서 Auto
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if(title!=null)
			this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		if(contents!=null)
			this.contents = contents;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		//생성시 자동으로 0값 넣어주도록
		this.hits = hits;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		if(writer!=null)
			this.writer = writer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		//date 자동생성
		this.date = date;
	}
	
	
	
}
