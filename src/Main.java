import model.Client;
import model.Compte;
import model.Transaction;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create a client
        Client client = new Client("John", "Doe", "john@example.com", "secure123", "C001");

        // Create an account
        Compte compte = new Compte("C1001", "Courant");

        // Add account to client
        client.ajouterCompte(compte);

        // Deposit money
        compte.deposer(100);

        // retirer montant
        compte.retirer( 100);

        // Create a transaction
        Transaction transaction = new Transaction(
                "T001", "Depot", 100, LocalDate.now(), null, "C1001"
        );

        // Add transaction to account history
        compte.ajouterTransaction(transaction);

        // Print account balance and transaction history
        System.out.println("Votre balance est: " + compte.getSolde());
        for (Transaction t : compte.getHistoriqueTransactions()) {
            System.out.println(t);
        }
    }
}
