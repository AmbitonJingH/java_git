package book.controller;
/*
 * @author  AmbitionJingH
 * @date  2023/7/28 17:10
 * @version 1.0
 */

import book.pojo.Book;
import book.service.BookService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class BookController {
    private BookService bookService;
    public String index(HttpSession session){
        List<Book> bookList = bookService.getBookList();
        session.setAttribute("bookList",bookList);
        return "index";
    }
}
