package book.service.impl;
/*
 * @author  AmbitionJingH
 * @date  2023/7/28 17:06
 * @version 1.0
 */

import book.dao.BookDAO;
import book.pojo.Book;
import book.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;
    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }

    @Override
    public Book getBook(Integer id) {
        return bookDAO.getBook(id);
    }
}
