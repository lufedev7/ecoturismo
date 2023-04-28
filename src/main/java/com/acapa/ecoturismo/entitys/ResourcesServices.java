package com.acapa.ecoturismo.entitys;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "resourcessevices", uniqueConstraints = { @UniqueConstraint(columnNames={"nameresource"})})
public class ResourcesServices {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nameresource", nullable = false, length = 100)
    private String nameResource;
    @Column(name = "url", nullable = false, length = 100)
    private String url;
	@Column(name = "description", nullable = false, length = 100)
    private String description;
    @Column(name = "typeresource", nullable = false, length = 100)
    private boolean typeResource;
	@Column(name = "timestamp", nullable = false, length = 100)
	private String timeStamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "services_id",nullable = false)
    private Services services;

    @JsonBackReference
    @OneToMany(mappedBy = "resourcesServices",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<CommentsResourcesServices> commentsResourceServices = new HashSet<>();




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

	public boolean isTypeResource() {
		return typeResource;
	}

	public void setTypeResource(boolean typeResource) {
		this.typeResource = typeResource;
	}

	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}

	public Set<CommentsResourcesServices> getCommentsResourceServices() {
		return commentsResourceServices;
	}

	public void setCommentsResourceServices(Set<CommentsResourcesServices> commentsResourceServices) {
		this.commentsResourceServices = commentsResourceServices;
	}

	public ResourcesServices() {
	super();
    }

	

	public ResourcesServices(Long id, String nameResource, String url, String description, boolean typeResource,
			String timeStamp, Services services, Set<CommentsResourcesServices> commentsResourceServices) {
		this.id = id;
		this.nameResource = nameResource;
		this.url = url;
		this.description = description;
		this.typeResource = typeResource;
		this.timeStamp = timeStamp;
		this.services = services;
		this.commentsResourceServices = commentsResourceServices;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    
}
