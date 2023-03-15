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
@Table(name = "resourcesatrractives", uniqueConstraints = { @UniqueConstraint(columnNames={"nameresource"})})
public class ResourcesAttractives {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nameresource", nullable = false, length = 100)
    private String nameResource;
   
	@Column(name = "description", nullable = false, length = 100)
    private String description;
	@Column(name = "timestamp", nullable = false, length = 100)
    private String timeStamp;
    @Column(name = "linkresource", nullable = false, length = 100)
    private String linkResource;
	@Column(name = "typeresource", nullable = false, length = 100)
    private boolean typeResource;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attractive_id",nullable = false)
    private Attractives attractive;

    @JsonBackReference
    @OneToMany(mappedBy = "resourcesAttractives",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<CommentsResourcesAttractives> commentsResourceAttractives = new HashSet<>();
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getNameResource() {
		return nameResource;
	}

	public void setNameResource(String nameResource) {
		this.nameResource = nameResource;
	}

	

	public boolean isTypeResource() {
		return typeResource;
	}

	public void setTypeResource(boolean typeResource) {
		this.typeResource = typeResource;
	}

	public Attractives getAttractive() {
		return attractive;
	}

	public void setAttractive(Attractives attractive) {
		this.attractive = attractive;
	}

	public Set<CommentsResourcesAttractives> getCommentsResourceAttractives() {
		return commentsResourceAttractives;
	}

	public void setCommentsResourceAttractives(Set<CommentsResourcesAttractives> commentsResourceAttractives) {
		this.commentsResourceAttractives = commentsResourceAttractives;
	}

	public ResourcesAttractives() {
	super();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getLinkResource() {
		return linkResource;
	}

	public void setLinkResource(String linkResource) {
		this.linkResource = linkResource;
	}




}
