package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository                                                          // @Repository — указывает, что аннотированный класс является репозиторием данных, используемым для хранения, извлечения и поиска данных из БД
public interface UserRepository extends JpaRepository<User, Long> {

}
