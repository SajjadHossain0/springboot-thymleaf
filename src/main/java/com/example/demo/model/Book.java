package com.example.demo.model;

import jakarta.persistence.*;

/**
 * Book entity class representing a book in the database
 * বই এনটিটি ক্লাস যা ডাটাবেসে একটি বইকে রিপ্রেজেন্ট করে
 */
@Entity // এই অ্যানোটেশনটি বলে দেয় যে এটি একটি JPA Entity (অর্থাৎ এটি একটি ডাটাবেস টেবিলের সাথে সম্পর্কিত)
@Table(name = "books") // এই Entity টি ডাটাবেসে 'books' নামের টেবিলের সাথে ম্যাপ হবে
public class Book {

    @Id // প্রাইমারি কী হিসেবে ব্যবহৃত হবে
    @GeneratedValue(strategy = GenerationType.IDENTITY) // অটো ইনক্রিমেন্ট হবে (MySQL এর মতো)
    private Long id; // প্রতিটি বইয়ের জন্য ইউনিক আইডি

    @Column(nullable = false) // ডাটাবেসে এই কলামটি null হবে না
    private String title; // বইয়ের শিরোনাম

    @Column(nullable = false)
    private String author; // বইয়ের লেখক

    @Column(nullable = false)
    private String isbn; // বইয়ের ISBN নাম্বার

    // একটি বই একটি ক্যাটেগরির অধীনে থাকবে (ManyToOne)
    @ManyToOne
    @JoinColumn(name = "category_id") // books টেবিলে category_id নামে একটি ফরেন কি কলাম থাকবে
    private Category category;

    // সব ফিল্ডসহ কনস্ট্রাক্টর (ডাটা সেট করার জন্য কাজে লাগে)
    public Book(Long id, String title, String author, String isbn, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
    }

    // ডিফল্ট কনস্ট্রাক্টর (Spring/ORM ফ্রেমওয়ার্কের জন্য প্রয়োজন হয়)
    public Book() {
    }

    // Getter & Setter methods (প্রতিটি প্রোপার্টির মান নিতে ও সেট করতে ব্যবহৃত হয়)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
