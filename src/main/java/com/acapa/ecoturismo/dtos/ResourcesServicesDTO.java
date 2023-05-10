package com.acapa.ecoturismo.dtos;

import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ResourcesServicesDTO {
	private long id;
	@NotEmpty
	@Size(min = 3, message = "El nombre del recurso debe de tener almenos 3 letras")
	private String nameResource;
	@NotEmpty
	@Size(min = 3, message = "El url del recurso debe de tener almenos 3 letras")
	private String url;
	@NotEmpty
	@Size(min = 3, message = "la descripción del recurso debe de tener almenos 3 letras")
	private String description;
	private boolean typeResource;
	@Size(min = 3, message = "debe ingresar una hora")
	private String timeStamp;
	private Set<CommentsResourceServicesDTO> comments;
	private ServicesDTOApp services;

	public ServicesDTOApp getServices() {
		return services;
	}

	public void setServices(ServicesDTOApp services) {
		this.services = services;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameResource() {
		return nameResource;
	}

	public void setNameResource(String nameResource) {
		this.nameResource = nameResource;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isTypeResource() {
		return typeResource;
	}

	public void setTypeResource(boolean typeResource) {
		this.typeResource = typeResource;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Set<CommentsResourceServicesDTO> getComments() {
		return comments;
	}

	public void setComments(Set<CommentsResourceServicesDTO> comments) {
		this.comments = comments;
	}

}
