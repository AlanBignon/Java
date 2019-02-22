import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Person {

    private String firstName, lastName, email;

    private static final AtomicInteger count = new AtomicInteger(0);


    private int id;

    private LocalDate BirthDate;

    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public Person(String aFirstName, String aLastName, String aEmail, LocalDate aBirthDate){
        this.firstName = aFirstName;
        this.lastName = aLastName;
        this.email = aEmail;
        this.BirthDate = aBirthDate;
        this.id = count.incrementAndGet();
    }
    public Person(String aFirstName, String aLastName, String aEmail, LocalDate aBirthDate, int aId){
        this.firstName = aFirstName;
        this.lastName = aLastName;
        this.email = aEmail;
        this.BirthDate = aBirthDate;
        this.id = aId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<BankAccount> getBankAccounts() {
        return accounts;
    }

    public void addBankAccounts(BankAccount account) {
        accounts.add(account);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ";"+lastName + ";" + firstName + ";" + email + ";" + BirthDate + ";" + accounts;
    }
}