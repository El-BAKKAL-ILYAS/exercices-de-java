package fr.hetic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TraitementFichiers {
    public static void main(String[] args) {
        // Vérification du nombre d'arguments
        if (args.length != 1) {
            System.out.println("Usage: java TraitementFichiers <chemin_dossier>");
            return;
        }

        // Chemin du dossier contenant les fichiers .op
        String cheminDossier = args[0];
        File dossier = new File(cheminDossier);

        // Vérification que le chemin est bien un dossier
        if (!dossier.isDirectory()) {
            System.out.println("Le chemin spécifié n'est pas un dossier valide.");
            return;
        }

        // Liste des fichiers dans le dossier
        File[] fichiers = dossier.listFiles();

        // Parcours des fichiers
        for (File fichier : fichiers) {
            if (fichier.isFile() && fichier.getName().endsWith(".op")) {
                traiterFichier(fichier);
            }
        }

        System.out.println("Traitement terminé.");
    }

    private static void traiterFichier(File fichier) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
            String nomFichierSortie = fichier.getAbsolutePath().replace(".op", ".res");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichierSortie))) {
                String ligne;
                while ((ligne = reader.readLine()) != null) {
                    String[] elements = ligne.split(" ");
                    if (elements.length != 3) {
                        writer.write("ERROR\n");
                        continue;
                    }
                    try {
                        double nombre1 = Double.parseDouble(elements[0]);
                        double nombre2 = Double.parseDouble(elements[1]);
                        char operateur = elements[2].charAt(0);
                        double resultat;
                        switch (operateur) {
                            case '+':
                                resultat = nombre1 + nombre2;
                                break;
                            case '-':
                                resultat = nombre1 - nombre2;
                                break;
                            case '*':
                                resultat = nombre1 * nombre2;
                                break;
                            default:
                                throw new IllegalArgumentException("Opérateur non valide.");
                        }
                        writer.write(String.valueOf(resultat) + "\n");
                    } catch (NumberFormatException e) {
                        writer.write("ERROR\n");
                    } catch (IllegalArgumentException e) {
                        writer.write("ERROR\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
