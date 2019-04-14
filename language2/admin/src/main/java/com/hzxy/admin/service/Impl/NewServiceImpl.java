package com.hzxy.admin.service.Impl;

import com.hzxy.admin.dao.AreaContentDao;
import com.hzxy.admin.dao.NewsDao;
import com.hzxy.admin.service.NewService;
import com.hzxy.domain.entity.News;
import com.hzxy.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther:lwq
 * @Date:2019/4/1
 * @Description:com.hzxy.admin.service.Impl
 * @version:1.0
 */
@Service
public class NewServiceImpl implements NewService{
    @Autowired
    private NewsDao newsDao;


    @Override
    public int add(News entity) {
        entity.setCreated(new Date());
        entity.setUpdated(new Date());
        return newsDao.insert(entity);
    }

    @Override
    public List<News> selectAll() {
        return newsDao.selectAll();
    }

    @Override
    public int count(News entity) {
        return 0;
    }

    @Override
    public News selectById(Long id) {
        return newsDao.selectById(id);
    }

    @Override
    public int update(News entity) {
        entity.setUpdated(new Date());
        return newsDao.update(entity);
    }

    @Override
    public int deleteById(Long id) {
        return newsDao.deleteById(id);
    }


    //批量删除
    @Override
    public long deleteByList(String ids) {

        String[] ss = ids.split(",");
        long count= 0;
        for (String s : ss) {
           newsDao.deleteByTrap(Integer.parseInt(s));
            count++;
        }
        return count;

    }
/*
    @Override //前端
    public List<News> getnew() {
        return newsDao.getnew();
    }*/
}
