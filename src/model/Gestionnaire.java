package model;

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



}
