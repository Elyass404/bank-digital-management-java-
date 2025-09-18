package model;

import java.util.HashMap;

public class Client extends GeneralUser {
    private String idClient;
    private HashMap<String, Compte> comptes;


    // Constructor
    public Client(String nom, String prenom, String email, String motDePasse, String idClient) {
        super(nom, prenom, email, motDePasse);
        this.idClient = idClient;
        this.comptes = new HashMap<>();
    }

    // Getters and setters
    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public HashMap<String, Compte> getComptes() {
        return comptes;
    }

    // Methods to manage accounts
    public void ajouterCompte(Compte compte) {
        comptes.put(compte.getNumeroCompte(), compte);
    }

    public void supprimerCompte(String numeroCompte) {
        comptes.remove(numeroCompte);
    }

    public Compte getCompte(String numeroCompte) {
        return comptes.get(numeroCompte);
    }
}
