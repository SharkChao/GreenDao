package com.lenovo.sharkchao.hospital.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by SharkChao on 2017/1/12.
 */
@Entity
public class Comment {
    @Id
    private Long id;
    @Property
    private String content;
    @Property
    private String commentDate;
    private Long newsId;
    @Generated(hash = 274044957)
    public Comment(Long id, String content, String commentDate, Long newsId) {
        this.id = id;
        this.content = content;
        this.commentDate = commentDate;
        this.newsId = newsId;
    }
    @Generated(hash = 1669165771)
    public Comment() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getCommentDate() {
        return this.commentDate;
    }
    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }
    public Long getNewsId() {
        return this.newsId;
    }
    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }
}
