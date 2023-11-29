package vn.edu.iuh.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.convert.PostForm;
import vn.edu.iuh.fit.dao.PostCommentDao;
import vn.edu.iuh.fit.dao.PostDao;
import vn.edu.iuh.fit.entity.Post;
import vn.edu.iuh.fit.entity.PostComment;
import vn.edu.iuh.fit.entity.User;

import java.util.List;

@Controller
public class PostControll {
    private final PostDao postDao;
    private final PostCommentDao postCommentDao;
    @Autowired
    public PostControll(PostDao postDao, PostCommentDao postCommentDao) {
        this.postDao = postDao;
        this.postCommentDao=postCommentDao;
    }
    @GetMapping("/mypost/{UID}")
    public String showPostOfUser(@PathVariable Long UID, Model model) {
        List<Post> posts = postDao.getAllPostByUser(UID);
        // Đặt danh sách post vào model để hiển thị trong giao diện người dùng
        model.addAttribute("posts", posts);
        model.addAttribute("UID", UID);
        return "mypost";
    }
    @GetMapping("/post/{postID}")
    public String showPostDetail(@PathVariable Long postID, Model model) {
        Post post=postDao.getPost(postID);
        List<PostComment> comments=postCommentDao.getPostCommentByPostID(postID);
        model.addAttribute("post", post);
        model.addAttribute("postID", postID);
        model.addAttribute("comments", comments);
        return "post-detail";
    }
    @GetMapping("/delete-post/{UID}/{postID}")
    public String deletePost(@PathVariable Long postID, @PathVariable Long UID) {
        postDao.deletePost(postID);
        return "redirect:/mypost/"+UID;
    }
    @GetMapping("/active-post/{UID}/{postID}")
    public String publishPost(@PathVariable Long postID, @PathVariable Long UID) {
        postDao.activePost(postID);
        return "redirect:/mypost/"+UID;
    }
    @GetMapping("/update-post/{UID}/{postID}")
    public String showUpdatePostForm(@PathVariable Long postID,@PathVariable Long UID ,Model model) {
        Post post=postDao.getPost(postID);
        model.addAttribute("post", post);
        model.addAttribute("UID", UID);
        return "update-post";
    }
    @PostMapping("/update-post")
    public String updatePost(@ModelAttribute PostForm postForm) {
        long uid=Long.parseLong(postForm.getUid());
        long postID=Long.parseLong(postForm.getPostID());
        int published=Integer.parseInt(postForm.getPublished());
        postDao.updatePost(new Post(postID, new User(uid), postForm.getTitle(), postForm.getMetaTitle(), postForm.getSummary(), published, postForm.getContent()));
        return "redirect:/mypost/"+uid;
    }
    @GetMapping("/create-post/{UID}")
    public String showAddPostForm(@PathVariable Long UID, Model model) {
        model.addAttribute("UID", UID);
        return "create-post";
    }
    @PostMapping("/create-post")
    public String addPost(@ModelAttribute PostForm postForm) {
        long uid=Long.parseLong(postForm.getUid());
        long postID=Long.parseLong(postForm.getPostID());
        int published=Integer.parseInt(postForm.getPublished());

        if(postForm.getParentID()!=null) {
            long parentID = Long.parseLong(postForm.getParentID());
            postDao.addPost(new Post(postID, new Post(parentID), new User(uid), postForm.getTitle(), postForm.getMetaTitle(), postForm.getSummary(), published, postForm.getContent()));
        }else {
            postDao.addPost(new Post(postID, new User(uid), postForm.getTitle(), postForm.getMetaTitle(), postForm.getSummary(), published, postForm.getContent()));
        }
        return "redirect:/mypost/"+uid;
    }

    @GetMapping("/reply-post/{UID}/{postID}")
    public String showReplyPostForm(@PathVariable Long UID, @PathVariable Long postID, Model model) {
        model.addAttribute("UID", UID);
        model.addAttribute("parentID",postID);
        return "create-post";
    }
    @GetMapping("/allpost/{UID}")
    public String showAllPost(@PathVariable Long UID,
                               @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "2") int size,
                               Model model) {
        Page<Post> posts = postDao.getAll(page, size);
        model.addAttribute("posts", posts.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        model.addAttribute("totalPages", posts.getTotalPages());
        model.addAttribute("UID", UID);

        return "allpost";
    }

}
