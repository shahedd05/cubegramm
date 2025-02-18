package com.google.appgramtest.service;


import com.google.appgramtest.models.User;

import java.util.List;

public interface UserService {
User getUser(int id);
String saveUser(User user);
String updateUser(User user,int id);
String deleteUser(int id);
List<User> getAllUseres();
}
