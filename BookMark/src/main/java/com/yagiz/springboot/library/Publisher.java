package com.yagiz.springboot.library;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "publisher")
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	private String name;
	private String details;
	@OneToMany(mappedBy = "publisher", cascade =CascadeType.ALL)
	private Set<Book> books;
	
	public Publisher() {
		
	}
	
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
