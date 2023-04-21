package com.example.UserManagement.service;

import com.example.UserManagement.model.UserManagement;
import com.example.UserManagement.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public List<UserManagement> getAllUsers(){
         return userRepository.getUsersFromDataSource();
    }

    public String addMyUser(UserManagement userManagement)
    {
        boolean insertionStatus=userRepository.save(userManagement);
        if(insertionStatus)
            return "User added successfully..!";
        else
            return "Failed user add not possible";
    }

    public UserManagement getUserBasedId(String id)
    {
        List<UserManagement> UserRightNow=userRepository.getUsersFromDataSource();

        for(UserManagement userManagement:UserRightNow){
            if(userManagement.getUserId()==Integer.parseInt(id))
                return userManagement;
        }
        return null;
    }

    public String updateUser(int id,UserManagement userManagement) {
        String status;
        List<UserManagement> UserRightNow=userRepository.getUsersFromDataSource();

        for(UserManagement userManage:UserRightNow){
            if(userManage.getUserId()==(id)) {
                if(userRepository.update(id,userManagement))
                return "Updated Successfully";
            }
        }
        return "cannot update User";
    }

    public String removeUserId(String id)
    {
        boolean deleteResponse=false;
        String status;
       if(id!=null){
           List<UserManagement> UserRightNow=userRepository.getUsersFromDataSource();

           for(UserManagement userManagement:UserRightNow){
               if(userManagement.getUserId()==Integer.parseInt(id)) {
                   deleteResponse=userRepository.remove(userManagement);
                   if(deleteResponse)
                   {
                       status="User with id "+id+" was deleted";
                   }
                   else{
                       status="Deletion was not possible on  "+id;
                   }
                   return status;
               }
           }
           return "User with "+id+" does not exist";
       }
           return "invalid id cannot acept null id";
    }
}
