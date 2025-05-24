package com.example.demo.Service;

import com.example.demo.model.Book;
import java.util.List;

/**
 * Service layer interface for Book operations
 * বই সম্পর্কিত অপারেশনের সার্ভিস লেয়ার ইন্টারফেস
 *
 * Defines the business logic contract for Book management
 * বই ম্যানেজমেন্টের বিজনেস লজিকের চুক্তি (কন্ট্রাক্ট) নির্ধারণ করে
 */
public interface BookService {

     /**
      * Get all books from database
      * ডাটাবেস থেকে সব বই পেতে
      * @return List of all books (সব বইয়ের লিস্ট)
      */
     List<Book> getAllBooks();

     /**
      * Save or update a book
      * একটি বই সেভ বা আপডেট করতে
      * @param book the book entity to save (সেভ করার বই এনটিটি)
      */
     void saveBook(Book book);

     /**
      * Find a book by its ID
      * আইডি দিয়ে একটি বই খুঁজে পেতে
      * @param id the book ID (বইয়ের আইডি)
      * @return the found book (খুঁজে পাওয়া বই)
      */
     Book getBookById(Long id);

     /**
      * Delete a book by its ID
      * আইডি দিয়ে একটি বই ডিলিট করতে
      * @param id the book ID to delete (ডিলিট করার বইয়ের আইডি)
      */
     void deleteBookById(Long id);
}