package com.lime.shop;

import java.util.Optional;

public class UserService {

    // Модель пользователя (внутренний класс для простоты)
    public static class User {
        private String id;
        private String name;
        private boolean loyal;

        public User(String id, String name, boolean loyal) {
            this.id = id;
            this.name = name;
            this.loyal = loyal;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public boolean isLoyal() { return loyal; }
    }

    public Optional<User> getUserById(String userId) {
        // В реальном приложении здесь был бы запрос к БД
        // Для тестирования используем mock
        return Optional.empty();
    }

    public boolean isLoyalCustomer(String userId) {
        // Эмуляция проверки статуса постоянного клиента
        // В реальном приложении был бы запрос к БД
        if ("loyalUser".equals(userId)) {
            return true;
        }
        return false;
    }
}