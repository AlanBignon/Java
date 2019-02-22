import java.math.BigDecimal;

public class BankAccount {

    private String number;

    private BigDecimal balance = new BigDecimal(1000);

    private int idOfOwner;

    private Person owner;

    public BankAccount(Person aPerson){
        this.owner = aPerson;
    }

    public BankAccount(Person aPerson, String aNumber, BigDecimal aBalance){
        this.owner = aPerson;
        this.number = aNumber;
        this.balance = aBalance;
    }

    public BankAccount(String aNumber, BigDecimal aBalance, int aId){
        this.balance = aBalance;
        this.number = aNumber;
        this.idOfOwner = aId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person person) {
        this.owner = person;
        this.idOfOwner = person.getId();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getIdOfOwner() {
        return idOfOwner;
    }

    @    Override
    public String toString() {
        return owner.getId() + ";"+number + ";"+ balance;
    }
}
