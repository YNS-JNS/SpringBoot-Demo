package ma.gov.mega.service;

import ma.gov.mega.entity.UserEntity;
import ma.gov.mega.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a service for the Spring container.
public class UserServiceImp implements UserService {

    @Autowired // Injects the UserRepository into this service.
    private UserRepository userRepository;

    /**
     * Create a new user.
     *
     * @param user The user to create.
     * @return The created user.
     */
    @Override
    public UserEntity createUserService(UserEntity user) {
        return userRepository.save(user);
    }

    /**
     * Retrieve all users.
     *
     * @return A list of all users.
     */
    @Override
    public List<UserEntity> getAllUsersService() {
        return userRepository.findAll();
    }

    /**
     * Retrieve a user by ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user with the given ID.
     */
    @Override
    public UserEntity findByIdService(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user.orElse(null); // Returns null if the user is not found.
    }

    /**
     * Update an existing user.
     *
     * @param id   The ID of the user to update.
     * @param user The new user details.
     * @return The updated user.
     */
    @Override
    public UserEntity updateUserService(Long id, UserEntity user) {
        Optional<UserEntity> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            UserEntity updatedUser = existingUser.get();
            if ( user.getFirstName() != null ) {
                updatedUser.setFirstName(user.getFirstName());
            }
            if ( user.getLastName() != null ) {
                updatedUser.setLastName(user.getLastName());
            }
            if ( user.getEmail() != null ) {
                updatedUser.setEmail(user.getEmail());
            }
            if ( user.getPassword() != null ) {
                updatedUser.setPassword(user.getPassword());
            }
            return userRepository.save(updatedUser);
        }
        return null; // Return null if the user doesn't exist.
    }

    /**
     * Delete a user by ID.
     *
     * @param id The ID of the user to delete.
     */
    @Override
    public void deleteUserService(Long id) {
        userRepository.deleteById(id);
    }
}
