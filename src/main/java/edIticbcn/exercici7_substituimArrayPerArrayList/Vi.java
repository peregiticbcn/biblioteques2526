package edIticbcn.exercici7_substituimArrayPerArrayList;

/**
 * A la primera versió de Vi ens podem trobar que creem un vi
 * amb un nom que no és vàlid, com ara "" o null, amb estoc negatiu,
 * o amb preu negatiu.
 *
 * Resulta difícil que la classe Vi pugui resoldre totes les situacions
 * que es poden donar. Per exemple, davant d'un estoc negatiu podríem inicialitzar l'estoc a zero.
 * Aquesta mena de solucions particulars, però, no sempre són les esperades per l'aplicació o aplicacions que
 * reutilitzen la classe que hem dissenyat.
 *
 * Per tant, la millor opció és que el nostre programa no permeti crear instàncies amb camps erronis i
 * que avisi de l'error al que ha intentat crear-la. Aquesta és la idea de les excepcions.
 *
 * Modifiqueu la classe anterior per tal que si hi ha algun argument incorrecte llanci l'excepció
 * IllegalArgumentException.
 * Centralitzeu el control de cada possible error en un sol punt (el constructor o el setter).
 *
 * Feu un programa que acabi correctament l'execució tot i intentar crear un vi amb nom null, un vi amb preu negatiu o
 * modificar a negatiu l'estoc d'un vi
 * La sortida ha de ser:
 * Error: nom no vàlid
 * Error: el preu no pot ser negatiu
 * Error: l'estoc no pot ser negatiu
 */
public class Vi {
    private String nom;
    private int preu;
    private int estoc=0; //per defecte 0

    public Vi(String nom, int preu, int estoc) {
        this(nom, preu);
        setEstoc(estoc);;
    }

    public Vi(String nom, int preu) {
        if (nom==null || nom.isBlank()) throw new IllegalArgumentException("Error: nom no vàlid");
        this.nom = nom;
        setPreu(preu);
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
        if (preu < 0) {
            throw new IllegalArgumentException("Error: el preu no pot ser negatiu");
        } else {
            this.preu = preu;
        }
    }

    public void setEstoc(int estoc) {

        if (estoc < 0 ) throw new IllegalArgumentException("Error: l'estoc no pot ser negatiu");
        this.estoc=estoc;
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
        edIticbcn.exercici5_BodegaMidaDinamica.Vi vi;
        try {
            vi = new edIticbcn.exercici5_BodegaMidaDinamica.Vi(null, 1000, 10);
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

        try {
            vi = new edIticbcn.exercici5_BodegaMidaDinamica.Vi("Marta", -10, 10);
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

        vi = new edIticbcn.exercici5_BodegaMidaDinamica.Vi( "Marta", 2000 );

        try {
            vi.setEstoc(-1);
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }



    }
}
