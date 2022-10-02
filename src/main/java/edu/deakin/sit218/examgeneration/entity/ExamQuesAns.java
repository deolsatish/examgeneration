package edu.deakin.sit218.examgeneration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ExamQuesAns {
	
	
	protected int id;
	
	@NotNull(message = "is required")
	@Size(min=1, message="is required")
	@Pattern(regexp="^[A-Z][a-z]*", message="A name should start with a capital letter")

	protected String lecturename="";
	
	@NotNull(message = "is required")
	@Size(min=1, message="is required")
	protected String question="";
	
	
	@NotNull(message = "is required")
	@Size(min=1, message="is required")
	@Pattern(regexp="^[A-Z][a-z]*", message="A name should start with a capital letter")
	protected String answer="";
	
	@NotNull(message = "is required")
	@Size(min=1, message="is required")
	@Pattern(regexp="^[A-Z][a-z]*", message="A name should start with a capital letter")
	protected String areaofknowledge="";
	
	
	public ExamQuesAns(String lecturename, String question, String answer, String areaofknowledge) {
		
		setLecturename(lecturename);
		setQuestion(question);
		setAnswer(answer);
		setAreaofknowledge(areaofknowledge);
		
	}
	
	public ExamQuesAns(String areaofknowledge) {
		
		setAreaofknowledge(areaofknowledge);
		
	}
	
	
	
	public ExamQuesAns() {
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the lecturename
	 */
	public String getLecturename() {
		return lecturename;
	}

	/**
	 * @param lecturename the lecturename to set
	 */
	public void setLecturename(String lecturename) {
		this.lecturename = lecturename;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the areaofknowledge
	 */
	public String getAreaofknowledge() {
		return areaofknowledge;
	}

	/**
	 * @param areaofknowledge the areaofknowledge to set
	 */
	public void setAreaofknowledge(String areaofknowledge) {
		this.areaofknowledge = areaofknowledge;
	}
	
	

}
