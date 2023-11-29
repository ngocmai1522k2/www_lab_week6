package vn.edu.iuh.fit.www_lab_week6;

import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.context.ConfigurableApplicationContext;
		import vn.edu.iuh.fit.dao.PostDao;
		import vn.edu.iuh.fit.dao.UserDao;
		import vn.edu.iuh.fit.entity.Post;
		import vn.edu.iuh.fit.entity.User;

@SpringBootApplication
public class WwwLabWeek6Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(WwwLabWeek6Application.class, args);
		UserDao userDao=context.getBean(UserDao.class);
		PostDao postDao=context.getBean(PostDao.class);
//        System.out.println(userDao.addUser(new User("Phuong", "Bich", "Nguyen", "092929293", "phuong@mail", "123")));
//        System.out.println(userDao.logIn("0388495421", "123"));
//        System.out.println(postDao.addPost(new Post(31, new User(30), "Post 31", "Meta 31", "Summary 31", 1, "content 31")));
//        System.out.println(postDao.updatePost(new Post(31, new User(30), "Post update 31", "Meta 31", "Summary update lan 2 31", 1, "content nnnn 31")));
//        System.out.println(postDao.deletePost(31));
//        System.out.println(postDao.activePost(31));
//        postDao.getAllPostByUser(30).forEach(p->System.out.println(p.toString()));
		System.out.println(postDao.getPost(31));


	}

}
