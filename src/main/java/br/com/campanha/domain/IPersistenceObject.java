package br.com.campanha.domain;

import java.io.Serializable;

public interface IPersistenceObject extends Serializable {

	public BaseModel getBaseModel();

	public void setBaseModel(BaseModel baseCrud);

	public Long getId();

	public void setId(Long id);
	
}
