package com.yagiz.springboot.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository repo;
	
	public List<Author> listAll(){
		return repo.findAll();
	}
	
	public void save(Author author) {
		repo.save(author);
	}
	public Author get(Integer aid) {
		return repo.findById(aid).get();
	}
	public void delete(Integer aid) {
		repo.deleteById(aid);
	}

}
