package book.dao.impl;
/*
 * @author  AmbitionJingH
 * @date  2023/7/28 16:58
 * @version 1.0
 */

import book.dao.BookDAO;
import book.pojo.Book;
import com.atguigu.myssm.basedao.BaseDAO;

import java.util.List;

public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
    @Override
    public List<Book> getBookList() {
        return executeQuery("select * from t_book where bookStatus = 0");
    }

    @Override
    public Book getBook(Integer id) {
        return load("select * from t_book where id=?",id);
    }
}
