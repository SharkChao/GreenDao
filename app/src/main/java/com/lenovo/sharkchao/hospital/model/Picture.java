package com.lenovo.sharkchao.hospital.model;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;
import com.lenovo.sharkchao.hospital.greendao.DaoSession;
import com.lenovo.sharkchao.hospital.greendao.UserDao;
import org.greenrobot.greendao.annotation.NotNull;
import com.lenovo.sharkchao.hospital.greendao.PictureDao;

import java.io.Serializable;

/**
 * Created by SharkChao on 2017/1/11.
 */
@Entity
public class Picture implements Serializable {
    private static final long serialVersionUID = 11;
    @Id
    private Long pictureId;
    private long userId;
    @Property
    private String pictureName;
    @Property(nameInDb = "width")
    private String width;
    @Property(nameInDb = "height")
    private String height;
    @ToOne(joinProperty = "userId")
   private User user;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 220989104)
    private transient PictureDao myDao;
    @Generated(hash = 1330554887)
    public Picture(Long pictureId, long userId, String pictureName, String width,
            String height) {
        this.pictureId = pictureId;
        this.userId = userId;
        this.pictureName = pictureName;
        this.width = width;
        this.height = height;
    }
    @Generated(hash = 1602548376)
    public Picture() {
    }
    public Long getPictureId() {
        return this.pictureId;
    }
    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }
    public long getUserId() {
        return this.userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getPictureName() {
        return this.pictureName;
    }
    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }
    public String getWidth() {
        return this.width;
    }
    public void setWidth(String width) {
        this.width = width;
    }
    public String getHeight() {
        return this.height;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    @Generated(hash = 251390918)
    private transient Long user__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 115391908)
    public User getUser() {
        long __key = this.userId;
        if (user__resolvedKey == null || !user__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User userNew = targetDao.load(__key);
            synchronized (this) {
                user = userNew;
                user__resolvedKey = __key;
            }
        }
        return user;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1622843587)
    public void setUser(@NotNull User user) {
        if (user == null) {
            throw new DaoException(
                    "To-one property 'userId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.user = user;
            userId = user.getUserId();
            user__resolvedKey = userId;
        }
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
    @Generated(hash = 1412175658)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPictureDao() : null;
    }


}
