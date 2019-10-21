package service;

import dao.TaskRepository;
import dao.UserRepository;
import exception.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void registerNewUser(String name, String email, String number, String password) {
        if (userRepository.findUserByEmail(email) != null) {
            throw new EmailExistsException("This email is already in use");
        }
        if (userRepository.saveUser(name, email, number, password) == null) {
            throw new RuntimeException("DAO exception");
        }
    }
}
