import java.util.ArrayList;

public interface BankAccountDAO {

    ArrayList<BankAccount> findAll();

    BankAccount findById();

    void save();

    void saveAll(ArrayList<BankAccount> people);

    void deleteAll();

    void deleteById(int id);

}
