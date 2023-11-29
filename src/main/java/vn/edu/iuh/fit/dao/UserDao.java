package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    private final EntityManager manager;

    @Autowired
    public UserDao(EntityManager entityManager) {
        this.manager = entityManager;
    }
    //dang ky tai khoan
    @Transactional
    public boolean addUser(User user){
        List<String> mobiles=new ArrayList<>();
        try {
            String sql="SELECT mobile FROM user";
            mobiles=manager.createNativeQuery(sql, String.class).getResultList();
            if(mobiles.contains(user.getMobile())) return false;
            user.setUid(mobiles.size()+1);
            user.setRegisteredAt(LocalDateTime.now());
            user.setLastLogin(LocalDateTime.now());
            user.setProfile("This is my blog");
            user.setIntro("Hello anyone! Im newbie");
            manager.persist(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Transactional
    public boolean logIn(String mobile, String pass) {
        List<String> mobiles=new ArrayList<>();
        String sql="SELECT mobile FROM user";
        mobiles=manager.createNativeQuery(sql, String.class).getResultList();
        if(!mobiles.contains(mobile)) return false;
        try {
            String sql2="SELECT * FROM user\n" +
                    "WHERE Mobile=?";
            Query query = manager.createNativeQuery(sql2, User.class);
            query.setParameter(1, mobile);
            User user= (User) query.getSingleResult();
            if (user != null && user.getPassword().equalsIgnoreCase(pass)) {
                user.setLastLogin(LocalDateTime.now());
                manager.merge(user);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @Transactional
    public User getUserByMobile(String mobile){
        User user=new User();
        try {
            String sql="SELECT * FROM user\n" +
                    "WHERE Mobile=?";
            Query query = manager.createNativeQuery(sql, User.class);
            query.setParameter(1, mobile);
            user= (User) query.getSingleResult();
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
