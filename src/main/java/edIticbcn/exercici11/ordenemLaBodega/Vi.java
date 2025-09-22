package edIticbcn.exercici11.ordenemLaBodega;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vi vi)) return false;
        return nom.equalsIgnoreCase(vi.nom);
    }


}