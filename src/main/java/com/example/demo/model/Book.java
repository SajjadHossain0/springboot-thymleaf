package com.example.demo.model;

import jakarta.persistence.*;

/**
 * Book entity class representing a book in the database
 * বই এনটিটি ক্লাস যা ডাটাবেসে একটি বইকে রিপ্রেজেন্ট করে
 */
@Entity  // Marks this class as a JPA entity (ডাটাবেস টেবিলের সাথে ম্যাপ হবে)
@Table(name = "books")  // Specifies the table name (টেবিলের নাম নির্দিষ্ট করে)
public class Book {

    @Id  // Marks this field as primary key (প্রাইমারি কী হিসেবে চিহ্নিত)
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID (অটো-ইনক্রিমেন্ট আইডি)
    private Long id;  // Unique identifier for each book (প্রতিটি বইয়ের ইউনিক আইডি)

    @Column(nullable = false)  // This field cannot be null (শূন্য/null হতে পারবে না)
    private String title;  // Title of the book (বইয়ের শিরোনাম)

    @Column(nullable = false)  // This field cannot be null (শূন্য/null হতে পারবে না)
    private String author;  // Author of the book (বইয়ের লেখক)

    @Column(nullable = false)  // This field cannot be null (শূন্য/null হতে পারবে না)
    private String isbn;  // International Standard Book Number (বইয়ের আইএসবিএন নম্বর)

    // ========== CONSTRUCTORS ========== //

    /**
     * Default constructor (required by JPA)
     * ডিফল্ট কনস্ট্রাক্টর (JPA এর জন্য প্রয়োজনীয়)
     */
    public Book() {}

    /**
     * Parameterized constructor for creating new books
     * নতুন বই তৈরি করার জন্য প্যারামিটারযুক্ত কনস্ট্রাক্টর
     * @param title - Book title (বইয়ের শিরোনাম)
     * @param author - Book author (বইয়ের লেখক)
     * @param isbn - Book ISBN (বইয়ের আইএসবিএন)
     */
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // ========== GETTERS AND SETTERS ========== //

    /**
     * Get book ID
     * বইয়ের আইডি পাওয়ার মেথড
     */
    public Long getId() { return id; }

    /**
     * Set book ID
     * বইয়ের আইডি সেট করার মেথড
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Get book title
     * বইয়ের শিরোনাম পাওয়ার মেথড
     */
    public String getTitle() { return title; }

    /**
     * Set book title
     * বইয়ের শিরোনাম সেট করার মেথড
     */
    public void setTitle(String title) { this.title = title; }

    /**
     * Get book author
     * বইয়ের লেখক পাওয়ার মেথড
     */
    public String getAuthor() { return author; }

    /**
     * Set book author
     * বইয়ের লেখক সেট করার মেথড
     */
    public void setAuthor(String author) { this.author = author; }

    /**
     * Get book ISBN
     * বইয়ের আইএসবিএন পাওয়ার মেথড
     */
    public String getIsbn() { return isbn; }

    /**
     * Set book ISBN
     * বইয়ের আইএসবিএন সেট করার মেথড
     */
    public void setIsbn(String isbn) { this.isbn = isbn; }
}