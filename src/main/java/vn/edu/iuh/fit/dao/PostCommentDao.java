package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.entity.PostComment;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostCommentDao {
    private final EntityManager manager;
    @Autowired
    public PostCommentDao(EntityManager entityManager) {
        this.manager = entityManager;
    }
    @Transactional
    public List<PostComment> getPostCommentByPostID(long postID){
        List<PostComment> list=new ArrayList<>();
        try {
            String sql="SELECT * FROM postcomment\n" +
                    "WHERE PostID=?";
            Query query = manager.createNativeQuery(sql, PostComment.class);
            query.setParameter(1, postID);
            list=query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


}
