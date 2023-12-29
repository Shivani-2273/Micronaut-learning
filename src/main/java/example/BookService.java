package example;

import jakarta.inject.Inject;

import java.util.Optional;

public class BookService {

    @Inject
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book book) {
        Book existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setPages(book.getPages());
            return bookRepository.update(existingBook);
        }
        return null; // or handle as per your need
    }
}
