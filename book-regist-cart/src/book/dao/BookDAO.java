package book.dao;
/*
 * @author  AmbitionJingH
 * @date  2023/7/28 16:57
 * @version 1.0
 */

import book.pojo.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getBookList();
    Book getBook(Integer id);
}
