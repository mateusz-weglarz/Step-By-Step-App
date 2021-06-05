package pl.coderslab.StepByStepApp.service;


import org.springframework.stereotype.Service;
import pl.coderslab.StepByStepApp.entity.User;
import pl.coderslab.StepByStepApp.repository.GroupRepository;

import javax.transaction.Transactional;


@Service
@Transactional
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void removeUserFromGroups(User user) {
        groupRepository.deleteUserFromGroup(user.getId());
    }
}