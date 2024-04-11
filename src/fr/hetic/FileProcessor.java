package fr.hetic;
//FileProcessor.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

 public void processFile(String fileName) {
     try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
         String line;
         while ((line = reader.readLine()) != null) {
             String[] parts = line.split(" ");
             if (parts.length != 3) {
                 System.out.println("Erreur: chaque ligne doit contenir un nombre, un opérateur et un autre nombre.");
                 continue;
             }

             double nombre1, nombre2;
             try {
                 nombre1 = Double.parseDouble(parts[0]);
                 nombre2 = Double.parseDouble(parts[1]);
             } catch (NumberFormatException e) {
                 System.out.println("Erreur: les deux premiers arguments doivent être des nombres.");
                 continue;
             }

             String operateur = parts[2];
             try {
                 double resultat = calculator.calculer(nombre1, nombre2, operateur);
                 System.out.println("Résultat de l'opération: " + resultat);
             } catch (IllegalArgumentException e) {
                 System.out.println(e.getMessage());
             }
         }
     } catch (IOException e) {
         System.out.println("Erreur lors de la lecture du fichier: " + e.getMessage());
     }
 }
}
