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

    @Query(value = "SELECT * FROM teams t LEFT JOIN user_groups ug on t.id = ug.group_list_id where ug.members_id=:id ORDER BY t.created DESC", nativeQuery = true)
    List<Group> findGroupsByUserId(Long id);

    @Modifying
    @Query(value = "DELETE FROM user_groups WHERE members_id=:userId", nativeQuery = true)
    void deleteUserFromGroupsByUserId(Long userId);

    @Query(value = "SELECT COUNT(*) AS count FROM user_groups WHERE group_list_id=:groupId",nativeQuery = true)
    Integer getNumberOfMembers(Long groupId);

    @Modifying
    @Query(value = "DELETE FROM user_groups WHERE group_list_id=:groupId", nativeQuery = true)
    void deleteUserFromGroupByGroupId(Long groupId);


}
