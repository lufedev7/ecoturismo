package com.acapa.ecoturismo.entitys;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "commentsresourceservices", uniqueConstraints = { @UniqueConstraint(columnNames = { "body" }) })
public class CommentsResourcesServices {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "body", nullable = false, length = 2000)
	private String body;
	@Column(name = "email", nullable = false, length = 100)
	private String email;
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	@Column(name = "urlImgsession", nullable = false, length = 200)
	private String urlImgSession;
	@Column(name = "timeStamp")
	@CreationTimestamp
	private Instant timeStamp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resourcesservices_id", nullable = false)
	private ResourcesServices resourcesServices;

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

	public CommentsResourcesServices() {
		super();
	}

	public ResourcesServices getResourcesServices() {
		return resourcesServices;
	}

	public void setResourcesServices(ResourcesServices resourcesServices) {
		this.resourcesServices = resourcesServices;
	}

	public Instant getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Instant timeStamp) {
		this.timeStamp = timeStamp;
	}

}
