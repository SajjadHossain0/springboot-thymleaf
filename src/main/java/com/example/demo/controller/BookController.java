package com.example.demo.controller;

import com.example.demo.Service.BookService;
import com.example.demo.dto.BookDto;
import com.example.demo.model.Book;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // এই ক্লাসটি একটি Spring MVC Controller, যেটা HTTP request হ্যান্ডল করে
public class BookController {

    @Autowired
    private BookService bookService; // Book সম্পর্কিত সার্ভিস মেথড ব্যবহারের জন্য

    @Autowired
    private CategoryRepository categoryRepo; // ক্যাটেগরি ডেটা ফর্মে দেখানোর জন্য

    // হোমপেইজ দেখানোর জন্য: সব বইয়ের তালিকা মডেলে পাঠিয়ে index পেইজ দেখায়
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listBooks", bookService.getAllBooks()); // সব বইয়ের তালিকা মডেলে যুক্ত
        return "index"; // index.html পেইজ রিটার্ন করে
    }

    // নতুন বই যোগ করার ফর্ম দেখানোর জন্য
    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model) {
        model.addAttribute("book", new BookDto()); // খালি BookDto পাঠানো হয় ফর্ম বাউন্ড করার জন্য
        model.addAttribute("categories", categoryRepo.findAll()); // সব ক্যাটেগরি পাঠানো হয় dropdown এর জন্য
        return "new_book"; // new_book.html ফর্ম পেইজ রিটার্ন
    }

    // নতুন বই সেভ করার বা পুরনো বই আপডেট করার জন্য
    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") BookDto bookDto) {
        bookService.saveBook(bookDto); // সার্ভিস মেথডে পাঠিয়ে ডেটা সেভ করানো হয়
        return "redirect:/"; // সেভ শেষে হোমপেইজে রিডিরেক্ট
    }

    // কোনো বই আপডেট করার ফর্ম দেখানোর জন্য
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id)); // ID অনুযায়ী বইয়ের তথ্য এনে মডেলে যুক্ত
        model.addAttribute("categories", categoryRepo.findAll()); // ক্যাটেগরি লিস্ট ফর্মে দেখানোর জন্য
        return "update_book"; // update_book.html ফর্ম পেইজ রিটার্ন
    }

    // কোনো বই ডিলিট করার জন্য
    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id); // ID অনুযায়ী বই ডিলিট করা হয়
        return "redirect:/"; // ডিলিট শেষে হোমপেইজে রিডিরেক্ট
    }
}
