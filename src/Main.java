
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Register register = new Register();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Välkommen till Hundklubben!");

        while (true) {
            System.out.println("===== HUNDKLUBBEN =====");
            System.out.println("1. Registrera ny medlem");
            System.out.println("2. Visa alla medlemmar");
            System.out.println("3. Registrera betalning");
            System.out.println("4. Avsluta");
            System.out.print("Välj ett alternativ: ");

            int val = scanner.nextInt();
            switch (val) {
                case 1:
                    System.out.print("Ange medlemmens namn: ");
                    String namn = scanner.next();
                    System.out.print("Ange hundens namn: ");
                    String hundNamn = scanner.next();
                    System.out.print("Ange hundens ras: ");
                    String hundRas = scanner.next();
                    Medlem medlem = new Medlem(namn, hundNamn, hundRas);
                    register.laggTillMedlem(medlem);
                    break;

                case 2:
                    register.listaMedlemmar();
                    break;

                case 3:
                    System.out.print("Ange namnet på medlemmen som har betalat: ");
                    String betalNamn = scanner.next();

                    register.registreraBetalning(betalNamn);
                    break;

                case 4:
                    System.out.println("Programmet avslutas.");
                    return;

                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }
        }
    }
}