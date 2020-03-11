package yangguohao.test;

import org.junit.Test;
import yangguohao.pojo.Page;
import yangguohao.service.BookService;
import yangguohao.service.impl.BookServiceImpl;

import static org.junit.Assert.*;

/**
 * @author Mr.Yang
 * @date 2020/03/05
 **/
public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();
    @Test
    public void page() {
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }
}