package com.wipro.velocity.model;


import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection  = "ministry")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MinistryModel {
	
	private String ministryId;
	private String password;

}
