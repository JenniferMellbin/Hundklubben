public class Medlem {

    private String namn;
    private String hundNamn;
    private String hundRas;
    private boolean harBetalat;

    public Medlem(String namn, String hundNamn, String hundRas) {
        this.namn = namn;
        this.hundNamn = hundNamn;
        this.hundRas = hundRas;
        this.harBetalat = false;
    }
    public String getNamn() {
        return namn;
    }

    public String getHundNamn() {
        return hundNamn;
    }

    public String getHundRas() {
        return hundRas;
    }

    public boolean isHarBetalat() {
        return harBetalat;
    }
    public void registreraBetalning() {
        this.harBetalat = true;
    }
}
