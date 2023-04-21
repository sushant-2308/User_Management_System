package com.example.UserManagement.repository;


import com.example.UserManagement.model.UserManagement;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<UserManagement> userManagementList;

    public UserRepository() {

        userManagementList=new ArrayList<>();
//        userManagementList.add(new UserManagement(1,"xyz","zyxsecsd","bluechip","1234567890"));
    }

    public  boolean save(UserManagement userManagement)
    {
        userManagementList.add(userManagement);
        return true;
    }

    public List<UserManagement> getUsersFromDataSource()
    {
        return userManagementList;
    }

    public boolean update(int id,UserManagement userManagement) {
        for(UserManagement userManage:userManagementList){
            if(userManage.getUserId()==id){
                  remove(userManage);
                  save(userManagement);
                  return true;
            }
        }
        return false;
    }

    public boolean remove(UserManagement userManagement){
        userManagementList.remove(userManagement);
        return true;
    }
}
