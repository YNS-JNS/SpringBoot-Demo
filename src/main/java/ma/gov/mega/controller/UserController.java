package ma.gov.mega.controller;

import ma.gov.mega.entity.UserEntity;
import ma.gov.mega.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to manage user-related operations.
 * This class handles API endpoints for CRUD operations on users.
 */
@RestController // IOC: Marks this class as a controller where every method returns a JSON response.
@RequestMapping("/api/v1/users") // Base URL for all endpoints in this controller.
public class UserController {

    @Autowired // DI: Injects the UserService dependency into this controller.
    private UserService userService;

    /**
     * Create a new user.
     *
     * @param user The user to create.
     * @return The created user.
     */
    @PostMapping
    public UserEntity createUserCtrl(@RequestBody UserEntity user) {
        return userService.createUserService(user);
    }

    /**
     * Retrieve all users.
     *
     * @return A list of all users.
     */
    @GetMapping
    public List<UserEntity> getAllUsersCtrl() {
        return userService.getAllUsersService();
    }

    /**
     * Retrieve a user by ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user with the given ID.
     */
    @GetMapping("/{id}")
    public UserEntity getUserByIdCtrl(@PathVariable("id") Long id) {
        return userService.findByIdService(id);
    }

    /**
     * Update an existing user.
     *
     * @param id   The ID of the user to update.
     * @param user The user details to update.
     * @return The updated user.
     */
    @PutMapping("/{id}")
    public UserEntity updateUserCtrl(@PathVariable("id") Long id, @RequestBody UserEntity user) {
        return userService.updateUserService(id, user);
    }

    /**
     * Delete a user by ID.
     *
     * @param id The ID of the user to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteUserCtrl(@PathVariable("id") Long id) {
        userService.deleteUserService(id);

    }
}
