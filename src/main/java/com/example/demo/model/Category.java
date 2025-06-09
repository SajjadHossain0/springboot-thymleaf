package com.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Category entity ক্লাস যা ডাটাবেসে categories টেবিলের সাথে যুক্ত
 * প্রতিটি category এর একটি unique id এবং name থাকে
 * আর এই category এর সাথে অনেকগুলো Book থাকতে পারে (OneToMany সম্পর্ক)
 */
@Entity
@Table(name = "categories")
public class Category {

    // primary key হিসেবে কাজ করবে এবং auto increment হবে
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // category এর নাম, null হতে পারবে না
    @Column(nullable = false)
    private String name;

    /**
     * এই List<Book> হলো category এর সাথে সম্পর্কযুক্ত সব বইয়ের তালিকা
     * এক category এর অনেকগুলো Book থাকতে পারে (OneToMany সম্পর্ক)
     *
     * mappedBy = "category" => Book entity তে 'category' ফিল্ড দিয়ে এই সম্পর্ক গড়া হয়েছে
     * cascade = CascadeType.ALL => category এর অপারেশন গুলো (save, update, delete) বই গুলোর ক্ষেত্রেও প্রয়োগ হবে
     * orphanRemoval = true => যদি কোনো Book এই List থেকে বের হয়ে যায়, তাহলে সেটা ডাটাবেস থেকেও মুছে যাবে
     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    // ডিফল্ট কনস্ট্রাক্টর (জাভা রিকোয়ারমেন্ট)
    public Category() {
    }

    // প্যারামিটারাইজড কনস্ট্রাক্টর, প্রয়োজনে সব ফিল্ড দিয়ে বসানো যায়
    public Category(Long id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    // getter ও setter মেথড গুলো নিচে আছে, যেগুলো দিয়ে প্রাইভেট ফিল্ড গুলো অ্যাক্সেস করা যায় ও মান সেট করা যায়

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
