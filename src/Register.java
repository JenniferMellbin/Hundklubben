import java.util.ArrayList;
import java.util.List;

public class Register {

    private List<Medlem> medlemmar = new ArrayList<>();

    public void laggTillMedlem(Medlem medlem) {
        medlemmar.add(medlem);
        System.out.println("Medlem registrerad: " + medlem.getNamn());
    }

    public void listaMedlemmar() {
        if (medlemmar.isEmpty()) {
            System.out.println("Det finns inga registrerade medlemmar.");
        } else {
            for (Medlem m : medlemmar) {
                System.out.println("Medlem: " + m.getNamn());
                System.out.println("Hund: " + m.getHundNamn());
                System.out.println("Ras: " + m.getHundRas());

                if (m.isHarBetalat()) {
                    System.out.println("Medlemsavgift: BETALD");
                } else {
                    System.out.println("Medlemsavgift: OBETALD");
                }

                System.out.println("--------------------");
            }
        }
    }
        public void registreraBetalning (String namn){
            for (Medlem m : medlemmar) {
                if (m.getNamn().equalsIgnoreCase(namn)) {
                    if (m.isHarBetalat()) {
                        System.out.println("Medlemmen har redan betalat.");
                    } else {
                        m.registreraBetalning();
                        System.out.println("Betalning registrerad för " + m.getNamn());
                    }
                    return;
                }
            }

            System.out.println("Ingen medlem med namnet " + namn + " hittades.");
        }
    }

