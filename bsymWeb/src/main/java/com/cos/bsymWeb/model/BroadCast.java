package com.cos.bsymWeb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class BroadCast {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	//@Column(unique = false)
	private String broadcastName;
	private String broadcastStartDate;
}
