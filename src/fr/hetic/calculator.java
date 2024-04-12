package fr.hetic;

public class calculator {
	  public static void main(String[] args) {
	        if (args.length != 1) {
	            System.out.println("Usage: java Calculateur <nomFichier>");
	            return;
	        }

	        String fileName = args[0];
	        FileProcessor fileProcessor = new FileProcessor();
	        fileProcessor.processFile(fileName, (String line) -> {
	            // Votre traitement de chaque ligne ici
	        });

	    }

	    public static double calculer(double nombre1, double nombre2, String operateur) {
	        double resultat;
	        switch (operateur) {
	            case "+":
	                resultat = nombre1 + nombre2;
	                break;
	            case "-":
	                resultat = nombre1 - nombre2;
	                break;
	            case "*":
	                resultat = nombre1 * nombre2;
	                break;
	            default:
	                throw new IllegalArgumentException("Opérateur non valide. Utilisez '+', '-' ou '*'.");
	        }
	        return resultat;
	    }
}
