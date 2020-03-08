package com.nttdata.webapi.courseapi.coursemodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coursedetails")
public class coursedetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "courseid")
	private  int courseid;
	@Column(name = "coursename")
	private String coursename;
	@Column(name = "coursedescription")
	private String coursedesc;
	
	
	public coursedetails()
	{
		
	}
	
	public coursedetails(int courseid, String coursename, String coursedesc) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.coursedesc = coursedesc;
	}

	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCoursedesc() {
		return coursedesc;
	}
	public void setCoursedesc(String coursedesc) {
		this.coursedesc = coursedesc;
	}



}
