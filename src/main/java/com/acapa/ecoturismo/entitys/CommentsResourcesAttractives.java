package com.acapa.ecoturismo.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "commentsresourceattractive", uniqueConstraints = { @UniqueConstraint(columnNames={"body"})})
public class CommentsResourcesAttractives {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @Column(name = "body", nullable = false, length = 100)
    private String body;
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "urlImgsession", nullable = false, length = 100)
    private String urlImgSession;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resourcesattractives_id",nullable = false)
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

	public CommentsResourcesAttractives() {
	super();
    }
    
}
