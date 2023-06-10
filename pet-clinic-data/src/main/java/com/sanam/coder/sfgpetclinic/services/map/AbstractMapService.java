package com.sanam.coder.sfgpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T,ID> {
	
	protected Map<ID,T> map = new HashMap<>();
	
	Set<T> findAll(){
		return new HashSet<>(map.values());
	}
	
	T save(ID id,T object) {
		map.put(id, object);
		return object;
	}
	
	T findById(ID id) {
		return map.get(id);
	}
	
	
	void deleteById(ID id) {
		map.remove(id);
	}
	
	void delete(T object) {
		for(ID m:map.keySet()) {
			if(map.get(m).equals(object)) {
				map.remove(m);
			}
		}
	}
	
	
	
}
