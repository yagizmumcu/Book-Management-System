package com.yagiz.springboot.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@Autowired
	private BookService service;
	@Autowired
	private PublisherService pservice;
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Book> listBooks = service.listAll();
		model.addAttribute("listBooks", listBooks);
		return "index";
	}
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		List<Publisher> publisher = pservice.listAll();
		model.addAttribute("publisher", publisher);
		
		return "new_book";
	}

	@RequestMapping(value= "/save", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("book") Book book) {
		service.save(book);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{bid}")
	public ModelAndView showEditProductForm(@PathVariable(name= "bid") Integer bid) {
		ModelAndView mav = new ModelAndView("edit_book");
		
		Book book = service.get(bid);
		mav.addObject("book", book);
		List<Publisher> publisher = pservice.listAll();
		mav.addObject("publisher", publisher);
		return mav;
	}
	@RequestMapping("/delete/{bid}")
	public String deleteProduct(@PathVariable(name= "bid") Integer bid){
		service.delete(bid);
		return "redirect:/";
	}

}
