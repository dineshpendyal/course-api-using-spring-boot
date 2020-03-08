package com.nttdata.webapi.courseapi.coursemodel;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.webapi.courseapi.exceptions.coursenotfoundexception;

@RestController
@RequestMapping("/rest-api/courseapi")
public class courseresource {

	@Autowired
	courserepository courserep;
	@GetMapping("/getallcourses")
	
	public List<coursedetails> getAll()
	{
		return courserep.findAll();
		
	}

@PostMapping("/addacourse")
public coursedetails addcourse(@RequestBody coursedetails course) 
	{
	return courserep.save(course);
		
	}
	
@PutMapping("/updatecoursebyid/{id}")
public coursedetails updatecourse(@RequestBody coursedetails courseforupdating,@PathVariable int id) 
	{
		coursedetails course=courserep.findById(id).orElseThrow(() -> new coursenotfoundexception(id));
		course.setCoursedesc(courseforupdating.getCoursedesc());
		course.setCoursename(courseforupdating.getCoursename());
		coursedetails updatedcourse=courserep.save(course);
		return updatedcourse;
	}
	
	
	@GetMapping("getcoursebyid/{id}")
	public coursedetails findcoursebyid(@PathVariable int id) {
		
		return courserep.findById(id).orElseThrow(() -> new coursenotfoundexception(id));
		}

	
@DeleteMapping("/deletecoursebyid/{id}")
public ResponseEntity<?>deletecoursebyid(@PathVariable int id)
	{
		//courserep.deleteById(id).orElseThrow(() -> new coursenotfoundexception(id));
		coursedetails course=courserep.findById(id).orElseThrow(() -> new coursenotfoundexception(id));
		courserep.delete(course);
		return ResponseEntity.ok("succesfully deleted the course with id"+id);
	}
	
}
	

