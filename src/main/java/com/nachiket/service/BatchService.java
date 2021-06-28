package com.nachiket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nachiket.client.FacultyClient;
import com.nachiket.dao.BatchDAO;
import com.nachiket.model.Batch;
import com.nachiket.vo.Faculty;
import com.nachiket.vo.ResponseVO;

import lombok.extern.java.Log;

@Log
@Service
public class BatchService {

	@Autowired
	private BatchDAO batchDTO;
	
	private String URL="";
	
	@Autowired
	private FacultyClient facultyClient;
	
	public Batch createBatch(Batch batch)
	{
		log.info("Going to create Batch in BatchService->>createBatch");
		if (batch!=null)
		{
			System.out.println(batch);
			batchDTO.save(batch);
		}
		
		log.info("batch is registered now");
		return batch;
	}
	
	public Batch updateBatch(Batch batch)
	{
		log.info("Ging to update batch in BatchService->>updatebatch");
		batchDTO.save(batch);
		log.info("batch is updated now");
		return batch;
	}
	public String  deleteBatch(int id)
	{
		log.info("Ging to delete batch in BatchService->>deletebatch");
		String msg;
		if(batchDTO.findById(id).isPresent())
		{
			batchDTO.deleteById(id);
			msg="batch deleted with ID: "+id;
			log.info("batch is deleted now");
		}
		else
			msg="batch not found with ID: "+id;
		
		return msg;
		
	}
	public Batch findbatch(int id)
	{
		log.info("Ging to find batch in batchService->>findbatch");
		Optional<Batch> batchOp=batchDTO.findById(id);
		if(batchOp.isPresent())
			return batchOp.get();
		else
			
		return null;
		
	}

	public List<Batch> findAllbatch() {
		// TODO Auto-generated method stub
		return batchDTO.findAll();
	}
	
	public void linkBacth(int batchId,int facultyID) {
		Batch batch=batchDTO.getById(batchId);
		Faculty facObj=facultyClient.findFacultyByID(facultyID);
		System.out.println(facObj);
		batch.setFaculty(facObj);
		batchDTO.save(batch);
		/*
		 * ResponseVO vo=new ResponseVO(); vo.setBatch(batch); vo.setFaculty(facObj);
		 * //batch.setFacultyID(facultyID);
		 */			
	}
	/*
	 * public Batch returnObject(int batchID) { //ResponseVO obj=new ResponseVO();
	 * Batch batch=batchDTO.findById(batchID).get();
	 * 
	 * List<Integer> intList = null; for(Skills skillslist:batch.getSkillList()) {
	 * intList.add(skillslist.getSkillId()); }
	 * 
	 * List<Skills> skillList= skillsClient.findAllSkillsByID(intList);
	 * 
	 * //obj.setFacult(batch); batch.setSkillList(skillList);
	 * 
	 * return batch; }
	 */
}
