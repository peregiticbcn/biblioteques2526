package edIticbcn.exercici1;

/**
 * Vi: versió 1
 * nom: String (no es pot canviar)
 * preu (enter)
 * estoc (enter) (per defecte 0) ==> dos constructors un amb estoc i l'altre sense
 * Mètodes:
 * Constructors
 * Getters i setters necessaris
 * Un to string
 * Observacions:
 * com que no hi ha excepcions, de moment considerem que tots els arguments són vàlids
 *
 * Feu un main per fer proves que crei un vector amb 3 vins i els mostri per pantalla.
 * Un dels vins que es creen ha de fer servir el constructor sense estoc.
 */
public class Vi {
    private String nom;
    private int preu;
    private int estoc;

    public Vi(String nom, int preu, int estoc) {
        this.nom = nom;
        this.preu = preu;
        this.estoc = estoc;
    }

    public Vi(String nom, int preu) {
        this.nom = nom;
        this.preu = preu;
    }

    public String getNom() {
        return nom;
    }

    public int getPreu() {
        return preu;
    }

    public int getEstoc() {
        return estoc;
    }

    public void setPreu(int preu) {
        this.preu = preu;
    }

    public void setEstoc(int estoc) {
        this.estoc = estoc;
    }

    @Override
    public String toString() {
        return "Vi{" +
                "nom='" + nom + '\'' +
                ", preu=" + preu +
                ", estoc=" + estoc +
                '}';
    }

    public static void main(String[] args) {
        Vi[] vins = new Vi[3];
        vins[0] = new Vi("Anima", 1000, 10);
        vins[1] = new Vi( "Marta", 2000 );
        vins[2] = new Vi("BenBo", 3000, 10);

        for(int i=0; i<vins.length; i++){
            System.out.println(vins[i]);
        }
    }
}
