package pl.coderslab.StepByStepApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.StepByStepApp.entity.Role;
import pl.coderslab.StepByStepApp.entity.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Modifying
    @Query(value = "DELETE FROM user_role WHERE user_id=:user_id", nativeQuery = true)
    void removeUser(Long user_id);
}
