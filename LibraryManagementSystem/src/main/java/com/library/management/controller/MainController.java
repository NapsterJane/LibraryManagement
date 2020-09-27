package com.library.management.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.library.management.entity.Author;
import com.library.management.entity.Books;
import com.library.management.entity.Publisher;
import com.library.management.entity.Users;
import com.library.management.service.BooksService;
import com.library.management.service.UserService;

@Controller
public class MainController {
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	@Autowired
	BooksService booksservice;
	@Autowired
	UserService userservice;
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String loginPage() {
		return "loginpage";
	}
	
	@PostMapping("userlogin")
	public String login(@RequestParam("logger") String logger, @RequestParam("uname") String username, 
			@RequestParam("password") String password){
		ModelAndView mav = new ModelAndView();
		if(logger.equalsIgnoreCase("admin") && username.equalsIgnoreCase("admin") && password.equals("admin")) {
			mav.addObject("greet", "Admin");
			return "adminhome";
		}
		else {
			
			return "userhome";	
		}
	}
	
	@GetMapping("users")
	public String usersPage(Model model) {
		List<Books> allbooks = booksservice.viewAllBooks();
		model.addAttribute("books", allbooks);
		return "users";
	}
	
	@PostMapping("saveuser")
	public String saveNewUser(//@RequestParam("fullname") String fullname, @RequestParam("username") String username,
	/* @RequestParam("password") String password,*/ HttpServletRequest request, @ModelAttribute("user")Users user) {
		
		String [] books = request.getParameterValues("bookallowed");
		//Users users = new Users();
		//users.setBookallowed(bookallowed);
		user = userservice.saveNewUser(user);
		return "users";
	}
	
	@GetMapping("books")
	public String booksPage(Model model) {
		List<Books> allbooks = booksservice.viewAllBooks();
		model.addAttribute("books", allbooks);
		return "books";
	}
	
	@PostMapping("savebook")
	public String saveNewBook(Model model, HttpServletRequest request, 
			final @RequestParam("file") MultipartFile file){
		try {
		String filename = file.getOriginalFilename();
		String filepath = Paths.get(uploadDirectory, filename).toString();
		
		//Upload Cover Image
		BufferedOutputStream stream = new BufferedOutputStream(new
		FileOutputStream(new File(filepath))); 
		stream.write(file.getBytes());
		stream.close();
		
		Books book = new Books();
		book.setBookname(request.getParameter("bookname"));
		book.setCategory(request.getParameter("category"));
		book.setCoverimage(filename);
		
		Author author = new Author();
		author.setAuthorname(request.getParameter("author"));
		
		Publisher publisher = new Publisher();
		publisher.setPublishername(request.getParameter("publisher"));
		
		Books newBook = booksservice.saveBook(book, author, publisher);
		if(newBook == null) {
			model.addAttribute("error", "Book Not Saved");
		}else {
			model.addAttribute("success", "Book Saved Successfully");
		}
		List<Books> allbooks = booksservice.viewAllBooks();
		model.addAttribute("books", allbooks);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("image not found...");
		}
		return "books";
	}
	
		@PostMapping(value = "updatebook")
		public String bookUpdate( /* @ModelAttribute("book") Books books */ HttpServletRequest request, Model model) {
			
			Author author = new Author();
			author.setAuthorname(request.getParameter("author"));
			author.setAuthor_id(Integer.parseInt(request.getParameter("authorid")));
			
			Publisher publisher = new Publisher();
			publisher.setPublishername(request.getParameter("publisher"));
			publisher.setPublisher_id(Integer.parseInt(request.getParameter("publisherid")));
			
			int result = 0;
			int result1 = 0;
			
				result = booksservice.updateAuthor(author.getAuthor_id(), author.getAuthorname());
				result1 = booksservice.updatePublisher(publisher.getPublisher_id(), publisher.getPublishername());
			
			if(result == 1 || result1 == 1) {
				model.addAttribute("success", "updated successfully");
			}else
				model.addAttribute("error", "Not Updated");
			
			List<Books> allbooks = booksservice.viewAllBooks();
			model.addAttribute("books", allbooks);
			
		//	int a = booksservice.updateBook(book, author, publisher);
			return "books";
		}
		
		@PostMapping("deletebook")
		public String deleteBook(Model model,/* @RequestParam("bookid")*/ HttpServletRequest httpServletRequest) {
			Books books = new Books();
			books.setBook_id(Integer.parseInt(httpServletRequest.getParameter("bookid")));
			int result = booksservice.deleteBook(books);
			
			if(result ==1)
				model.addAttribute("error", "Deleted SuccessFully");
				
			List<Books> allbooks = booksservice.viewAllBooks();
			model.addAttribute("books", allbooks);
			return "books";
		}
}
