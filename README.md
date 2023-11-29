# www_lab_week6
# Lab6 Spring Boot Project

## Các Package

### 1. Package "entity"
   - Chứa các đối tượng thực thể như User, Post, PostComment.

### 2. Package "dao"
   - Chứa các lớp dao như UserDao, PostDao, PostCommentDao.
   - **UserDao:** Chứa các hàm như addUser, logIn, getUserByMobile.
   - **PostDao:** Chứa các hàm như addPost, updatePost, deletePost, activePost, getAllPostByUser, getAll, getPost.
   - **PostCommentDao:** Chứa hàm getPostCommentByPostID.

### 3. Package "controllers"
   - Chứa các lớp controller như UserController, PostController.

### 4. Package "convert"
   - Chứa các lớp đảm nhiệm chuyển đổi dữ liệu như PostForm, UserForm.


## Cấu hình application.properties:

```properties
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://localhost:3306/week6
spring.datasource.username=root
spring.datasource.password=sapass
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8082
spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```

## Chạy Ứng dụng

- Chạy class `Lab6Application` để khởi động ứng dụng Spring Boot. 
- Sau đó, truy cập http://localhost:8082 để xem kết quả.

## Lưu ý

- Trước khi chạy ứng dụng, đảm bảo rằng đã cấu hình đúng kết nối database trong file `application.properties`.

## Thư viện và Công nghệ sử dụng

- Spring Boot
- MariaDB
- Thymeleaf (được sử dụng trong thư mục "templates")

Tôi hoan nghênh sự đóng góp từ cộng đồng để cải thiện dự án này.

## Chạy ứng dụng

![Ảnh mô tả sản phẩm](https://i.imgur.com/rGLZIgi.png)

![Ảnh mô tả sản phẩm](https://i.imgur.com/wtzOXPc.png)

![Ảnh mô tả sản phẩm](https://i.imgur.com/3ljBjh3.png)

![Ảnh mô tả sản phẩm](https://i.imgur.com/m7vLMM8.png)

![Ảnh mô tả sản phẩm](https://i.imgur.com/NBFWYc0.png)

![Ảnh mô tả sản phẩm](https://i.imgur.com/DyEppoD.png)

![Ảnh mô tả sản phẩm](https://i.imgur.com/fEuXcbY.png)

![Ảnh mô tả sản phẩm](https://i.imgur.com/Yx199cA.png)




---
