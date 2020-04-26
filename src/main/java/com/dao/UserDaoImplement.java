package com.dao;

import com.entity.MyUser;
import com.utils.DBconnect;
import jdk.nashorn.internal.objects.annotations.Where;
import sun.security.pkcs11.Secmod;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplement implements UserDao {
    @Override
    public boolean login(String name, String password) {
        boolean flag = false;
        try {
            try {
                DBconnect.init();
            }catch (Exception e){
                e.printStackTrace();
            }
            ResultSet rs = DBconnect.selectSql("select * from student where name='" + name + " 'and password='" + password + "';");
            while (rs.next()){
                if(rs.getString("name").equals(name)&&rs.getString("password").equals(password)){
                    flag = true;
                }
            }
            DBconnect.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean register(MyUser user) {
        boolean flag = false;
        try {
            DBconnect.init();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int i = DBconnect.addUpdateDelete("insert into student(name,password,id) " +
                "values('" + user.getName() + "','" + user.getPassword() + "','"+user.getId()+" ' )");
        if(i>0){
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }

    @Override
    public List<MyUser> getUserAll() {
        List<MyUser> list = new ArrayList<>();
        try{
            try {
                DBconnect.init();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            ResultSet rs = DBconnect.selectSql("select * from student");
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                MyUser user = new MyUser(id,name,password);
                list.add(user);
            }
            DBconnect.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            DBconnect.init();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "delete from student where id = '" +id+"'";
        int i = DBconnect.addUpdateDelete(sql);
        if(i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean update(String name, int id) {
        boolean flag = false;
        try{
            DBconnect.init();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "update student set name = '" + name + "'"+"where id = '" + id+"'";
        int i = DBconnect.addUpdateDelete(sql);
        System.out.println("1"+" "+i);
        if(i>0){
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }
}
