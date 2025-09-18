package model;

import java.time.LocalDate;
import java.util.HashSet;

public class Compte {
    private String numeroCompte;
    private double solde;
    private String typeCompte; // "Courant" or "Épargne"
    private HashSet<Transaction> historiqueTransactions;

    // Constructor
    public Compte(String numeroCompte, String typeCompte) {
        this.numeroCompte = numeroCompte;
        this.typeCompte = typeCompte;
        this.solde = 0.0;
        this.historiqueTransactions = new HashSet<>();
    }

    // Getters
    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public HashSet<Transaction> getHistoriqueTransactions() {
        return historiqueTransactions;
    }

    // Deposit
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
        }
    }

    // Withdraw
    public boolean retirer(double montant) {
        if (montant > 0 && solde >= montant) {
            solde -= montant;
            Transaction transaction = new Transaction(
                    "T" + System.currentTimeMillis(), "Retrait", montant, LocalDate.now(),
                    numeroCompte, null
            );
            ajouterTransaction(transaction);
            System.out.println("Vous avez retire le montant de: " + montant );
            return true;
        }else if(montant < 0 ) {
            System.out.println("il faut entrer un montant positive! Ressayer autre fois");
            return false;
        }else if (solde < montant) {
            System.out.println("Votre solde est insuffissant");
            return false;
        }
        return false;
    }

    // Add transaction to history
    public void ajouterTransaction(Transaction transaction) {
        historiqueTransactions.add(transaction);
    }
}
