# Lab3

## Разработан REST API для доступа к данным БД
```java   
@RestController
@RequestMapping(value = "/api/books", produces = {"application/json", "application/xml"})
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LibraryUserRepository libraryUserRepository;

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id){
        return bookRepository.findById(id).orElseThrow();
    }

    @GetMapping("/all")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @PostMapping("/edit")
    public void edit(@RequestBody Book book){
        bookRepository.saveAndFlush(book);
    }

    @PostMapping("/add")
    public Book add(@RequestBody Book book){
        bookRepository.saveAndFlush(book);
        return book;
    }

    @DeleteMapping("/remove/{id}")
    public void remove(@PathVariable Long id){
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
    }
}   
```
```java
@RestController
@RequestMapping(value = "/api/users", produces = {"application/json", "application/xml"})
public class LibraryUserController {

    @Autowired
    LibraryUserRepository libraryUserRepository;

    @GetMapping("/{id}")
    public LibraryUser findById(@PathVariable Long id){
        return libraryUserRepository.findById(id).orElseThrow();
    }

    @GetMapping("/all")
    public List<LibraryUser> findAll(){
        return libraryUserRepository.findAll();
    }

    @PostMapping("/edit")
    public void edit(@RequestBody LibraryUser libraryUser){
        libraryUserRepository.saveAndFlush(libraryUser);
    }

    @PostMapping("/add")
    public LibraryUser add(@RequestBody LibraryUser libraryUser){
        libraryUserRepository.saveAndFlush(libraryUser);
        return libraryUser;
    }

    @DeleteMapping("/remove/{id}")
    public void remove(@PathVariable Long id){
        LibraryUser libraryUser = libraryUserRepository.findById(id).orElseThrow();
        libraryUserRepository.delete(libraryUser);
    }

}
```
## Реализована возможность получения как json, так и xml
![image](https://user-images.githubusercontent.com/91950488/211855736-265fd8fd-8cb0-49c1-af79-c33ab3aaa5f5.png)  
![image](https://user-images.githubusercontent.com/91950488/211856168-e316c9f3-3c16-4e90-b78f-1dbb9dc9fbc0.png)

## Добавлены XSL шаблоны и реализован их парсинг
![image](https://user-images.githubusercontent.com/91950488/211856692-6ecffcd3-f7ba-47c6-b752-ac40f0f8391a.png)
![image](https://user-images.githubusercontent.com/91950488/211856748-29737a75-2a83-44d8-a042-3a7dc4100219.png)

