package model;

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
            System.out.println("tu retire :" + montant + "Dirhams");
            return true;
        }else{
            System.out.println("votre solde est insufisant pour cette operation.");
            return false;
        }
    }

    // Add transaction to history
    public void ajouterTransaction(Transaction transaction) {
        historiqueTransactions.add(transaction);
    }
}
