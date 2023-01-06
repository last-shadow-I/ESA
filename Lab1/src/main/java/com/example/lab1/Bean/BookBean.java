package com.example.lab1.Bean;

import com.example.lab1.Entity.Book;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class BookBean {

    @PersistenceContext()
    private EntityManager bookEntityManager;

    //Добавляем информацию о книге
    public Book add(Book book){
        return bookEntityManager.merge(book);
    }

    //Получаем информацию о книге по Id
    public Book get(Long bookId){
        return bookEntityManager.find(Book.class, bookId);
    }

    //Обновляем информацию о книге
    public void update (Book book){
        add(book);
    }

    //Удаляем информацию о владельце
    public void delete (Long bookId){
        bookEntityManager.remove(get(bookId));
    }

    public List<Book> getAll(){
        TypedQuery<Book> bookQuery = bookEntityManager.createNamedQuery("book.getAll", Book.class);
        return bookQuery.getResultList();
    }
}
