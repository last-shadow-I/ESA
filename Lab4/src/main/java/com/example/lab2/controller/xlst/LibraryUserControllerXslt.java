package com.example.lab2.controller.xlst;

import com.example.lab2.model.LibraryUser;
import com.example.lab2.repository.LibraryUserRepository;
import com.example.lab2.service.LibraryUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
@RequestMapping("/xslt/users")
public class LibraryUserControllerXslt {

    private LibraryUserService libraryUserService;

    public LibraryUserControllerXslt(LibraryUserService libraryUserService) {
        this.libraryUserService = libraryUserService;
    }

    @GetMapping
    public ModelAndView get() throws JsonProcessingException {
        List<LibraryUser> animals = libraryUserService.findAll();

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(animals);

        Source source = new StreamSource(new ByteArrayInputStream(xml.getBytes()));
        ModelAndView modelAndView = new ModelAndView("libraryUsers");
        modelAndView.addObject("xmlSource", source);

        return modelAndView;
    }

}
