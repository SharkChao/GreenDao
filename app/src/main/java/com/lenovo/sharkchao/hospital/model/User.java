package com.lenovo.sharkchao.hospital.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;
import com.lenovo.sharkchao.hospital.greendao.DaoSession;
import com.lenovo.sharkchao.hospital.greendao.PictureDao;
import org.greenrobot.greendao.annotation.NotNull;
import com.lenovo.sharkchao.hospital.greendao.UserDao;

/**
 * Created by SharkChao on 2017/1/9.
 */

@Entity
public class User {
    @Id
    private Long UserId;
    private long pictureId;
    @Property(nameInDb = "NAME")
    private String name;
    @Property(nameInDb = "AGE")
    private String age;
    @Property(nameInDb = "SEX")
    private String sex;
    @ToOne(joinProperty = "pictureId")
    private Picture picture;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;
    @Generated(hash = 930498976)
    public User(Long UserId, long pictureId, String name, String age, String sex) {
        this.UserId = UserId;
        this.pictureId = pictureId;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getUserId() {
        return this.UserId;
    }
    public void setUserId(Long UserId) {
        this.UserId = UserId;
    }
    public long getPictureId() {
        return this.pictureId;
    }
    public void setPictureId(long pictureId) {
        this.pictureId = pictureId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    @Generated(hash = 1986840853)
    private transient Long picture__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 545923159)
    public Picture getPicture() {
        long __key = this.pictureId;
        if (picture__resolvedKey == null || !picture__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PictureDao targetDao = daoSession.getPictureDao();
            Picture pictureNew = targetDao.load(__key);
            synchronized (this) {
                picture = pictureNew;
                picture__resolvedKey = __key;
            }
        }
        return picture;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 330863195)
    public void setPicture(@NotNull Picture picture) {
        if (picture == null) {
            throw new DaoException(
                    "To-one property 'pictureId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.picture = picture;
            pictureId = picture.getPictureId();
            picture__resolvedKey = pictureId;
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
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }

}