package com.sanam.coder.sfgpetclinic.services.map;

import java.util.Collections;
import java.util.HashMap;

import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import com.sanam.coder.sfgpetclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {
	
	protected Map<Long,T> map = new HashMap<>();
	
	Set<T> findAll(){
		return new HashSet<>(map.values());
	}
	
	T save(T object) {
		if(object != null) {
			if(object.getId() == null) {
				object.setId(getNextId());
			}
			map.put(object.getId(), object);
		}else {
			throw new RuntimeException("Object cannot be null");
		}
		return object;
	}
	
	T findById(ID id) {
		return map.get(id);
	}
	
	
	void deleteById(ID id) {
		map.remove(id);
	}
	
	void delete(T object) {
		for(Long m:map.keySet()) {
			if(map.get(m).equals(object)) {
				map.remove(m);
			}
		}
	}
	
	private Long getNextId() {
		Long nextId = null;
		try {
			nextId =  Collections.max(map.keySet())+1;
		}catch(NoSuchElementException e) {
			nextId = 1L;
		}
		return nextId;
		
	}
	
	
	
	
}
