package com.nachiket.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.nachiket.vo.Faculty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Batch {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int batchID;
	private String batchName;
	private String batch_working_days;
	private String batchTime;
	private String status;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "faculty")
	private Faculty faculty;
	
	/*
	 * @OneToMany(targetEntity = Skills.class,cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name ="batch_skill",referencedColumnName = "batchID") private
	 * List<Skills> skillList;
	 */
}
