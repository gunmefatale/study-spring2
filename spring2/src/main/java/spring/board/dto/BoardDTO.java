package spring.board.dto;

import java.sql.Timestamp;

public class BoardDTO {

	private Integer num;
	private String writer;
	private String subject;
	private String email;
	private String content;
	private String pw;
	private Timestamp reg;
	private Integer readcount;
	private Integer ref;
	private Integer re_step;
	private Integer re_level;
	
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public Timestamp getReg() {
		return reg;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	public Integer getReadcount() {
		return readcount;
	}
	public void setReadcount(Integer readcount) {
		this.readcount = readcount;
	}
	public Integer getRef() {
		return ref;
	}
	public void setRef(Integer ref) {
		this.ref = ref;
	}
	public Integer getRe_step() {
		return re_step;
	}
	public void setRe_step(Integer re_step) {
		this.re_step = re_step;
	}
	public Integer getRe_level() {
		return re_level;
	}
	public void setRe_level(Integer re_level) {
		this.re_level = re_level;
	}
}
