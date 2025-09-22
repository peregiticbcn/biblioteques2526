package edIticbcn.exercici13_aixoVaLent_introduccióALaComplexitat;

public class TestAfegirMoltsVinsTreeSet {

    private static final int LONGITUD = 10_000_000;

    public static void main(String[] args) {
        BodegaSet bodega = new BodegaSet();

        long tempsInicial = System.nanoTime();
        for(int i=0; i<LONGITUD; i++){
            bodega.afegeix(new Vi(""+ i, 10, 10));
        }
        System.out.println(System.nanoTime() - tempsInicial);


    }

}
