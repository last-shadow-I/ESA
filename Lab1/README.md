# Lab1

## Описание таблиц
### В рамках данной ЛР были созданы 2 таблицы со связью "один ко многим". Первая таблица - пользователи библиотеки, вторая - книги. Одному пользователю может принадлежать несколько книг.
<img src="https://user-images.githubusercontent.com/91950488/210408068-80d10ef3-a85a-403b-944a-4226cf0aebfb.png" width="256">   

## Настройка БД  
### Была выбрана БД PostgreSQL, настройка подключения производилась через glassfish

<img src="https://user-images.githubusercontent.com/91950488/210408162-73e7ff1f-5c19-4c44-9d9a-ac7dfe76dbb7.png" width="600">     
<img src="https://user-images.githubusercontent.com/91950488/210408195-eaa1e8b3-3a1b-427c-b051-e5ec3b83c7b9.png" width="600">    
<img src="https://user-images.githubusercontent.com/91950488/210408111-3c4bc8a6-7b1d-426e-8ebc-f3c2a09d948c.png" width="600">    

## Особенности реализации
1. Для получения информации о том, какие книги есть у пользователя, и какому пользователю принадлежит конкретная книга, используются аннотации @OneToMany и @ManyToOne;
2. Связь происходит по внешнему ключу в Book;
3. Если этот внешний ключ - null, то считается, что книга не находится ни у одного из пользователей и лежит в библиотеке;
4. Добавление и удаление связи между книгой и пользователем происходит через методы пользователя  ```addBook(Book book)``` и ```removeBook(Book book)```. Эти методы совершают 3 действия: добавялют / удаляют книгу в списке пользователя, а также устанавливают для этой книги владельца и его userID (в случае удаления выставляется null);
5. У каждого пользователя отображаются книги, которые есть у него на руках в виде сдвинутого вправо столбца (без нумерации);
6. На главной странице видна не вся информация о пользователе - это сделано специально, чтобы не загромождать интерфейс;
7. Для каждой книги видно, у кого она на руках.

## Обзор интерфейса и работоспособности ЛР  

### Вид главной страницы:  
<img src="https://user-images.githubusercontent.com/91950488/210408240-f57471d4-25cf-435d-a622-e5fb6f7442a1.png" width="600">    

### Добавление книги:    
<img src="https://user-images.githubusercontent.com/91950488/210408327-8739c7da-8d76-40da-a3ef-cebafd9dde98.png" width="450">     

### Добавился 4 пункт:   
<img src="https://user-images.githubusercontent.com/91950488/210408355-ae11e05a-6dc6-4605-b483-430b4a9776ac.png" width="600">    

### Редактирование книги    
<img src="https://user-images.githubusercontent.com/91950488/210408541-97234d8e-737b-41bc-9161-ae112b4afe5b.png" width="450">   

### Изменился 4 пункт (порядок пунктов при изменении / добавлении / удалении сохраняется - присутствует сортировка по ID):    
<img src="https://user-images.githubusercontent.com/91950488/210408654-9928204c-c803-413b-9aad-bda73946ae13.png" width="600">     

### Удаление книги    
<img src="https://user-images.githubusercontent.com/91950488/210408742-2bfc502b-b45c-4eef-88d1-127f480a7825.png" width="600">    

### Добавление пользователя   
<img src="https://user-images.githubusercontent.com/91950488/210409064-b7a98308-8e4d-47f5-951e-22c7651a70b4.png" width="600">    

### Появился 3 пользователь:   
<img src="https://user-images.githubusercontent.com/91950488/210409089-9e392adb-df77-44a2-8288-29716b95298d.png" width="600">    

### Добавление 2х книг третьему пользователю:      
<img src="https://user-images.githubusercontent.com/91950488/210409144-0918ab71-b99c-4d00-b8a4-af24ea2244b2.png" width="450">    
<img src="https://user-images.githubusercontent.com/91950488/210409220-64b8a27e-9f84-4aa1-a2c4-33df8698cacd.png" width="600">    
<img src="https://user-images.githubusercontent.com/91950488/210409329-65463857-18eb-445b-8f4d-948d40ca7ac3.png" width="600">    

### Удаление пользователя    
При удалении пользователя также меняется информация о том, где эта книга находится
<img src="https://user-images.githubusercontent.com/91950488/210409431-f21d0b58-6ec7-4b44-8baa-9a42765a5eb1.png" width="600">    
