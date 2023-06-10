package com.sanam.coder.sfgpetclinic.services;

import com.sanam.coder.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	
	Owner findByLastName(String lastName);


}
