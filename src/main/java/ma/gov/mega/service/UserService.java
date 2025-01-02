package ma.gov.mega.service;

import ma.gov.mega.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUserService(UserEntity user); // Create
    List<UserEntity> getAllUsersService(); // Read all
    UserEntity findByIdService(Long id); // Read by ID
    UserEntity updateUserService(Long id, UserEntity user); // Update
    void deleteUserService(Long id); // Delete
}
