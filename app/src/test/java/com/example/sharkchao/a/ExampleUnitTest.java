package com.example.sharkchao.a;

import com.lenovo.sharkchao.hospital.base.BaseActivity;
import com.lenovo.sharkchao.hospital.greendao.CommentDao;
import com.lenovo.sharkchao.hospital.greendao.CustomerDao;
import com.lenovo.sharkchao.hospital.greendao.NewsDao;
import com.lenovo.sharkchao.hospital.greendao.OrderDao;
import com.lenovo.sharkchao.hospital.model.Comment;
import com.lenovo.sharkchao.hospital.model.Customer;
import com.lenovo.sharkchao.hospital.model.News;
import com.lenovo.sharkchao.hospital.model.Order;
import com.lenovo.sharkchao.hospital.utils.GetDaoMaster;

import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static com.lenovo.sharkchao.hospital.utils.GetDaoMaster.getDaoSession;
import static junit.framework.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
//        joinQueryCustomer();
        save();
    }

    /**
     * 保存新闻与评论数据，关系为1：n    有问题
     */
    public void save() {
        //新建一条新闻
        News news1 = new News();
        news1.setPublishDate(new Date() + "");
        news1.setTitle("这是第一条新闻");
        NewsDao newsDao = GetDaoMaster.getDaoSession(BaseActivity.getCurrentActivity()).getNewsDao();
        newsDao.insert(news1);
        //新建两条评论
        Comment comment1 = new Comment(null, "好评!", new Date() + "", news1.getId());
        Comment comment2 = new Comment(null, "差评!", new Date() + "", news1.getId());
        CommentDao commentDao = GetDaoMaster.getDaoSession(BaseActivity.getCurrentActivity()).getCommentDao();
        commentDao.insert(comment1);
        commentDao.insert(comment2);

        //不需要提交吗????
        news1.getComment().add(comment1);
        news1.getComment().add(comment2);
        news1.setCommentCount(2 + "");
    }

    /**
     * 修改数据  5有问题
     */
    public void update() {


        //1.修改某个id的一条记录
        NewsDao newsDao = GetDaoMaster.getDaoSession(BaseActivity.getCurrentActivity()).getNewsDao();
        News news = newsDao.queryBuilder().where(NewsDao.Properties.Id.eq("1")).build().unique();
        news.setTitle("修改之后的标题");
        newsDao.update(news);

        //2.修改符合某个约束条件的记录（修改title为"这是第一条新闻"，commentcount>0的记录title字段为"今日iPhone6 Plus发布"）
        NewsDao newsDao1 = GetDaoMaster.getDaoSession(BaseActivity.getCurrentActivity()).getNewsDao();
        QueryBuilder qb = newsDao1.queryBuilder();
        qb.where(qb.and(NewsDao.Properties.Title.eq("这是第一条新闻"), NewsDao.Properties.CommentCount.gt("0")));
        News news1 = (News) qb.build().unique();
        news.setTitle("今日iPhone6 Plus发布");
        newsDao.update(news);

        //3.修改符合约束条件的记录(修改所有的title都为"今日iPhone6 Plus发布")
        NewsDao newsDao2 = GetDaoMaster.getDaoSession(BaseActivity.getCurrentActivity()).getNewsDao();
        QueryBuilder qb2 = newsDao2.queryBuilder();
        List<News> list = qb2.build().list();
        for (News n :
                list) {
            n.setTitle("今日iPhone6 Plus发布");
        }
        newsDao2.updateInTx(list);//updateAll()?

        //4.将id=2的记录title修改为"今日iPhone6发布"
        NewsDao newsDao3 = GetDaoMaster.getDaoSession(BaseActivity.getCurrentActivity()).getNewsDao();
        News news3 = newsDao3.queryBuilder().where(NewsDao.Properties.Id.eq("2")).build().unique();
        news.setTitle("今日iPhone6发布");
        newsDao3.update(news);

        //5.把news表中标题为“今日iPhone6发布”且评论数量大于0的所有新闻的标题改成“今日iPhone6 Plus发布”
        NewsDao newsDao4 = GetDaoMaster.getDaoSession(BaseActivity.getCurrentActivity()).getNewsDao();
        QueryBuilder qb4 = newsDao4.queryBuilder();
        List<News> list4 = qb4.where(qb4.and(NewsDao.Properties.Title.eq("今日iPhone6发布"), NewsDao.Properties.CommentCount.gt("0"))).list();
        for (News n :
                list4) {
            n.setTitle("今日iPhone6 Plus发布");
        }
        newsDao4.updateInTx(list);//updateAll()?
    }

    /**
     * 删除数据
     */
    public void delete() {
	/*
	 * 1.删除id为2的记录
	 * 这不仅仅会将news表中id为2的记录删除，同时还会将其它表中以
	 * news id为2的这条记录作为外键的数据一起删除掉，因为外键既
	 * 然不存在了，那么这么数据也就没有保留的意义了
	 * */
        NewsDao newsDao = GetDaoMaster.getDaoSession(BaseActivity.getCurrentActivity()).getNewsDao();
        newsDao.deleteByKey(Long.getLong("2"));

        //2.news表中标题为“今日iPhone6发布”且评论数等于0的所有新闻都删除掉
        NewsDao newsDao2 = GetDaoMaster.getDaoSession(BaseActivity.getCurrentActivity()).getNewsDao();
        QueryBuilder qb2 = newsDao2.queryBuilder();
        List<News> list2 = qb2.where(qb2.and(NewsDao.Properties.Title.eq("今日iPhone6发布"), NewsDao.Properties.CommentCount.eq("0"))).list();
        newsDao2.deleteInTx(list2);

        //3.想把表中的所有news数据删除掉
        NewsDao newsDao3 = GetDaoMaster.getDaoSession(BaseActivity.getCurrentActivity()).getNewsDao();
        newsDao3.deleteAll();


        //4通过对象也可以删除持久化的数据
        NewsDao newsDao4 = GetDaoMaster.getDaoSession(BaseActivity.getCurrentActivity()).getNewsDao();
        News news = newsDao4.queryBuilder().where(NewsDao.Properties.Id.eq("1")).build().unique();
        news.delete();

    }

    /**
     * 查询   3.5不会  基金1
     */
    public void select() {
        //-----------------------------------懒加载查询---------------------------------------------------
        //1.查询news表中id为1的这条记录
        NewsDao newsDao = GetDaoMaster.getDaoSession(BaseActivity.getCurrentActivity()).getNewsDao();
        News news = newsDao.queryBuilder().where(NewsDao.Properties.Id.eq("1")).unique();

        //2.获取news表中的第一条数据,最后一条数据
//       News news1=newsDao.queryBuilder().list().get()
//        News news2=newsDao.queryBuilder().offset();通过newsDao.count()方法


        //3.news表中id为1、3、5、7的数据都查出来


        //4.查询news表中所有评论数大于零的新闻
        List<News> newsList4 = newsDao.queryBuilder().where(NewsDao.Properties.CommentCount.gt("0")).build().list();

        //5.也许你并不需要那么多的数据，而是只要title和content这两列数据。那么也很简单，我们只要再增加一个连缀就行了
        QueryBuilder<News> qb = newsDao.queryBuilder();

        //6.将查询出的新闻按照发布的时间倒序排列，即最新发布的新闻放在最前面
        List<News> newsList6 = newsDao.queryBuilder().orderDesc(NewsDao.Properties.PublishDate).build().list();


        //7.也许你并不希望将所有条件匹配的结果一次性全部查询出来，因为这样数据量可能会有点太大了，而是希望只查询出前10条数据
        List<News> newsList7 = newsDao.queryBuilder().orderDesc(NewsDao.Properties.PublishDate).limit(10).list();

        //8.刚才我们查询到的是所有匹配条件的前10条新闻，那么现在我想对新闻进行分页展示，翻到第二页时，展示第11到第20条新闻
        List<News> newsList8 = newsDao.queryBuilder().orderDesc(NewsDao.Properties.PublishDate).offset(10).limit(10).list();

        //------------------------------------激进查询-----------------------------------------------------
        //有问题
        //1.我们想要查询news表中id为1的新闻，并且把这条新闻所对应的评论也一起查询出来

        News news11 = newsDao.queryBuilder().where(NewsDao.Properties.Id.eq("1")).unique();
        List<Comment> list1 = news11.getComment();

        CommentDao commentDao = GetDaoMaster.getDaoSession(BaseActivity.getCurrentActivity()).getCommentDao();
        QueryBuilder<Comment> qb2 = commentDao.queryBuilder();
        qb2.join(News.class, CommentDao.Properties.NewsId);
        List<Comment> list2 = qb2.list();

        //查询订单日期为++的素有客户
        QueryBuilder<Customer> queryBuilder = getDaoSession(BaseActivity.getCurrentActivity()).getCustomerDao().queryBuilder();
        queryBuilder.join(Order.class, OrderDao.Properties.CustomerId)
                .where(OrderDao.Properties.Date.eq(new Date()));
        List<Customer> order = queryBuilder.list();
        for (int i = 0; i < order.size(); i++) {
            System.out.println(order);
        }
        //当我需要姓名为++的订单的时候。
        QueryBuilder<Order> queryBuilder2 = getDaoSession(BaseActivity.getCurrentActivity()).getOrderDao().queryBuilder();
        queryBuilder2.join(Customer.class, CustomerDao.Properties.Id)//根据顾客的id链接
                .where(CustomerDao.Properties.Name.eq("小明"));
        List<Order> order2 = queryBuilder2.list();

        //-----------------------------------原生查询-------------------------------------------------------

        Query query = newsDao.queryBuilder().where(new
                WhereCondition.StringCondition("select * from news where commentcount>?")).build();
    }

}