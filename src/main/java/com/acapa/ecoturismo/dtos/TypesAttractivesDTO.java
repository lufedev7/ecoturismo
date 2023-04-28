package com.acapa.ecoturismo.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class TypesAttractivesDTO {

    private long id;
    @NotEmpty
    @Size(min = 3, message = "El tipo de atractivo debe de tener almenos 3 letras")
    private String typeAttractives;
    @NotEmpty
    private String descriptionType;
	private AttractivesDTO attractivesDTO;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTypeAttractives() {
		return typeAttractives;
	}
	public void setTypeAttractives(String typeAttractives) {
		this.typeAttractives = typeAttractives;
	}
	public String getDescriptionType() {
		return descriptionType;
	}
	public void setDescriptionType(String descriptionType) {
		this.descriptionType = descriptionType;
	}
	public TypesAttractivesDTO() {
	super();
    }
	public AttractivesDTO getAttractivesDTO() {
		return attractivesDTO;
	}
	public void setAttractivesDTO(AttractivesDTO attractivesDTO) {
		this.attractivesDTO = attractivesDTO;
	}

    
}
