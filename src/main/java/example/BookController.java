package example;

import io.micronaut.http.annotation.*;

import java.util.Optional;

@Controller("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Post
    public Book save(@Body Book book) {
        return bookService.saveBook(book);
    }

    @Get("/{id}")
    public Optional<Book> findById(Long id) {
        return bookService.findBookById(id);
    }

    @Get
    public Iterable<Book> findAll() {
        return bookService.findAllBooks();
    }

    @Put("/{id}")
    public Book update(Long id, @Body Book book) {
        return bookService.updateBook(id, book);
    }

    @Delete("/{id}")
    public void delete(Long id) {
        bookService.deleteBookById(id);
    }
}
