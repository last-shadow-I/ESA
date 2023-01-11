package com.example.lab2.controller.xlst;

import com.example.lab2.model.Book;
import com.example.lab2.repository.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
@RequestMapping("/xslt/books")
public class BookControllerXslt {

    private BookRepository bookRepository ;

    public BookControllerXslt(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public ModelAndView get() throws JsonProcessingException {
        List<Book> animals = bookRepository.findAll();

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(animals);

        Source source = new StreamSource(new ByteArrayInputStream(xml.getBytes()));
        ModelAndView modelAndView = new ModelAndView("books");
        modelAndView.addObject("xmlSource", source);

        return modelAndView;
    }
}
