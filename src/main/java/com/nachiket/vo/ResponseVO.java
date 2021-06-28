
package com.nachiket.vo;

import com.nachiket.model.Batch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data

@AllArgsConstructor

@NoArgsConstructor

@Setter

@Getter
public class ResponseVO {

	private Batch batch;

	private Faculty faculty;

}
