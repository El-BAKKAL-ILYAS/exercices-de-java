package fr.hetic;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

public class FileProcessor {

    // Utilisation d'une interface fonctionnelle Consumer pour encapsuler le traitement de chaque ligne
    public void processFile(String fileName, Consumer<String> lineProcessor) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.lines().forEach(lineProcessor); // Utilisation de forEach pour traiter chaque ligne
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        
        // Utilisation d'une expression lambda pour le traitement de chaque ligne
        fileProcessor.processFile("mon_fichier.txt", (String line) -> {
            String[] parts = line.split(" ");
            if (parts.length != 3) {
                System.out.println("Erreur: chaques ligne doit contenir un nombre, un opérateur et un autre nombre.");
                return;
            }

            double nombre1, nombre2;
            try {
                nombre1 = Double.parseDouble(parts[0]);
                nombre2 = Double.parseDouble(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Erreur: les deux premiers arguments doivent être des nombres.");
                return;
            }

            String operateur = parts[2];
            try {
                double resultat = calculator.calculer(nombre1, nombre2, operateur);
                System.out.println("Résultat de l'opération: " + resultat);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        });
    }
}

