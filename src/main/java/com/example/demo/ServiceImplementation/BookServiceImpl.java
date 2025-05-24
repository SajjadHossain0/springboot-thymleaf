package com.example.demo.ServiceImplementation;

import com.example.demo.Service.BookService;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Implementation of BookService interface
 * BookService ইন্টারফেসের বাস্তবায়ন
 *
 * Contains the actual business logic for book operations
 * বই সম্পর্কিত অপারেশনের প্রকৃত বিজনেস লজিক ধারণ করে
 */
@Service // Marks this as a Spring service component (স্প্রিং সার্ভিস কম্পোনেন্ট হিসেবে চিহ্নিত)
public class BookServiceImpl implements BookService {

    @Autowired // Automatically injects BookRepository (BookRepository অটোমেটিক ইনজেক্ট করে)
    private BookRepository bookRepository;

    /**
     * Fetches all books from database
     * ডাটাবেস থেকে সব বই সংগ্রহ করে
     * @return List of all books (সব বইয়ের তালিকা)
     */
    @Override
    public List<Book> getAllBooks() {
        // Uses repository's findAll() method
        // রিপোজিটোরির findAll() মেথড ব্যবহার করে
        return bookRepository.findAll();
    }

    /**
     * Saves or updates a book
     * একটি বই সংরক্ষণ বা আপডেট করে
     * @param book The book to save (সংরক্ষণ করার বই)
     */
    @Override
    public void saveBook(Book book) {
        // Uses repository's save() method
        // রিপোজিটোরির save() মেথড ব্যবহার করে
        bookRepository.save(book);
    }

    /**
     * Finds a book by its ID
     * আইডি ব্যবহার করে একটি বই খুঁজে বের করে
     * @param id The ID of the book (বইয়ের আইডি)
     * @return The found book (খুঁজে পাওয়া বই)
     * @throws NoSuchElementException if book not found (যদি বই না পাওয়া যায়)
     */
    @Override
    public Book getBookById(Long id) {
        // Uses repository's findById() method
        // রিপোজিটোরির findById() মেথড ব্যবহার করে
        return bookRepository.findById(id).get();
    }

    /**
     * Deletes a book by its ID
     * আইডি ব্যবহার করে একটি বই মুছে ফেলে
     * @param id The ID of the book to delete (মুছে ফেলার বইয়ের আইডি)
     */
    @Override
    public void deleteBookById(Long id) {
        // Uses repository's deleteById() method
        // রিপোজিটোরির deleteById() মেথড ব্যবহার করে
        bookRepository.deleteById(id);
    }
}