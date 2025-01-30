package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller                                          // @Controller - определяет классы в качестве контроллеров в Spring MVC. Помогает Spring определить компоненты, которые будут обрабатывать входящие запросы.
public class UserController {

    private final UserService userService;

    @Autowired                                        // @Autowired — используется для автоматического внедрения зависимостей (dependency injection)
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")                          // @GetMapping("/Путь") - Обрабатывает HTTP GET-запросы и возвращает ответ (Аналог SELECT)
    public String findAll(Model model) {              // Model - Аналог java.util.Map, в который мы вставляем некие атрибуты.
        List<User> users = userService.findAll();     // возвращает список всех User
        model.addAttribute("users", users);  // model.addAttribute - добавляет атрибут к модели
        return "user-list";
    }

    @GetMapping("/user-create")                    // @GetMapping("/Путь") - Обрабатывает HTTP GET-запросы и возвращает ответ (Аналог SELECT)
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")                   // @PostMapping("/Путь") — Обрабатывает HTTP POST-запросы и возвращает ответ (Аналог INSERT INTO)
    public String createUser(User user) {
        userService.save(user);
        return "redirect:/users";                     // redirect:/Путь - переадресация на указанную страницу
    }

    @GetMapping("/user-delete/{id}")                // @GetMapping("/Путь") - Обрабатывает HTTP GET-запросы и возвращает ответ (Аналог SELECT)
    public String deleteUser(@PathVariable(name = "id") Long id) {      // @PathVariable(name = "имя_переменной") - Переменная пути - извлекает ОТДЕЛЬНЫЕ значения из переменных шаблона URI в URL-адресе запроса. Позволяет сопоставить динамические части URL с параметрами метода в методах обработчика контроллера
        userService.deleteById(id);
        return "redirect:/users";                      // redirect:/Путь - переадресация на указанную страницу
    }
                                                            // @PathVariable(name = "имя_переменной") - Переменная пути - извлекает ОТДЕЛЬНЫЕ значения из переменных шаблона URI в URL-адресе запроса. Позволяет сопоставить динамические части URL с параметрами метода в методах обработчика контроллера
    @GetMapping("/user-update/{id}")                     // @GetMapping("/Путь") - Обрабатывает HTTP GET-запросы и возвращает ответ (Аналог SELECT)
    public String updateUserForm(@PathVariable(name = "id") Long id, Model model) {   // Model - Аналог java.util.Map, в который мы вставляем некие атрибуты.
        User user = userService.findById(id);
        model.addAttribute("user", user);       // model.addAttribute - добавляет атрибут к модели
        return "/user-update";
    }

    @PostMapping("/user-update")                   // @PostMapping("/Путь") — Обрабатывает HTTP POST-запросы и возвращает ответ (Аналог INSERT INTO)
    public String updateUser(User user) {
        userService.save(user);
        return "redirect:/users";                     // redirect:/Путь - переадресация на указанную страницу
    }
}
