package com.google.appgramtest.service;

import com.google.appgramtest.models.User;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface UserService {
User getUser(int id);
String saveUser(User user, MultipartFile file);
String updateUser(User user, int id);
String deleteUser(int id);
List<User> getAllUseres();
User getUserByName(String name);
}
