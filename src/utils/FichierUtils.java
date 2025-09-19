package utils;

import java.io.FileWriter;
import java.io.IOException;

public class FichierUtils {
    public static void ecrireDansFichier(String chemin, String contenu) {

        try (FileWriter writer = new FileWriter(chemin, true)) {
            writer.write(contenu + "\n");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }
}
