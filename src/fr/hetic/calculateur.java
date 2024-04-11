package fr.hetic;

public class calculateur {
	public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Usage: java Calculateur <nombre1> <nombre2> <opérateur>");
            return;
        }


        double nombre1, nombre2;
        try {
            nombre1 = Double.parseDouble(args[0]);
            nombre2 = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Les deux premiers arguments doivent être des nombres.");
            return;
        }


        String operateur = args[2];
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
                System.out.println("Opérateur non valide. Utilisez '+', '-' ou '*'.");
                return;
        }


        System.out.println("Résultat de l'opération: " + resultat);
    }
}
