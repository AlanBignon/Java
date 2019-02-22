package main.java.fr.imie.bank.model;

import java.util.ArrayList;

public interface PersonDAO {

    ArrayList<Person> findAll();

    Person findById(int id);

    void save(Person person);

    void saveAll(ArrayList<Person> people);

    void deleteAll();

    void deleteById(int id);


}
