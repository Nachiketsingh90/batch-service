package com.nachiket.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nachiket.model.Batch;
import com.nachiket.service.BatchService;

import lombok.extern.java.Log;

@RestController
@RequestMapping("/batch")
@Log
public class BatchController {

	@Autowired
	private BatchService batchService;

	@PostMapping("/registerBatch")
	public ResponseEntity registerBatch(@RequestBody Batch batch) {
		log.info("BatchController-->registerBatch");
		if(batch!=null)
		{
			batchService.createBatch(batch);
			return ResponseEntity.status(HttpStatus.CREATED).

					body("Batch is created with id:" + batch.getBatchID());
		}	
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).

					body("Invalid Data");
		}
		

		
	}

	@GetMapping("/findBatchByID/{batchID}")
	public Batch findBatchByID(@PathVariable int batchID) {
		log.info("BatchController-->findBatchByID");
		Batch obj = batchService.findbatch(batchID);
		System.out.println(obj);
		return obj;

	}

	@PutMapping("/updateBatch")
	public ResponseEntity updateBatch(@RequestBody Batch batch) {
		log.info("BatchController-->updateBatch");
		batchService.updateBatch(batch);
		// return new ResponseEntity(Batch, new HttpHeaders().set, HttpStatus.CREATED);

		return ResponseEntity.status(HttpStatus.OK).

				body("Batch is updated with id:" + batch.getBatchID());
	}

	@DeleteMapping("/deleteBatchByID/{BatchID}")
	public ResponseEntity deleteBatchByID(@PathVariable int batchID) {
		log.info("BatchController-->deleteBatchByID");
		String msg = batchService.deleteBatch(batchID);

		return new ResponseEntity(msg, new HttpHeaders(), HttpStatus.OK);

	}

	@GetMapping("/findAllBatch")
	public ResponseEntity<Batch> findAllBatch() {
		// log.info("BatchController-->findAllBatch");
		System.out.println("findall called");
		List<Batch> batchList = batchService.findAllbatch();
		if (batchList.size() == 0) {

			return new ResponseEntity("No Batch Added till now", new HttpHeaders(), HttpStatus.FOUND);
		} else {

			return new ResponseEntity(batchList, new HttpHeaders(), HttpStatus.OK);
		}

	}
	@PostMapping("/linkBatch_withFaculty/batchId/{batchId}/facultyID/{facultyID}")
	public ResponseEntity<String> linkBatch_withFaculty(@PathVariable int batchId,@PathVariable int facultyID) {
		System.out.println(" batchid"+batchId+" facultyid "+facultyID);
		 log.info("BatchController-->linkBatch_withFaculty");
		
		 batchService.linkBacth(batchId, facultyID);
	

			return new ResponseEntity("Batch is assigned to faculty", new HttpHeaders(), HttpStatus.FOUND);
		

	}

}
