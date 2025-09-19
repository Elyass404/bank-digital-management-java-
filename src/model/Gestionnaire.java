package model;

import java.util.Date;
import java.util.HashSet;
import java.time.LocalDate;

public class Gestionnaire extends GeneralUser {

    private String idGestionnaire;

    public Gestionnaire(String nom, String prenom, String email, String motDePass, String idGestionnaire){
        super(nom, prenom, email, motDePass);
        this.idGestionnaire = idGestionnaire;

    }

    //Getters and Setters
    public String getIdGestionnaire() {
        return idGestionnaire;
    }

    public void setIdGestionnaire(String idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }

    public Compte creerCompteClient(Client client, String numeroCompte, String typeCompte) {
        //creation d'un compte pour un nouvau client
        Compte compte = new Compte(numeroCompte,typeCompte);

        client.ajouterCompte(compte);
        return compte;
    }

    public boolean cloturerCompteClient(Client client, String numeroCompte) {

        if(client.getCompte(numeroCompte) != null){
            client.supprimerCompte(numeroCompte);
            System.out.println("Le compte a ete supprime! ");
            return true;
        }else{
            System.out.println("Le compte a etait n'existe pas");
            return false;
        }
    }

    public void modifierInfoClient(Client client,String nom, String prenom, String email, String motDepass ) {
        if(nom != null){client.setNom(nom);}
        if(prenom != null){client.setPrenom(prenom);}
        if(email != null){client.setEmail(email);}
        if(motDepass != null){client.setMotDePasse(motDepass);}

        System.out.println("Les informations sont modifier avec succes");
    }

    public void consulterHistoriqueClient(Client client, String numeroCompte) {

        if(client.getCompte(numeroCompte) != null){
            HashSet<Transaction> histo = client.getCompte(numeroCompte).getHistoriqueTransactions();
            if (histo.isEmpty()) {
                System.out.println("Aucune transaction existe pour ce compte!");
            }else{

                for(Transaction item : histo){
                    String idTransaction = item.getIdTransaction();
                    String type = item.getType();
                    Double montant = item.getMontant();
                    LocalDate date = item.getDate();
                    String compteSource = item.getCompteSource();
                    String compteDestination = item.getCompteDestination();

                    System.out.println("Id Transaction: " + idTransaction + " | Type de transaction: "+ type +" | Montant: " + montant + "Dirhams | Date: " + date + " | Compte source: " + compteSource + " | Compte destination: " + compteDestination);

                }
            }
        }else{
            System.out.println("Aucune compte existe avec ce numero de compte!");
        }
    }



}
