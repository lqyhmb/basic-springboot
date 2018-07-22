package com.lqyhmb.jpademo.repository.impl;

import com.lqyhmb.jpademo.domain.User;
import com.lqyhmb.jpademo.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 用户dao实现
 * Created by Rodriguez
 * 2018/7/21 21:13
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    // 存储用户信息
    private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<>();
    // 计数 作为用户id
    private static AtomicLong counter = new AtomicLong();

    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        if (id == null) { // 新建
            id = counter.incrementAndGet(); // 返回一个递增的Long值
            user.setId(id);
        }
        this.userMap.put(id, user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return userMap.get(id);
    }

    @Override
    public List<User> listUser() {
        return new ArrayList<>(userMap.values());
    }

}
