package fr.hetic;

public class calculateur {
	public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Calculateur <nomFichier>");
            return;
        }

        String fileName = args[0];
        TraitementFichiers fileProcessor = new TraitementFichiers();
        fileProcessor.processFile(fileName);
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
