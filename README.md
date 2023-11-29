# www_lab_week6
# Lab6 Spring Boot Project
Họ tên: [Lê Thị Ngọc Mai]

MSSV: [20005501]
## Mô tả

Dự án Spring Boot với

## Yêu cầu

Đảm bảo bạn đã cài đặt đầy đủ các thành phần sau:
- Java Development Kit (JDK)
- Maven
- MariaDB

## Công nghệ sử dụng

- Spring Boot: Framework để xây dựng ứng dụng doanh nghiệp dựa trên Java.
- MariaDB: Hệ thống quản lý cơ sở dữ liệu quan hệ.
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


## Tài liệu liên quan

- [Java EE Documentation](https://javaee.github.io/javaee-spec/)
- [Java Database Connectivity (JDBC) Documentation](https://docs.oracle.com/en/java/javase/16/docs/api/java.sql/java/sql/package-summary.html)
- [Apache Tomcat Documentation](https://tomcat.apache.org/tomcat-9.0-doc/index.html)
- [Git Version Control](https://git-scm.com/book/en/v2)


## Đóng góp

Nếu bạn muốn đóng góp vào dự án hoặc báo cáo lỗi, vui lòng tạo issue hoặc gửi pull request vào repository GitHub của dự án.

- GitHub Repository: [www_lab_week6](https://github.com/ngocmai1522k2/www_lab_week6)
- Tạo issue mới: [Tạo issue](https://github.com/ngocmai1522k2/www_lab_week6/issues/new)
- Gửi pull request: [Gửi pull request](https://github.com/ngocmai1522k2/www_lab_week6/compare)

Chúng tôi rất hoan nghênh mọi đóng góp từ cộng đồng!

---
