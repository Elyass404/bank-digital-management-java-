package model;

import java.time.LocalDate;

public class Transaction {
    private String idTransaction;
    private String type; // "Depot", "Retrait", "Virement"
    private double montant;
    private LocalDate date;
    private String compteSource;
    private String compteDestination;

    // Constructor
    public Transaction(String idTransaction, String type, double montant, LocalDate date,
                       String compteSource, String compteDestination) {
        this.idTransaction = idTransaction;
        this.type = type;
        this.montant = montant;
        this.date = date;
        this.compteSource = compteSource;
        this.compteDestination = compteDestination;
    }

    // Getters
    public String getIdTransaction() {
        return idTransaction;
    }

    public String getType() {
        return type;
    }

    public double getMontant() {
        return montant;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCompteSource() {
        return compteSource;
    }

    public String getCompteDestination() {
        return compteDestination;
    }

    // toString for file output
    @Override
    public String toString() {
        return date + " | " + type + " | " + montant + " Dirhams | " +
                (compteSource == null ? "null" : compteSource) + " | " +
                (compteDestination == null ? "null" : compteDestination);
    }
}
