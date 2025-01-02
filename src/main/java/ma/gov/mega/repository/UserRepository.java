package ma.gov.mega.repository;

import ma.gov.mega.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository is an interface for performing CRUD operations on UserEntity.
 * It extends JpaRepository, which provides built-in methods for interacting with the database.
 *
 * JpaRepository provides the following key functionalities:
 * - Basic CRUD operations (save, findById, findAll, deleteById, etc.)
 * - Pagination and sorting capabilities
 * - Custom query support using method names or @Query annotations
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // JpaRepository<UserEntity, Long> means:
    // - UserEntity: The entity this repository will manage.
    // - Long: The type of the primary key of the entity.
}
