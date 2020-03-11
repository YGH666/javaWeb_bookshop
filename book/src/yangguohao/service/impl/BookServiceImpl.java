package yangguohao.service.impl;

import yangguohao.dao.BookDao;
import yangguohao.dao.impl.BookDaoImpl;
import yangguohao.pojo.Book;
import yangguohao.pojo.Page;
import yangguohao.service.BookService;

import java.util.List;

/**
 * @author Mr.Yang
 * @date 2020/03/05
 **/
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book querBookByid(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();

        page.setPageNo(pageNo);

        page.setPageSize(pageSize);

        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = (pageTotalCount % pageSize > 0)?(pageTotalCount/pageSize+1):(pageTotalCount/pageSize);
        page.setPageTotal(pageTotal);

        int begin = (page.getPageNo()-1)*pageSize;
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();

        page.setPageNo(pageNo);

        page.setPageSize(pageSize);

        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = (pageTotalCount % pageSize > 0)?(pageTotalCount/pageSize+1):(pageTotalCount/pageSize);
        page.setPageTotal(pageTotal);

        int begin = (page.getPageNo()-1)*pageSize;
        List<Book> items = bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        page.setItems(items);
        return page;
    }
}
