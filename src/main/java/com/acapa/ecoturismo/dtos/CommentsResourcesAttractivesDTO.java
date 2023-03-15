package com.acapa.ecoturismo.dtos;

import com.acapa.ecoturismo.entitys.ResourcesAttractives;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CommentsResourcesAttractivesDTO {
    
    private long id;
    @NotEmpty
    @Size(min = 2, message= "comments body must have at least two characters")
    private String body;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min = 2, message= "comments name user name must have at least two characters")
    private String name;
    @NotEmpty
    @Size(min = 2, message= "username img must have at least two characters")
    private String urlImgSession;

    private ResourcesAttractives resourcesAttractives;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrlImgSession() {
		return urlImgSession;
	}

	public void setUrlImgSession(String urlImgSession) {
		this.urlImgSession = urlImgSession;
	}

	public ResourcesAttractives getResourcesAttractives() {
		return resourcesAttractives;
	}

	public void setResourcesAttractives(ResourcesAttractives resourcesAttractives) {
		this.resourcesAttractives = resourcesAttractives;
	}





}