import model.Client;
import model.Compte;
import model.Gestionnaire;
import model.Transaction;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== DEMO BANCAIRE =====\n");

        // 1. Créer un gestionnaire
        Gestionnaire gestionnaire = new Gestionnaire(
                "Ali", "Manager", "ali.manager@email.com", "pass123", "G001"
        );
        System.out.println("Gestionnaire créé: " + gestionnaire + "\n");

        // 2. Créer un client
        Client client = new Client(
                "Ilyass", "Mar", "ilmar@email.com", "mypassword", "C001"
        );
        System.out.println("Client créé: " + client + "\n");

        // 3. Le gestionnaire crée deux comptes pour le client
        Compte compteCourant = gestionnaire.creerCompteClient(client, "C1001", "Courant");
        Compte compteEpargne = gestionnaire.creerCompteClient(client, "C1002", "Epargne");
        System.out.println("Deux comptes ont été créés pour le client.\n");

        // 4. Effectuer des opérations sur le compte courant
        System.out.println(">>> Dépôt de 500 sur le compte courant...");
        compteCourant.deposer(500);
        Transaction t1 = new Transaction("T001", "Depot", 500, LocalDate.now(), null, "C1001");
        compteCourant.ajouterTransaction(t1);

        System.out.println(">>> Retrait de 200 sur le compte courant...");
        compteCourant.retirer(200);

        // 5. Effectuer un virement vers le compte épargne
        System.out.println(">>> Virement de 100 du compte courant vers le compte épargne...");
        boolean virement = compteCourant.virementVers(compteEpargne, 100);
        if (virement) {
            System.out.println("✅ Virement effectué avec succès.");
        } else {
            System.out.println("❌ Virement échoué (solde insuffisant).");
        }

        // 6. Consulter soldes et historiques
        System.out.println("\n--- Soldes des comptes ---");
        System.out.println("Compte Courant (" + compteCourant.getNumeroCompte() + "): " + compteCourant.getSolde());
        System.out.println("Compte Epargne (" + compteEpargne.getNumeroCompte() + "): " + compteEpargne.getSolde());

        System.out.println("\n--- Historique du compte courant ---");
        gestionnaire.consulterHistoriqueClient(client, "C1001");

        System.out.println("\n--- Historique du compte épargne ---");
        gestionnaire.consulterHistoriqueClient(client, "C1002");

        // 7. Modifier infos du client
        System.out.println("\n>>> Modification des infos du client...");
        gestionnaire.modifierInfoClient(client, "Yassine", null, "yassine.new@email.com", null);
        System.out.println("Nouvelles infos client: " + client);

        // 8. Clôturer un compte
        System.out.println("\n>>> Tentative de clôture du compte épargne...");
        gestionnaire.cloturerCompteClient(client, "C1002");

        System.out.println("\n>>> Tentative de clôture d’un compte inexistant...");
        gestionnaire.cloturerCompteClient(client, "C9999");

        System.out.println("\n===== FIN DE DEMO =====");
    }
}
