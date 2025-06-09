package com.example.demo.ServiceImplementation;

import com.example.demo.Service.BookService;
import com.example.demo.dto.BookDto;
import com.example.demo.model.Book;
import com.example.demo.model.Category;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // Spring কে বলে এই ক্লাসটা একটা Service ক্লাস যা Business Logic ধারণ করে
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepo; // BookRepository অটোইনজেক্ট করে, ডাটাবেস অপারেশন করার জন্য
    @Autowired
    private CategoryRepository categoryRepo; // CategoryRepository অটোইনজেক্ট করে, ক্যাটেগরি ডাটা রিট্রিভ/সেভ করার জন্য

    /**
     * সব বইয়ের ডাটা নিয়ে আসার মেথড
     */
    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepo.findAll(); // ডাটাবেস থেকে সব Book entity নিয়ে আসি
        List<BookDto> bookDtos = new ArrayList<>(); // নতুন একটা খালি BookDto তালিকা তৈরি করি

        for (Book book : books) { // প্রতিটা Book entity এর জন্য
            BookDto dto = new BookDto(); // নতুন BookDto অবজেক্ট তৈরি করি
            dto.setId(book.getId()); // Book এর id সেট করি
            dto.setTitle(book.getTitle()); // Book এর title সেট করি
            dto.setAuthor(book.getAuthor()); // Book এর author সেট করি
            dto.setIsbn(book.getIsbn()); // Book এর isbn সেট করি

            if (book.getCategory() != null) { // যদি Book এর সাথে কোনো Category যুক্ত থাকে
                dto.setCategoryId(book.getCategory().getId()); // Category এর id সেট করি
                dto.setCategoryName(book.getCategory().getName()); // Category এর name সেট করি
            }

            bookDtos.add(dto); // BookDto টা List এ যোগ করি
        }

        return bookDtos; // সব BookDto এর List রিটার্ন করি
    }

    /**
     * নির্দিষ্ট আইডির বইয়ের ডাটা নিয়ে আসার মেথড
     */
    @Override
    public BookDto getBookById(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id); // ডাটাবেস থেকে id দিয়ে Book খুঁজি

        if (optionalBook.isPresent()) { // যদি Book পাওয়া যায়
            Book book = optionalBook.get(); // Book entity নিয়ে আসি
            BookDto dto = new BookDto(); // নতুন BookDto তৈরি করি
            dto.setId(book.getId());
            dto.setTitle(book.getTitle());
            dto.setAuthor(book.getAuthor());
            dto.setIsbn(book.getIsbn());

            if (book.getCategory() != null) {
                dto.setCategoryId(book.getCategory().getId());
                dto.setCategoryName(book.getCategory().getName());
            }

            return dto; // BookDto রিটার্ন করি
        }

        return null; // যদি Book না পাওয়া যায়, null রিটার্ন করি
    }

    /**
     * Book ডাটাবেসে সেভ বা আপডেট করার মেথড
     */
    @Override
    public void saveBook(BookDto dto) {
        Book book = new Book(); // নতুন Book entity তৈরি করি

        if (dto.getId() != null) { // যদি BookDto তে id থাকে (মানে এটা আপডেট)
            book.setId(dto.getId()); // সেট করে দেই যাতে আপডেট হয়, না হলে নতুন এন্ট্রি হবে
        }

        book.setTitle(dto.getTitle()); // Book এর title সেট করি
        book.setAuthor(dto.getAuthor()); // author সেট করি
        book.setIsbn(dto.getIsbn()); // isbn সেট করি

        Optional<Category> optionalCategory = categoryRepo.findById(dto.getCategoryId()); // Category খুঁজি dto থেকে পাওয়া categoryId দিয়ে
        if (optionalCategory.isPresent()) { // যদি Category পাওয়া যায়
            book.setCategory(optionalCategory.get()); // Book এর সাথে Category সেট করি
        }

        bookRepo.save(book); // Book entity ডাটাবেসে সেভ বা আপডেট করি
    }

    /**
     * নির্দিষ্ট id এর বই ডিলিট করার মেথড
     */
    @Override
    public void deleteBook(Long id) {
        bookRepo.deleteById(id); // BookRepository থেকে ওই id এর বই ডিলিট করি
    }
}