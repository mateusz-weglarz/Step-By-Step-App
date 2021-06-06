package pl.coderslab.StepByStepApp.service;


import org.springframework.stereotype.Service;
import pl.coderslab.StepByStepApp.entity.Group;
import pl.coderslab.StepByStepApp.entity.Role;
import pl.coderslab.StepByStepApp.entity.User;
import pl.coderslab.StepByStepApp.repository.GroupRepository;
import pl.coderslab.StepByStepApp.repository.RoleRepository;
import pl.coderslab.StepByStepApp.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.*;


@Service
@Transactional
public class GroupService {

    private final GroupRepository groupRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public GroupService(GroupRepository groupRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public void removeUserFromGroups(User user) {
        groupRepository.deleteUserFromGroupsByUserId(user.getId());
    }

    public List<Group> findGroupsByUserId(Long userId) {
        return groupRepository.findGroupsByUserId(userId);
    }

    public Integer getNumberOfMembers(Long groupId) {
        return groupRepository.getNumberOfMembers(groupId);
    }

    public void addNewGroup(Group group, User user) {
        Optional<Group> groupOptional = groupRepository.findGroupByName(group.getName());
        if (groupOptional.isPresent()) {
            throw new IllegalStateException("Nazwa grupy już używana");
        }
        Role userNewRole = roleRepository.findByName("ROLE_GROUP_ADMIN");
        Set<Role> userRoles = user.getRoles();
        userRoles.add(userNewRole);
        user.setRoles(userRoles);
        group.setGroupAdminId(user.getId());
        List<Group> groupList = user.getGroupList();
        groupList.add(group);
        user.setGroupList(groupList);
        groupRepository.save(group);
        userRepository.save(user);
    }

    public List<Group> findAllGroups() {
        return groupRepository.findAll();
    }

    public Group findGroupByName(String name) {
        Optional<Group> groupOptional = groupRepository.findGroupByName(name);
        if (groupOptional.isEmpty()) {
            throw new IllegalStateException("Grupa o podanej nazwie nie istnieje.");
        }
        return groupOptional.get();
    }

    public Group findGroupById(Long id) {
        Optional<Group> groupOptional = groupRepository.findById(id);
        if (groupOptional.isEmpty()) {
            throw new IllegalStateException("Grupa nie istnieje.");
        }
        return groupOptional.get();
    }

    public boolean checkIfUserBelongToGroup(User user, Group group) {
        List<User> members = group.getMembers();
        for (User member : members) {
            if (member.getId().equals(user.getId())) {
                return true;
            }
        }
        return false;
    }

    public void updateGroup(Group groupToUpdate) {
        Group group = groupRepository.findById(groupToUpdate.getId()).orElseThrow(() -> new IllegalStateException("Taka grupa nie istnieje"));
        group.setName(groupToUpdate.getName());
        group.setDescription(groupToUpdate.getDescription());
        group.setGoal(groupToUpdate.getGoal());
        groupRepository.save(group);
    }

    public void deleteGroup(Long groupId) {
        boolean exists = groupRepository.existsById(groupId);
        if (!exists) {
            throw new IllegalStateException("Taka grupa nie istnieje");
        }
        groupRepository.deleteUserFromGroupByGroupId(groupId);
        groupRepository.deleteById(groupId);
    }
}