package yangguohao.service;

import yangguohao.pojo.Book;
import yangguohao.pojo.Page;

import java.util.List;

/**
 * @author Mr.Yang
 * @date 2020/03/05
 **/
public interface BookService {
    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book querBookByid(Integer id);

    public List<Book> queryBooks();

    public Page<Book> page(int pageNo, int pageSize);

    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
