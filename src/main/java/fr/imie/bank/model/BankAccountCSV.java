package main.java.fr.imie.bank.model;


import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class BankAccountCSV implements BankAccountDAO {


    @Override
    public ArrayList<BankAccount> findAll() {
        ArrayList<BankAccount> records = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("BankAccount.csv"));
            String line;

            File fich = new File("BankAccount.csv");

            if (fich.length() > 0) {
                while ((line = reader.readLine()) != null) {

                    String[] decompose = line.split(";");
                    String id = decompose[0];
                    String num = decompose[1];
                    String balance = decompose[2];

                    int index = Integer.parseInt(id);

                    BigDecimal Balance = new BigDecimal(balance);

                    PersonDAO person = new PersonCSV();

                    person.findById(index);

                    BankAccount account = new BankAccount(num, Balance, index);
                    records.add(account);
                }
                reader.close();
                return records;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public BankAccount findById() {
        return null;
    }

    public void save() {

    }

    public void saveAll(ArrayList<BankAccount> accounts) {
        try {
            FileWriter fw = new FileWriter("BankAccount.csv");
            for (BankAccount account : accounts) {
                fw.write(account.toString());
                fw.write("\n");
            }
            fw.close();

        } catch (IOException ex) {
            System.err.println("Couldn't log");
        }
    }

    public void deleteAll(){
        try {
            FileWriter fw = new FileWriter("BankAccount.csv", true);
            fw.write("");
            fw.write("\n");
            fw.close();

        } catch (IOException ex) {
            System.err.println("Couldn't log");
        }

    }

    public void deleteById(int id){

    }
}
