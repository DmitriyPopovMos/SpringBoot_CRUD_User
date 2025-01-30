package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service                                                  // @Service - указывает, что класс реализует бизнес-логику, относящуюся к определённому домену приложения.
public class UserService {

    private final UserRepository userRepository;

    @Autowired                                            // @Autowired — используется для автоматического внедрения зависимостей (dependency injection)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User findById(Long id) {
        return userRepository.getById(id);                 // поиск User по id
    }

    public List<User> findAll() {
        return userRepository.findAll();                   // возвращает список всех User
    }

    public User save(User user) {                          // добавляет нового User в БД
        return userRepository.save(user);
    }

    public void deleteById(Long id) {                      // удаляет User по id из БД
        userRepository.deleteById(id);
    }
}
