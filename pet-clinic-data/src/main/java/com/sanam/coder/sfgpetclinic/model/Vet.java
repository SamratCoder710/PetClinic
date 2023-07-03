package com.sanam.coder.sfgpetclinic.model;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vets")
public class Vet extends Person {
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="vet_specialities",joinColumns = @JoinColumn(name="vet_id"),
	inverseJoinColumns = @JoinColumn(name = "speciality_id") )
	private Set<Speciality> specialities = new HashSet<>();

}
