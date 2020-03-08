package com.nttdata.webapi.courseapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class coursenotfoundexception extends RuntimeException{

	public coursenotfoundexception(int courseid)
	{
		super(String.format("no course id found with id ", courseid));
		
	}

}
