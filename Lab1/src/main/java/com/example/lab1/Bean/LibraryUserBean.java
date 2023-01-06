package com.example.lab1.Bean;

import com.example.lab1.Entity.LibraryUser;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class LibraryUserBean {

    @PersistenceContext()
    private EntityManager userEntityManager;

    //Добавляем информацию о пользователе
    public LibraryUser add(LibraryUser libraryUser){
        return userEntityManager.merge(libraryUser);
    }

    //Получаем информацию о пользователе по Id
    public LibraryUser get(Long libraryUserId){
        return userEntityManager.find(LibraryUser.class, libraryUserId);
    }

    //Обновляем информацию о пользователе
    public void update (LibraryUser libraryUser){
        add(libraryUser);
    }

    //Удаляем информацию о владельце
    public void delete (Long libraryUserId){
        userEntityManager.remove(get(libraryUserId));
    }

    public List<LibraryUser> getAll(){
        TypedQuery<LibraryUser> userQuery = userEntityManager.createNamedQuery("LibraryUser.getAll", LibraryUser.class);
        return userQuery.getResultList();
    }

//    public String getUserFullName(Long libraryUserId){
//        if (libraryUserId == null)
//            return "Книга в библиотеке";
//        LibraryUser user = get(libraryUserId);
//        return user.getFullName();
//    }
}
