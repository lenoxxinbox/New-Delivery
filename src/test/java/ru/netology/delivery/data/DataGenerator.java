package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity() {
        var cities = new String[]{"Москва", "Санкт-Петербург", "Нижний Новгород", "Архангельск", "Пенза", "Орёл", "Саратов", "Екатеринбург", "Калуга"};

        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        var names = new String[]{"Иванова", "Петрова", "Сидорова", "Паутова", "Ремизова", "Фролова", "Дудина"};

        return names[new Random().nextInt(names.length)];
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));

        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
