# Lab4

## Описание таблиц
#### В рамках данной ЛР были созданы ещё 3 таблицы. Первая таблица - хранит изменения(какая сущность изменилась, время, id строки в соответствующей таблице с данными изменения, операция), вторая - хранит старые и новые данные для каждой операции для сущности "book", третья - хранит старые и новые данные для каждой операции для сущности "library_user".
![image](https://user-images.githubusercontent.com/91950488/212101418-ba15f1dd-a8db-4270-ac9b-d073aba74b55.png)
  
## Настройка БД  
### Была выбрана БД PostgreSQL, подключение производилось с помощью указания БД в файле properties SpringApplication


## Обзор работоспособности ЛР  

### Добавление книги     
![image](https://user-images.githubusercontent.com/91950488/212102844-39a56241-38db-4852-853f-085cfd4951b7.png)  
Появилась последняя строка:  
![image](https://user-images.githubusercontent.com/91950488/212102984-5e554a1f-fc97-453b-9c41-2c27ca8e1763.png)  
В таблице с действиями:  
![image](https://user-images.githubusercontent.com/91950488/212104532-50538b28-bdb8-42cc-b983-501cae5281e8.png)  
В таблице с изменениями полей book:  
![image](https://user-images.githubusercontent.com/91950488/212103276-8246037e-aa89-4cd7-9a70-235246791a72.png)  

### Редактирование книги    
![image](https://user-images.githubusercontent.com/91950488/212104997-8d04c325-0cba-4335-b31a-b71b3a3160f1.png)
![image](https://user-images.githubusercontent.com/91950488/212105223-bb71f352-424b-4c0d-8605-c33df2e0517f.png)
В таблице с действиями: 
![image](https://user-images.githubusercontent.com/91950488/212105282-822e66dd-880f-4630-b2df-c7f821781ab0.png)
В таблице с изменениями полей book:  
![image](https://user-images.githubusercontent.com/91950488/212105408-1bc8b87c-f5d8-4c47-8f05-d8296450b154.png)

### Удаление книги    
![image](https://user-images.githubusercontent.com/91950488/212105816-b523ded7-3e37-4a6e-bda4-659b62dcb745.png)
![image](https://user-images.githubusercontent.com/91950488/212105992-534cc618-6f3b-4d3e-9a13-1d7c7bd158a5.png)
![image](https://user-images.githubusercontent.com/91950488/212106057-aee954d7-6ad8-480e-a70f-051aba7cd2a6.png)
![image](https://user-images.githubusercontent.com/91950488/212106135-48a9c05e-2ffd-4a83-971e-84e340fefc55.png)

### Для сущности "libraryUser" всё аналогично. 
