package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Demo1Application {

    public static String getEvenNumbersAsString(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(getEvenNumbersAsString(numbers));
    }


    public static class Person {
        private String name;
        private int age;


        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }

        public static void main(String[] args) {
            List<Person> people = List.of(
                    new Person("Amy", 30),
                    new Person("mary", 25),
                    new Person("Cecile", 35),
                    new Person("Duck", 28)
            );

            List<String> namesOver30 = people.stream()
                    .filter(person -> person.getAge() > 30)
                    .map(Person::getName)
                    .collect(Collectors.toList());

            System.out.println("People over 30: " + namesOver30);
        }
    }
}

