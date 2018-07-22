package com.lqyhmb.jpademo.repository;

import com.lqyhmb.jpademo.domain.User;

import java.util.List;

/**
 * 用户dao
 * Created by Rodriguez
 * 2018/7/21 21:10
 */
public interface UserRepository {

    /**
     * 创建/修改用户信息
     *
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 查询用户列表
     *
     * @return
     */
    List<User> listUser();
}
