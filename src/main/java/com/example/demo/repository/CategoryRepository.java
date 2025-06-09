package com.example.demo.repository;

import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Category Repository ইন্টারফেসটি ডাটাবেসে ক্যাটাগরি সংক্রান্ত অপারেশন করার জন্য ব্যবহৃত হয়।
 *
 * এটি JpaRepository থেকে এক্সটেন্ড করে, যার মাধ্যমে Category entity এর জন্য CRUD (Create, Read, Update, Delete) অপারেশন অটোমেটিক পাওয়া যায়।
 *
 * JpaRepository Spring Data JPA এর একটি ইন্টারফেস,
 * যা বিভিন্ন সাধারণ ডাটাবেস অপারেশন (যেমন save, findById, findAll, deleteById) দিয়ে থাকে।
 * তাই আমাদের আলাদা করে এগুলো ইমপ্লিমেন্ট করার প্রয়োজন হয় না।
 *
 * param <Category> এখানে Category হল সেই Entity class যার ডাটাগুলো ম্যানেজ করতে চাইছি।
 * param <Long> এখানে Long হল Category entity এর প্রাইমারি কী এর ডাটা টাইপ।
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // এই ইন্টারফেসে আলাদা মেথড লিখতে না চাইলেও চলবে,
    // কারণ JpaRepository থেকে প্রয়োজনীয় সব CRUD মেথড আসবে।
}
