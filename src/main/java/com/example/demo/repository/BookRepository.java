package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Book Repository interface for database operations
 * বই রিপোজিটরি ইন্টারফেস - ডাটাবেস অপারেশনের জন্য
 *
 * This interface extends JpaRepository to provide CRUD operations for Book entity
 * এই ইন্টারফেস JpaRepository কে এক্সটেন্ড করে Book এনটিটির জন্য CRUD অপারেশন প্রদান করে
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    /*
     * This empty interface inherits all CRUD operations from JpaRepository:
     * এই খালি ইন্টারফেসটি JpaRepository থেকে সব CRUD অপারেশন ইনহেরিট করে:
     *
     * save() - Save or update a book (বই সেভ বা আপডেট করে)
     * findById() - Find a book by ID (আইডি দিয়ে বই খুঁজে বের করে)
     * findAll() - Get all books (সব বইয়ের তালিকা দেয়)
     * deleteById() - Delete a book by ID (আইডি দিয়ে বই ডিলিট করে)
     * count() - Count total books (মোট বই সংখ্যা দেয়)
     *
     * No need to implement these methods - Spring Data JPA provides implementation automatically
     * এই মেথডগুলো ইম্প্লিমেন্ট করার দরকার নেই - স্প্রিং ডাটা JPA অটোমেটিক ইম্প্লিমেন্টেশন প্রদান করে
     *
     * Generics explanation:
     * Book - The entity type (এনটিটি টাইপ)
     * Long - The type of entity's primary key (প্রাইমারি কী এর টাইপ)
     */
}