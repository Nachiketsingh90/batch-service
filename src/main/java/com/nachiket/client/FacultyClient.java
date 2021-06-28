package com.nachiket.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nachiket.vo.Faculty;

@FeignClient(name="FACULTY-SERVICE")

public interface FacultyClient {

	@GetMapping("/faculty/findFacultyByID/{facultyID}")
	public Faculty findFacultyByID(@PathVariable int facultyID);

}
