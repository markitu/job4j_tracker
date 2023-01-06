package ru.job4j.search;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenFindBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Dima", "Stolniy", "925252525", "Tula")
        );
        ArrayList<Person> persons = phones.find("oln");
        assertThat(persons.get(0).getName()).isEqualTo("Dima");
    }

    @Test
    public void whenFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Dima", "Stolniy", "925252525", "Tula")
        );
        ArrayList<Person> persons = phones.find("la");
        assertThat(persons.get(0).getName()).isEqualTo("Dima");
    }

    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Dima", "Stolniy", "925252525", "Tula")
        );
        ArrayList<Person> persons = phones.find("2525");
        assertThat(persons.get(0).getName()).isEqualTo("Dima");
    }

    @Test
    public void whenNotFound() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Dima", "Stolniy", "925252525", "Tula")
        );
        ArrayList<Person> persons = phones.find("333");
        assertThat(persons.size()).isEqualTo(0);
    }
}