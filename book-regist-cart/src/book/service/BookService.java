package book.service;
/*
 * @author  AmbitionJingH
 * @date  2023/7/28 17:07
 * @version 1.0
 */

import book.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> getBookList();
    Book getBook(Integer id);
}
