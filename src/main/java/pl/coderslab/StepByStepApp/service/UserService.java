package pl.coderslab.StepByStepApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.StepByStepApp.entity.Role;
import pl.coderslab.StepByStepApp.entity.User;
import pl.coderslab.StepByStepApp.repository.RoleRepository;
import pl.coderslab.StepByStepApp.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptionalEmail = userRepository.findUserByEmail(user.getEmail());
        if(userOptionalEmail.isPresent()){
            throw new IllegalStateException("Email już używany");
        }
        Optional<User> userOptionalName = userRepository.findUserByUserName(user.getUserName());
        if(userOptionalName.isPresent()){
            throw new IllegalStateException("Nazwa użytkownika jest już używana");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    public void deleteUser(Long userId){
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException("Taki użytkownik nie istnieje");
        }
        userRepository.deleteById(userId);
    }

    public void updateUser(User userToUpdate){
        User user = userRepository.findById(userToUpdate.getId()).orElseThrow(()->new IllegalStateException("Taki użytkownik nie istnieje"));
        userRepository.save(user);
    }

    public User findUserByEmail(String email){
        Optional<User> userOptional = userRepository.findUserByEmail(email);
        if(userOptional.isEmpty()){
            throw new IllegalStateException("Taki użytkownik nie istnieje");
        }
        return userOptional.get();
    }

    public User findUserByUserName(String userName){
        Optional<User> userOptional = userRepository.findUserByUserName(userName);
        if(userOptional.isEmpty()){
            throw new IllegalStateException("Taki użytkownik nie istnieje");
        }
        return userOptional.get();
    }

    public List<User> findTopFiveUsers(){
        return userRepository.findTopFiveUsers();
    }

    public User findUserById(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()){
            throw new IllegalStateException("Taki użytkownik nie istnieje");
        }
        return userOptional.get();
    }
}
