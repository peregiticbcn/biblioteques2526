package edIticbcn.exercici11.ordenemLaBodega;

public class UsaBodega {
    public static void main(String[] args) {
        Bodega bodega = new Bodega();
        bodega.afegeix(new Vi("Comiat", 3000, 1));
        bodega.afegeix(new Vi("Ramon", 2000, 2));
        bodega.afegeix(new Vi("Maria", 4000, 2));
        bodega.afegeix(new Vi("Sospirs", 3000, 4));
        bodega.mostra();
        System.out.println("Ordenem ordre natural");
        bodega.ordena();
        bodega.mostra();
        System.out.println("Ordenem per estoc decreixent");
        bodega.ordenaPerEstocDecreixent();
        bodega.mostra();
        System.out.println("Ordenem per preu creixent i estoc decreixent");
        bodega.ordenaPerPreuCreixentIEstocDecreixent();
        bodega.mostra();


    }
}
