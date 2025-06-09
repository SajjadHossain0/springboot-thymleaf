package com.example.demo.Service;

import com.example.demo.dto.BookDto;
import com.example.demo.model.Book;
import java.util.List;

/**
 * BookService ইন্টারফেসটি বই সংক্রান্ত বিভিন্ন সার্ভিস মেথড ডিফাইন করে।
 * এখানে CRUD অপারেশনগুলো (Create, Retrieve, Update, Delete) জন্য মেথড ডিক্লেয়ার করা হয়েছে।
 *
 * ডাটা ট্রান্সফার অবজেক্ট (DTO) ব্যবহৃত হয়েছে, যা Service ও Controller এর মধ্যে ডাটা আদান প্রদান সহজ করে।
 */
public interface BookService {

     /**
      * ডাটাবেস থেকে সব বইয়ের তথ্য নিয়ে আসে এবং BookDto এর লিস্ট হিসেবে রিটার্ন করে।
      * @return List<BookDto> - সব বইয়ের ডাটা
      */
     List<BookDto> getAllBooks();

     /**
      * নির্দিষ্ট আইডি অনুযায়ী একটি বইয়ের তথ্য নিয়ে আসে।
      * @param id বইয়ের ইউনিক আইডি
      * @return BookDto - ঐ বইয়ের তথ্য, যদি থাকে; না হলে null
      */
     BookDto getBookById(Long id);

     /**
      * নতুন বই যোগ করা বা বিদ্যমান বইয়ের তথ্য আপডেট করার জন্য।
      * @param bookDto বইয়ের ডাটা যা সংরক্ষণ বা আপডেট করতে হবে
      */
     void saveBook(BookDto bookDto);

     /**
      * নির্দিষ্ট আইডি অনুযায়ী বই মুছে ফেলার জন্য।
      * @param id মুছে ফেলতে চাই এমন বইয়ের আইডি
      */
     void deleteBook(Long id);
}
