package com.yagiz.springboot.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {


		@Autowired
		private PublisherRepository repo;
		
		public List<Publisher> listAll(){
			return repo.findAll();
		}
		
		public void save(Publisher publisher) {
			repo.save(publisher);
		}
		public Publisher get(Integer pid) {
			return repo.findById(pid).get();
		}
		public void delete(Integer pid) {
			repo.deleteById(pid);
		}

}
