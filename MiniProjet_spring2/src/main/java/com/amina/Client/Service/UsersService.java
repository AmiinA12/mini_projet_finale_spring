package com.amina.Client.Service;
import java.util.List;

import com.amina.Client.entity.User;



public interface UsersService {
    List <User> findAll();
    
    User saveUser(User u);
    User updateUser(User u);
    void deleteUser(User u);
     void deleteUserById(Long id);
     User getUser(Long idUser);

}
