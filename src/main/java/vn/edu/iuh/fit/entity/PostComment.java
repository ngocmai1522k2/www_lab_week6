package vn.edu.iuh.fit.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "postcomment")
public class PostComment {
    @Id
    @Column(name = "CmtID")
    private long cmtID;
    @ManyToOne
    @JoinColumn(name = "PostID")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "UID")
    private User user;
    @ManyToOne
    @JoinColumn(name = "ParentID")
    private PostComment parent;
    @Column(name = "Title", columnDefinition = "varchar(100)")
    private String title;
    @Column(name = "Published", columnDefinition = "tinyint(1)")
    private int published;
    @Column(name="CreatedAt")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;
    @Column(name="PublishedAt")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime publishedAt;
    @Column(name = "Content")
    private String content;

    public PostComment() {
    }

    public PostComment(long cmtID, Post post, User user, PostComment parent, String title, int published, LocalDateTime createdAt, LocalDateTime publishedAt, String content) {
        this.cmtID = cmtID;
        this.post = post;
        this.user = user;
        this.parent = parent;
        this.title = title;
        this.published = published;
        this.createdAt = createdAt;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    public long getCmtID() {
        return cmtID;
    }

    public void setCmtID(long cmtID) {
        this.cmtID = cmtID;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PostComment getParent() {
        return parent;
    }

    public void setParent(PostComment parent) {
        this.parent = parent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PostComment{" +
                "cmtID=" + cmtID +
                ", post=" + post +
                ", user=" + user +
                ", parent=" + parent +
                ", title='" + title + '\'' +
                ", published=" + published +
                ", createdAt=" + createdAt +
                ", publishedAt=" + publishedAt +
                ", content='" + content + '\'' +
                '}';
    }
}
