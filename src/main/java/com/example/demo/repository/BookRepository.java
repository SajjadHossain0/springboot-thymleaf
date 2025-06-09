package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Book Repository ইন্টারফেসটি ডাটাবেসে বই সংক্রান্ত অপারেশন করার জন্য ব্যবহৃত হয়।
 *
 * এটি JpaRepository ইন্টারফেস থেকে এক্সটেন্ড করে, যার মাধ্যমে Book entity এর জন্য CRUD (Create, Read, Update, Delete) অপারেশন স্বয়ংক্রিয়ভাবে পাওয়া যায়।
 *
 * JpaRepository হল Spring Data JPA এর একটি ইন্টারফেস,
 * যা বিভিন্ন সাধারণ ডাটাবেস অপারেশন (যেমন save, findById, findAll, deleteById) দিয়ে থাকে।
 * তাই আমাদের আলাদা করে এই মেথডগুলো লিখার দরকার হয় না।
 *
 * param <Book> এখানে Book হল সেই Entity class যার ডাটাগুলো ম্যানেজ করতে চাইছি।
 * param <Long> এখানে Long হল Book entity এর প্রাইমারি কী এর ডাটা টাইপ।
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    /*
     * নিচের মেথডগুলো JpaRepository থেকে পাওয়া যায়:
     *
     * save(Book book)          - নতুন বই সেভ করা বা পুরানো বই আপডেট করা
     * findById(Long id)        - আইডি অনুযায়ী বই খুঁজে পাওয়া
     * findAll()                - সব বইয়ের তালিকা পাওয়া
     * deleteById(Long id)      - আইডি অনুযায়ী বই ডিলিট করা
     * count()                  - মোট বইয়ের সংখ্যা জানা
     *
     * আমাদের এগুলো ইমপ্লিমেন্ট করার দরকার নেই, Spring Data JPA অটোমেটিক এটি করে দেয়।
     */
}
