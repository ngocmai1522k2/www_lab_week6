package vn.edu.iuh.fit.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "PostID")
    private long postID;
    @ManyToOne
    @JoinColumn(name = "ParentID")
    private Post parent;
    @ManyToOne
    @JoinColumn(name = "UID")
    private User author;
    @Column(name = "Title", columnDefinition = "varchar(100)")
    private String title;
    @Column(name = "MetaTitle", columnDefinition = "varchar(200)")
    private String metaTitle;
    @Column(name = "Summary")
    private String summary;
    @Column(name = "Published", columnDefinition = "tinyint(1)")
    private int published;
    @Column(name="CreatedAt")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;
    @Column(name="PublishedAt")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime publishedAt;
    @Column(name="UpdatedAt")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime updatedAt;
    @Column(name = "Content")
    private String content;

    public Post() {
    }

    public Post(long postID, Post parent, User author, String title, String metaTitle, String summary, int published, LocalDateTime createdAt, LocalDateTime publishedAt, LocalDateTime updatedAt, String content) {
        this.postID = postID;
        this.parent = parent;
        this.author = author;
        this.title = title;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.published = published;
        this.createdAt = createdAt;
        this.publishedAt = publishedAt;
        this.updatedAt = updatedAt;
        this.content = content;
    }

    public Post(long postID, User author, String title, String metaTitle, String summary, int published, String content) {
        this.postID = postID;
        this.author = author;
        this.title = title;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.published = published;
        this.content = content;
    }

    public Post(long postID) {
        this.postID = postID;
    }

    public Post(long postID, Post parent, User author, String title, String metaTitle, String summary, int published, String content) {
        this.postID = postID;
        this.parent = parent;
        this.author = author;
        this.title = title;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.published = published;
        this.content = content;
    }

    public long getPostID() {
        return postID;
    }

    public void setPostID(long postID) {
        this.postID = postID;
    }

    public Post getParent() {
        return parent;
    }

    public void setParent(Post parent) {
        this.parent = parent;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postID=" + postID +
                ", parent=" + parent +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", metaTitle='" + metaTitle + '\'' +
                ", summary='" + summary + '\'' +
                ", published=" + published +
                ", createdAt=" + createdAt +
                ", publishedAt=" + publishedAt +
                ", updatedAt=" + updatedAt +
                ", content='" + content + '\'' +
                '}';
    }
}
