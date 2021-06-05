package pl.coderslab.StepByStepApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.StepByStepApp.entity.Group;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    Optional<Group> findGroupByName(String name);

    @Query(value = "SELECT * FROM teams t INNER JOIN users u where u.id=:id ORDER BY t.created DESC", nativeQuery = true)
    List<Group> findGroupsByUserId(Long id);

    @Modifying
    @Query(value = "DELETE FROM user_groups WHERE members_id=:user_id", nativeQuery = true)
    void deleteUserFromGroup(Long user_id);
}
