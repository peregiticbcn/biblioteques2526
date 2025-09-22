package edIticbcn.exercici13_aixoVaLent_introduccioALaComplexitat;

public class TestAfegirMoltsVins {

    private static final int LONGITUD = 100_000;

    public static void main(String[] args) {
        Bodega bodega = new Bodega();

        long tempsInicial = System.nanoTime();
        for(int i=0; i<LONGITUD; i++){
            bodega.afegeix(new Vi(""+ i, 10, 10));
        }
        System.out.println(System.nanoTime() - tempsInicial);


    }

}
