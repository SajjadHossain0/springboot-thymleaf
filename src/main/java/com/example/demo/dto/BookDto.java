package com.example.demo.dto;

/**
 * BookDto হলো Data Transfer Object (DTO) ক্লাস,
 * যা Book entity এর ডেটা ক্লায়েন্ট বা API এর সাথে আদান প্রদান করার জন্য ব্যবহার হয়।
 *
 * এই ক্লাসে শুধুমাত্র প্রয়োজনীয় ফিল্ড গুলো রাখা হয়,
 * যেমন বইয়ের তথ্য ও তার category এর আইডি ও নাম,
 * যাতে ফ্রন্টএন্ডে বা অন্য জায়গায় সহজে ডেটা দেখানো যায়।
 */
public class BookDto {

    private Long id;             // বইয়ের ইউনিক আইডি
    private String title;        // বইয়ের শিরোনাম
    private String author;       // লেখকের নাম
    private String isbn;         // বইয়ের ISBN নম্বর
    private Long categoryId;     // বইয়ের category এর আইডি (Book entity এর সাথে যুক্ত)
    private String categoryName; // category এর নাম (ডিসপ্লের জন্য)

    // সব ফিল্ডসহ কনস্ট্রাক্টর
    public BookDto(Long id, String title, String author, String isbn, Long categoryId, String categoryName) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    // ডিফল্ট কনস্ট্রাক্টর - প্রয়োজন হয় জাভা বা ফ্রেমওয়ার্কের জন্য
    public BookDto() {
    }

    // নিচে getter এবং setter মেথডগুলো, যেগুলো দিয়ে বাইরের ক্লাস থেকে প্রাইভেট ফিল্ডগুলো অ্যাক্সেস এবং পরিবর্তন করা যায়

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
