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
@Table(name="types")
public class PetType extends BaseEntity{
	
	@Column(name="name")
	private String name;
	
}
