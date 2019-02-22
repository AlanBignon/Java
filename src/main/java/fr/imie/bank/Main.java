package main.java.fr.imie.bank;

import main.java.fr.imie.bank.model.*;

import java.time.LocalDate;
import java.util.*;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {


        ArrayList<Person> ListePerson = new ArrayList<>();

        ArrayList<BankAccount> bankAccounts = new ArrayList<>();

        int nbObjet = 0;

        boolean fait = false;
        PersonDAO person = new PersonCSV();
        BankAccountDAO account = new BankAccountCSV();


        boolean doAgain = true;
        while (doAgain = true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nQue voulez vous faire maintenant?");
            System.out.println("1: lister les personnes. ");
            System.out.println("2: Ajouter des personnes.");
            System.out.println("3: Modifier des personnes. ");
            System.out.println("4: Supprimer une personne.");
            System.out.println("5: Ajouter un compte bancaire");
            System.out.println("9: Quittez l'application.");

            int Choix = sc.nextInt();

            if (Choix == 1) {
                System.out.println("Index       Nom      Prenom     Email       Date d'anniversaire");

                //ListePerson.addAll(person.findAll());
                //bankAccounts.addAll(account.findAll());
                if(person.findAll() != null){
                    ArrayList<Person> affichage = new ArrayList<>(person.findAll());
                    for (Person personnes: affichage) {
                        System.out.println(personnes);
                        nbObjet ++;

                    }
                }
            }
            if (Choix == 2) {
                System.out.println("Vous allez crée une Personne !");


                Person newOne = PersonWithId(nbObjet);

                person.save(newOne);

                ListePerson.add(newOne);

            }
            if (Choix == 3) {
                System.out.println("Quel person voulez vous modifier? (Donnez un id)");
                int id = sc.nextInt();
                if(id > nbObjet){
                    System.out.println("Veuillez rentrez un id valide");
                    id = sc.nextInt();
                }

                Person modifie = choice();

                ListePerson.set(id, modifie);

                person.saveAll(ListePerson);

            }
            if (Choix == 4) {

                System.out.println("Quel personnes voulez vous supprimer? (Donnez un id)");
                int id = sc.nextInt();
                if(id > nbObjet){
                    System.out.println("Veuillez rentrez un id valide");
                    id = sc.nextInt();
                }

                ListePerson.remove(id);
                person.saveAll(ListePerson);

            }
            if(Choix==5){

                System.out.println("Quel est l'id de l'owner de ce compte?");
                int id = sc.nextInt();
                if(id > nbObjet){
                    System.out.println("Veuillez rentrer un id valide !");
                    id = sc.nextInt();
                }

                BankAccount compte = new BankAccount(person.findById(id));

                bankAccounts.add(compte);

                person.findById(id).addBankAccounts(compte);

                person.saveAll(ListePerson);

                account.saveAll(bankAccounts);
            }
            if (Choix == 9) {
                person.saveAll(ListePerson);
                account.saveAll(bankAccounts);
                doAgain = false;
                break;
            }
            }
        }

    private static Person choice() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("Veuillez rentrer le firstname de cette personne :");
        String nom = sc.nextLine();

        System.out.println("Veuillez rentrer le lastname de cette personne :");
        String prenom = sc.nextLine();

        System.out.println("Veuillez rentrer l'email de cette personne :");
        String email = sc.nextLine();

        System.out.println("Veuillez rentrer la date de naissance de cette personne : (format dd-MM-yyyy)");
        String date = sc.nextLine();

        LocalDate dB = LocalDate.parse(date, formatter);

        Person person = new Person(nom, prenom, email, dB);
        return person;
    }

    private static Person PersonWithId(int id) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("Veuillez rentrer le firstname de cette personne :");
        String nom = sc.nextLine();

        System.out.println("Veuillez rentrer le lastname de cette personne :");
        String prenom = sc.nextLine();

        System.out.println("Veuillez rentrer l'email de cette personne :");
        String email = sc.nextLine();

        System.out.println("Veuillez rentrer la date de naissance de cette personne : (format dd-MM-yyyy)");
        String date = sc.nextLine();

        LocalDate dB = LocalDate.parse(date, formatter);

        Person person = new Person(nom, prenom, email, dB, id);
        return person;
    }
    
}
