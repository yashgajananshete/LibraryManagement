package com.libraryManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libraryManagement.entity.Book;
import com.libraryManagement.entity.MyBook;
import com.libraryManagement.service.BookService;
import com.libraryManagement.service.MyBookService;


@Controller
public class libraryController {
	
	@Autowired
	BookService bSer;
	@Autowired
	MyBookService mbSer;

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	@RequestMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	@RequestMapping("/available_books")
	public ModelAndView availableBooks() {
		java.util.List<Book> list = bSer.getAllBook();
		ModelAndView mav = new ModelAndView();
		mav.addObject("bokk", list);
		mav.setViewName("availableBooks");//same as that of your html page name
		//you can directly return new ModelAndView("bookList", "book", list)
		return mav;
	}
	
	@RequestMapping("/save")
	public String saveBook(@ModelAttribute Book b) {
		bSer.savee(b);
		return "redirect:/available_books";
	}
	@RequestMapping("/editBook/{id}")
	public String editBookById(@PathVariable("id") int id, Model m) {
		Book b = bSer.getBookById(id);
		m.addAttribute("bookObj", b);
		return "editBook";
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bSer.deleteById(id);
		return "redirect:/available_books";
	}
	
	
	
	
	@RequestMapping("/mylist/{id}")
	public String saveBook(@PathVariable("id") int id) {
		Book b = bSer.getBookById(id);
		MyBook myBook = new MyBook(b.getId(), b.getName() , b.getAuthor(), b.getPrice());
		mbSer.savee(myBook);
		return "redirect:/available_books";
	}
	
	@RequestMapping("/my_books")
	public ModelAndView showMyBooks() {
		java.util.List<MyBook> list = mbSer.getBookList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("bookk", list);
		mav.setViewName("myBooks");//same as that of your html page name
		//you can directly return new ModelAndView("bookList", "book", list)
		return mav;
	}
	
	
	@RequestMapping("/deleteMyBook/{id}")
	public String deleteMyBook(@PathVariable("id") int id) {
		mbSer.deleteBookById(id);
		return "redirect:/my_books";
	}
	
	
}
