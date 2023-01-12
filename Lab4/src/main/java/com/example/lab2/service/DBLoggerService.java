package com.example.lab2.service;

import com.example.lab2.config.JmsConfig;
import com.example.lab2.model.*;
import com.example.lab2.repository.AuditRepository;
import com.example.lab2.repository.BookAuditRepository;
import com.example.lab2.repository.LibraryUserAuditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DBLoggerService {

    private final AuditRepository auditRepository;
    private final BookAuditRepository bookAuditRepository;
    private final LibraryUserAuditRepository libraryUserAuditRepository;
    private final JMSParserService jmsParserService;

    @JmsListener(destination = JmsConfig.CHANGE_TOPIC)
    public void listen(@Payload Map<String, String> payload, @Headers MessageHeaders messageHeaders,
                       Message message) throws JMSException, ParseException {

        MessagePOJO parsedMessage = jmsParserService.parse(payload, messageHeaders, message);
        String eventType = parsedMessage.getEventType();

        switch (eventType) {
            case "Create" -> logCreateEvent(parsedMessage.getObject1(), parsedMessage.getTable(), parsedMessage.getDate());
            case "Delete" -> logDeleteEvent(parsedMessage.getObject1(), parsedMessage.getTable(), parsedMessage.getDate());
            case "Update" -> logUpdateEvent(parsedMessage.getObject1(), parsedMessage.getObject2(), parsedMessage.getTable(), parsedMessage.getDate());
        }
    }

    public void logCreateEvent(Map<String, String> object, String table, Date date){
        switch (table) {
            case "book" -> logBookChange(object, null, "Create", date);
            case "libraryUser" -> logLibraryUserChange(object, null, "Create", date);
        }
    }

    public void logDeleteEvent(Map<String, String> object, String table, Date date){
        switch (table) {
            case "book" -> logBookChange(null, object, "Delete", date);
            case "libraryUser" -> logLibraryUserChange(null, object, "Delete", date);
        }
    }

    public void logUpdateEvent(Map<String, String> objectNew, Map<String, String> objectOld, String table, Date date){
        switch (table) {
            case "book" -> logBookChange(objectNew, objectOld, "Update", date);
            case "libraryUser" -> logLibraryUserChange(objectNew, objectOld, "Update", date);
        }
    }

    private void logBookChange(Map<String, String> objectNew, Map<String, String> objectOld, String eventType, Date date){

        Book bookOld = Book.fromMap(objectOld);
        Book bookNew = Book.fromMap(objectNew);

        BookAudit bookAudit = new BookAudit(bookOld.getTitle(), bookNew.getTitle(),
                bookOld.getAuthor(), bookNew.getAuthor(),
                bookOld.getPublisher(), bookNew.getPublisher(),
                bookOld.getYearOfPublication(), bookNew.getYearOfPublication());

        bookAudit = bookAuditRepository.save(bookAudit);

        //add eventType
        DBChange dbChange = new DBChange("book", bookAudit.getId(), eventType, new java.sql.Date(date.getTime()));
        auditRepository.saveAndFlush(dbChange);
    }

    private void logLibraryUserChange(Map<String, String> objectNew, Map<String, String> objectOld, String eventType, Date date){
        LibraryUser libraryUserOld = LibraryUser.fromMap(objectOld);
        LibraryUser libraryUserNew = LibraryUser.fromMap(objectNew);

        LibraryUserAudit libraryUserAudit = new LibraryUserAudit(libraryUserOld.getFullName(), libraryUserNew.getFullName(),
                libraryUserOld.getAge(), libraryUserNew.getAge(),
                libraryUserOld.getAddress(), libraryUserNew.getAddress(),
                libraryUserOld.getPhoneNumber(), libraryUserNew.getPhoneNumber());

        libraryUserAudit = libraryUserAuditRepository.save(libraryUserAudit);

        DBChange dbChange = new DBChange("library_user", libraryUserAudit.getId(), eventType, new java.sql.Date(date.getTime()));
        auditRepository.saveAndFlush(dbChange);
    }
}
