package com.example.demo.dto;

/**
 * CategoryDto হলো Data Transfer Object (DTO) ক্লাস,
 * যা Category entity এর ডেটা ট্রান্সফার করার জন্য ব্যবহৃত হয়।
 *
 * এটি মূল Category entity থেকে আলাদা একটি ক্লাস,
 * যা API বা ফ্রন্টএন্ড এর সাথে ডেটা আদান প্রদান সহজ করে তোলে।
 */
public class CategoryDto {

    private Long id;     // ক্যাটাগরির ইউনিক আইডি
    private String name; // ক্যাটাগরির নাম

    /**
     * ডিফল্ট কনস্ট্রাক্টর - প্রয়োজন হয় ফ্রেমওয়ার্কের জন্য (যেমন Spring)
     */
    public CategoryDto() {
    }

    /**
     * সব ফিল্ড ইনিশিয়ালাইজ করার জন্য কনস্ট্রাক্টর
     *
     * @param id   ক্যাটাগরির আইডি
     * @param name ক্যাটাগরির নাম
     */
    public CategoryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // নিচে getter এবং setter মেথডগুলো, যেগুলো দিয়ে বাইরের ক্লাস থেকে প্রাইভেট ফিল্ডগুলো অ্যাক্সেস এবং পরিবর্তন করা যায়

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
}
