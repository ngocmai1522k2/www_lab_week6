package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.entity.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDao {
    private final EntityManager manager;

    @Autowired
    public PostDao(EntityManager entityManager) {
        this.manager = entityManager;
    }
    @Transactional
    public boolean addPost(Post post){
        try {
            post.setCreatedAt(LocalDateTime.now());
            if(post.getPublished()==1) post.setPublishedAt(LocalDateTime.now());
            manager.persist(post);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Transactional
    public boolean updatePost(Post post){
        try {
            Post dataPost=manager.find(Post.class, post.getPostID());
            if (dataPost==null) return false;

            post.setCreatedAt(dataPost.getCreatedAt());
            post.setUpdatedAt(LocalDateTime.now());
            if(post.getPublished()==1) post.setPublishedAt(LocalDateTime.now());
            else post.setUpdatedAt(null);
            manager.merge(post);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Transactional
    public boolean deletePost(long postID){
        try {
            Post post=manager.find(Post.class, postID);
            post.setPublished(0);
            post.setPublishedAt(null);
            manager.merge(post);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Transactional
    public boolean activePost(long postID){
        try {
            Post post=manager.find(Post.class, postID);
            post.setPublished(1);
            post.setPublishedAt(LocalDateTime.now());
            manager.merge(post);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Transactional
    public List<Post> getAllPostByUser(long uid){
        List<Post> posts=new ArrayList<>();
        try {
            String sql="SELECT * FROM post \n" +
                    "WHERE UID=?";
            Query query=manager.createNativeQuery(sql, Post.class);
            query.setParameter(1, uid);
            posts=query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return posts;
    }
    @Transactional
    public Page<Post> getAll(int page, int size) {
        try {
            List<Post> posts = manager.createQuery("select p from Post p", Post.class)
                    .setFirstResult(page * size)
                    .setMaxResults(size)
                    .getResultList();

            long totalPosts = (long) manager.createQuery("select count(p) from Post p").getSingleResult();

            return new PageImpl<>(posts, PageRequest.of(page, size), totalPosts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Transactional
    public Post getPost(long postID){
        try {
            return manager.find(Post.class, postID);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
