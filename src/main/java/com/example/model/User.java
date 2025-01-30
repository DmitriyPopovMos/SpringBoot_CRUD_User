package com.example.model;

import jakarta.persistence.*;


@Entity                                                   // @Entity - указывает, что данный Класс связан с таблицей в БД
@Table(name = "users")                                    // @Table(name = "users") - имя таблицы в БД. Показывает к какой именно таблице мы привязываем Класс
public class User {

    @Id                                                   // @Id - указывает какой столбец таблицы является PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // @GeneratedValue - автогенерация PRIMARY KEY     // IDENTITY - стратегия, при которой PRIMARY KEY изменяется в соответствии с правилами, прописанными при создании таблицы
    @Column(name = "id")                                  // @Column(name = "id") - имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    public Long id;

    @Column(name = "first_name")                          // @Column(name = "first_name") - имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    public String firstName;

    @Column(name = "last_name")                           // @Column(name = "last_name") - имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    public String lastName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

