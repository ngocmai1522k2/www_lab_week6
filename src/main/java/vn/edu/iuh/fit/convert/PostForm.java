package vn.edu.iuh.fit.convert;

public class PostForm {
    private String uid;
    private String postID;
    private String title;
    private String metaTitle;
    private String summary;
    private String content;
    private String published;
    private String parentID;

    public PostForm() {
    }

    public PostForm(String uid, String postID, String title, String metaTitle, String summary, String content, String published, String parentID) {
        this.uid = uid;
        this.postID = postID;
        this.title = title;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.content = content;
        this.published = published;
        this.parentID = parentID;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    @Override
    public String toString() {
        return "PostForm{" +
                "uid='" + uid + '\'' +
                ", postID='" + postID + '\'' +
                ", title='" + title + '\'' +
                ", metaTitle='" + metaTitle + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", published='" + published + '\'' +
                ", parentID='" + parentID + '\'' +
                '}';
    }
}
