package com.sanam.coder.sfgpetclinic.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "specialities")
public class Speciality extends BaseEntity{

	@Column(name="description")
	private String description;

}
