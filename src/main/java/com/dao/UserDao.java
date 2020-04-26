package com.dao;

import com.entity.MyUser;

import java.util.List;

public interface UserDao {
    public boolean login(String name,String password);
    public boolean register(MyUser user);
    public List<MyUser> getUserAll();
    public boolean delete(int id);
    public boolean update(String name,int id);
}
