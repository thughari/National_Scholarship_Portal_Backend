package com.wipro.velocity.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "nodalofficer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NodalModel {
	
	private String nodalId;
	private String password;

}
