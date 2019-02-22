package main.java.fr.imie.bank.model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PersonCSV implements PersonDAO {

    @Override
    public ArrayList<Person> findAll() {
        ArrayList<Person> records = new ArrayList<>();

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("Person.csv"));
            String line;

            File fich = new File("Person.csv");

            if(fich.length()>0){
                while ((line = reader.readLine()) != null)
                {

                    String[] decompose = line.split(";");
                    String id = decompose[0];
                    String firstname = decompose[1];
                    String lastname = decompose[2];
                    String email = decompose[3];
                    String birthdate = decompose[4];

                    LocalDate dB = LocalDate.parse(birthdate);

                    Integer index = new Integer(id);

                    Person person = new Person(firstname, lastname, email, dB, index);

                    records.add(person);
                }
                reader.close();
                return records;
            }else {
                return null;
            }

        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", "Person.csv");
            e.printStackTrace();
            return null;
        }
    }

    public Person findById(int id) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("Person.csv"));
            String line;
            int index = 0;

            while ((line = reader.readLine()) != null){
                if(index == id){
                    String[] decompose = line.split(";");
                    String a = decompose[0];
                    String firstname = decompose[1];
                    String lastname = decompose[2];
                    String email = decompose[3];
                    String birthdate = decompose[4];

                    LocalDate dB = LocalDate.parse(birthdate);

                    Integer aze = new Integer(a);

                    Person person = new Person(firstname, lastname, email, dB, aze);
                    reader.close();
                    return person;
                }

                index ++;

            }
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", "Person.csv");
            e.printStackTrace();
            return null;
        }


        return null;
    }

    public void save(Person person) {
        try {
            FileWriter fw = new FileWriter("Person.csv", true);

            fw.write(person.toString());
            fw.write("\n");
            fw.close();

        } catch (IOException ex) {
            System.err.println("Couldn't log");
        }

    }

    public void saveAll(ArrayList<Person> people) {
        try {
            FileWriter fw = new FileWriter("Person.csv");
            for (Person person : people) {
                fw.write(person.toString());
                fw.write("\n");
            }
            fw.close();

        } catch (IOException ex) {
            System.err.println("Couldn't log");
        }


    }

    public void deleteAll() {

        PersonDAO person = new PersonCSV();

        ArrayList<Person> persons = new ArrayList<>(person.findAll());

        persons.removeAll(persons);

        person.saveAll(persons);

    }

    public void deleteById(int id) {

        PersonDAO person = new PersonCSV();

        ArrayList<Person> persons = new ArrayList<>(person.findAll());

        for (Person people: persons) {
            if(id == people.getId()){
                persons.remove(id);
                saveAll(persons);
            }
        }
    }
}
