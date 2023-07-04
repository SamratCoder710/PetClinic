package com.sanam.coder.sfgpetclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="pets")
public class Pet extends BaseEntity {
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
	private Set<Visit> visits = new HashSet<>();
	
	

}
