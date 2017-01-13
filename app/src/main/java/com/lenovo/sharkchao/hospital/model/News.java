package com.lenovo.sharkchao.hospital.model;

import com.lenovo.sharkchao.hospital.greendao.CommentDao;
import com.lenovo.sharkchao.hospital.greendao.DaoSession;
import com.lenovo.sharkchao.hospital.greendao.NewsDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * Created by SharkChao on 2017/1/12.
 */
@Entity
public class News {
    @Id
    private Long id;
    @Property
    private String title;
    @ToMany(joinProperties = {@JoinProperty(name = "id", referencedName = "newsId")})
    @OrderBy("commentDate ASC")
    private List<Comment> comment;
    @Property
    private String publishDate;
    private String commentCount;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 255022283)
    private transient NewsDao myDao;
    @Generated(hash = 1691186074)
    public News(Long id, String title, String publishDate, String commentCount) {
        this.id = id;
        this.title = title;
        this.publishDate = publishDate;
        this.commentCount = commentCount;
    }
    @Generated(hash = 1579685679)
    public News() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPublishDate() {
        return this.publishDate;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    public String getCommentCount() {
        return this.commentCount;
    }
    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1853436278)
    public List<Comment> getComment() {
        if (comment == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CommentDao targetDao = daoSession.getCommentDao();
            List<Comment> commentNew = targetDao._queryNews_Comment(id);
            synchronized (this) {
                if (comment == null) {
                    comment = commentNew;
                }
            }
        }
        return comment;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1857872447)
    public synchronized void resetComment() {
        comment = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 543991306)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getNewsDao() : null;
    }
   
}
