package com.example.demo.controller;

import com.example.demo.Service.BookService;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling book-related web requests
 * বই সম্পর্কিত ওয়েব রিকোয়েস্ট হ্যান্ডল করার কন্ট্রোলার
 */
@Controller // Marks this as a Spring MVC Controller (স্প্রিং MVC কন্ট্রোলার হিসেবে চিহ্নিত)
public class BookController {

    @Autowired // Injects BookService implementation (BookService ইম্প্লিমেন্টেশন ইনজেক্ট করে)
    private BookService bookService;

    /**
     * Displays home page with list of all books
     * সব বইয়ের তালিকা সহ হোম পেজ প্রদর্শন করে
     * @param model View model to pass data to template (টেমপ্লেটে ডাটা পাঠানোর মডেল)
     * @return index view (index টেমপ্লেট)
     */
    @GetMapping("/") // Handles GET requests to root URL (রুট URL-এর GET রিকোয়েস্ট হ্যান্ডল করে)
    public String viewHomePage(Model model) {
        // Add the list of books to the model to display in the view
        model.addAttribute("listBooks", bookService.getAllBooks());
        return "index"; // Corresponds to index.html (index.html টেমপ্লেটের সাথে মিলে যায়)
    }

    /**
     * Shows form for adding a new book
     * নতুন বই যোগ করার ফর্ম দেখায়
     * @param model View model (ভিউ মডেল)
     * @return new_book view (new_book টেমপ্লেট)
     */
    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model) {
        Book book = new Book(); // Create empty book object (খালি বই অবজেক্ট তৈরি করে)
        model.addAttribute("book", book); // Add to model (মডেলে যোগ করে)
        return "new_book"; // Corresponds to new_book.html (new_book.html টেমপ্লেটের সাথে মিলে যায়)
    }

    /**
     * Saves a book to database
     * ডাটাবেসে একটি বই সংরক্ষণ করে
     * @param book Book object from form submission (ফর্ম সাবমিশন থেকে বই অবজেক্ট)
     * @return Redirect to home page (হোম পেজে রিডাইরেক্ট করে)
     */
    @PostMapping("/saveBook") // Handles POST requests to /saveBook (/saveBook-এ POST রিকোয়েস্ট হ্যান্ডল করে)
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book); // Save book via service (সার্ভিসের মাধ্যমে বই সংরক্ষণ করে)
        return "redirect:/"; // Redirect prevents duplicate submissions (রিডাইরেক্ট ডুপ্লিকেট সাবমিশন প্রতিরোধ করে)
    }

    /**
     * Shows form for updating existing book
     * বিদ্যমান বই আপডেট করার ফর্ম দেখায়
     * @param id Book ID to update (আপডেট করার বইয়ের আইডি)
     * @param model View model (ভিউ মডেল)
     * @return update_book view (update_book টেমপ্লেট)
     */
    @GetMapping("/showFormForUpdate/{id}") // Handles path variable (পাথ ভ্যারিয়েবল হ্যান্ডল করে)
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Book book = bookService.getBookById(id); // Get book by ID (আইডি দিয়ে বই পাওয়া)
        // Add the book to the model so Thymeleaf can pre-fill the form
        model.addAttribute("book", book);
        return "update_book"; // Corresponds to update_book.html (update_book.html টেমপ্লেটের সাথে মিলে যায়)
    }

    /**
     * Deletes a book by ID
     * আইডি দিয়ে একটি বই মুছে ফেলে
     * @param id Book ID to delete (মুছে ফেলার বইয়ের আইডি)
     * @return Redirect to home page (হোম পেজে রিডাইরেক্ট করে)
     */
    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id") long id) {
        bookService.deleteBookById(id); // Delete book by ID (আইডি দিয়ে বই মুছে ফেলা)
        return "redirect:/"; // Redirect to home page (হোম পেজে রিডাইরেক্ট করা)
    }
}