package com.bookss09.controller;

import com.bookss09.entity.Book;
import com.bookss09.entity.BookBorrowCard;
import com.bookss09.handler.BookException;
import com.bookss09.service.IBookBorrowCardService;
import com.bookss09.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IBookBorrowCardService bookBorrowCardService;

    @GetMapping("list")
    public String bookList(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/create";
    }

    @PostMapping("create")
    public String doCreate(Model model, @ModelAttribute("book") Book book) {
        bookService.create(book);
        model.addAttribute("book", book);
        model.addAttribute("message", "Add new book successful");
        return "book/create";
    }

    @GetMapping("edit/{id}")
    public String editForm(Model model, @ModelAttribute("id") Long id) {
        model.addAttribute("book", bookService.findById(id));
        return "book/edit";
    }

    @PostMapping("edit")
    public String doEdit(Model model, @ModelAttribute("book") Book book,
                         @RequestParam("increaseNumberBook") Optional<Integer> incNumberBook,
                         @RequestParam("decreaseNumberBook") Optional<Integer> deNumberBook) {
        int changeNumberBook = incNumberBook.orElse(0) - deNumberBook.orElse(0);
        bookService.update(book, changeNumberBook);
        model.addAttribute("book", book);
        model.addAttribute("message", "Update book successful");
        return "book/edit";
    }

    @GetMapping("detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        model.addAttribute("book", bookService.findById(id));
        return "book/detail";
    }

    @GetMapping("borrow/{id}")
    public String borrowForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("bookBorrowCard", new BookBorrowCard());
        return "book/borrow";
    }

    @PostMapping("borrow")
    public String doBorrow(Model model, @ModelAttribute("bookBorrowCard") BookBorrowCard bookBorrowCard) throws Exception {
//        code
        Book book = bookService.findById(bookBorrowCard.getBookClass().getId());
        if (book.getQuantity() == 0) {
            throw new BookException("No more book");
        }
        int result = 0;
        while (bookBorrowCardService.findBorrowCodeByBorrowCode(result).size() != 0 || result == 0) {
            Random r = new Random();
            int low = 10000;
            int high = 99999;
            result = r.nextInt(high - low) + low;
        }
        bookBorrowCard.setBorrowCode(result);
        bookBorrowCardService.create(bookBorrowCard);
        model.addAttribute("book", book);
        model.addAttribute("message", "You have successfully borrowed the book, your code is " +
                result);
        return "book/borrow";
    }

    @GetMapping("give-back/{id}")
    public String giveBackForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("bookBorrowCard", new BookBorrowCard());
        return "book/give-back";
    }

    @PostMapping("give-back")
    public String doGiveBack(Model model, @ModelAttribute("bookBorrowCard") BookBorrowCard bookBorrowCard,
                             @RequestParam("enterBorrowCode") Optional<Integer> e) throws Exception {
        int enterBorrowCode = e.orElse(null);
        Book book = bookService.findById(bookBorrowCard.getBookClass().getId());
        model.addAttribute("book", book);
        if (bookBorrowCardService.remove(bookBorrowCard, enterBorrowCode))
            model.addAttribute("message", "You have successfully give book back");
        else
            throw new BookException("You haven't successfully give book back. Please enter the correct code and correct title book");
        return "book/give-back";
    }

}
