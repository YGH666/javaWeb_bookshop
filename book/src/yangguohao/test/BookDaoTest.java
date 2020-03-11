package yangguohao.test;

import org.junit.Test;
import yangguohao.dao.BookDao;
import yangguohao.dao.impl.BaseDao;
import yangguohao.dao.impl.BookDaoImpl;
import yangguohao.pojo.Book;
import yangguohao.pojo.Page;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Mr.Yang
 * @date 2020/03/05
 **/
public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"杨小帅666","杨国豪",new BigDecimal(666),120,20,null));

    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(12);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(12,"杨小帅777","杨国豪",new BigDecimal(666),120,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(1));
    }

    @Test
    public void queryBooks() {
        for (Book book : bookDao.queryBooks()) {
            System.out.println("book = " + book);
        }
    }

    @Test
    public void test1() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void test2() {
        List<Book> books = bookDao.queryForPageItems(8, Page.PAGE_SIZE);
        for (Book book : books) {
            System.out.println("book = " + book);
        }
    }

}