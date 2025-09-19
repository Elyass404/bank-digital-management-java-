import model.Client;
import model.Compte;
import model.Transaction;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create a client
        Client client = new Client("ilyass", "mar", "ilmar@email.com", "my pass", "C001");

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

        // Create a second account for Savings
        Compte compte2 = new Compte("C1002", "Epargne");
        client.ajouterCompte(compte2);

        // Transfer from first to second account
        boolean virement = compte.virementVers(compte2, 30);
        if  (virement) {
            System.out.println("Le virement a etait fait avec success!");
            System.out.println("nouvau balance sur le compte (C1001): " + compte.getSolde());
            System.out.println("Nouvau balance sur le compte (C1002): " + compte2.getSolde());
        }else{
            System.out.println("Le balance sur votre compte est insuffisant pour completer cette operation!");
        }


// Print transaction history of both accounts
        System.out.println("\nTransactions for C1001:");
        for (Transaction t : compte.getHistoriqueTransactions()) {
            System.out.println(t);
        }

        System.out.println("\nTransactions for C1002:");
        for (Transaction t : compte2.getHistoriqueTransactions()) {
            System.out.println(t);
        }

        // make a deposit and save transaction
        client.getCompte("C1001");
        compte.deposer(100);

        compte.ajouterTransaction(transaction); // To save the the file txt

        System.out.println("Le Depot a etait complet. Verifier le fichier dans le dossier releves!");

    }

    System.out.println("|--Bienvenue Sur YouPay Bank--|")


}
