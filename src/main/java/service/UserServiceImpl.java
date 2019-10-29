package service;

import dao.TaskRepository;
import dao.UserRepository;
import entities.User;
import exception.EmailExistsException;
import exception.UserNotFoundException;
import exception.WrongPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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

    @Override
    public User signIn(String email, String password) {
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("Wrong email");
        }
        if (! user.getPassword().equals(password)) {
            throw new WrongPassword("Wrong password");
        }
        return user;
    }
}
