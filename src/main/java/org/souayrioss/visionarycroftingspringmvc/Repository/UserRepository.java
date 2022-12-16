package org.souayrioss.visionarycroftingspringmvc.Repository;

import org.souayrioss.visionarycroftingspringmvc.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByRole(User.RoleEnum keyword);
    Page<User> findByFullNameContainsIgnoreCase(String keyword, Pageable pageable);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);


}
