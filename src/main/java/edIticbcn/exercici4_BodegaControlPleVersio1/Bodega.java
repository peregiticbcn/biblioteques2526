package edIticbcn.exercici4_BodegaControlPleVersio1;


/**
 * Quan fem un programa és positiu pensar que no l'estem fent només per nosaltres, sinó per a tot l'equip amb qui
 * treballem o, fins i tot, per altres programadors que les reutilitzaran. Per tant, no hem de veure Botiga
 * com una simple classe per a la nostra aplicació, sinó com a integrant d'una biblioteca de classes que més endavant
 * podrem reutilitzar o fer pública. És per això que cal tractar amb molta atenció les decisions de disseny que prenem
 * per resoldre, no fos cas que més endavant ens generi molts problemes. Penseu que el programador que reutilitza el
 * codi no té per què mirar aquest codi i es basarà només en la documentació (bàsicament la signatura de la funsió).
 *
 *
 *
 * A la versió anterior de Bodega hem pres algunes decisions sobre com tractem casos critics. Altres situacions, però,
 * no les hem tingut en compte i poden produir problemes a la nostra aplicació o en un futur. Per exemple
 *
 * DECISIÓ 1: que fa el nostre programa quan afegim un vi i està duplicat?
 * RESPOSTA 1: No l'afegeix i retorna null. Notem que, a banda del nom, la resta de valors del vi, per exemple l'estoc,
 * no tenen en compte.
 * Notem que:
 * 1-. el programador que fa servir o reutilitza la biblioteca Bodega està informat que pot retornar null
 * 2-. haurà de prendre les decisions que calgui per a controlar que no s'accedeixi a null produint una excepció
 *
 *  Decisions semblants (retornar vi null) les hem près
 *  1-. Si acedim a un Vi d'index no exitent
 *  2-. Esborrem esborrar un vi que no hi és
 *  Per tant, aquestes situacions estan ben informades i es poden gestionar
 *
 * DECISIÓ 2: Què fa el nostre codi quan afegim un Vi i la Bodega està plena?
 *
 * RESPOSTA 2: El programa llança l'excepció ArrayIndexOutOfBoundsException i, si no es captura, avortarà el programa.
 * En aquest cas, el programador que reutilitza aquest codi, a banda dels comentaris a la documentació, no té per què
 * ser conscient que es pot donar aquest error. Probablement, ho detectarà amb un bon test de prova. Però, i si no ho fa?
 * De fet, tots els accessos a un array poden provocar ArrayIndexOutOfBoundsException. Els hem de controlar tots?
 * D'altra banda, el programador que reutilitzi el codi no hauria de tenir informació de l'estructura interna (és a dir,
 * no té per què saber que els vins a la botiga es guarden en un array. Encapsulament i ocultació d'informació)
 *
 * En aquest exercici practicarem un principi no escrit important:
 * No és suficient informar d'un possible error a la documentació, si es pot produir un error cal forçar a què es solucioni.
 *
 * Excepció gestionada.
 * Una forma de forçar-ho és llançant una Excepció Gestionada.
 *
 * Explicació excepcions ...
 *
 * ACTIVITAT: afegeix amb excepció gestionada
 * Modifiqueu afegeix de manera que si la botiga està plena llanci l'excepció BodegaPlenaExcepcion
 * Modifiqueu el main per a què quan afegim el 4rt vi el programa mostri el missatge "Bodega plena:
 * vi ***Descripcio del vi*** no afegit" i
 * continui amb l'execució.
 *
 *
 *
 */

public class Bodega {
    public static int DEFAULT_MAX_VINS = 10;

    private Vi[] vins; //vins.length indicarà el màxim de vins
    private int nVins = 0; //necessitem un comptador per saber quants vins hi ha

    public Bodega(int mida){
        vins = new Vi[mida];
    }

    public Bodega() {
        this(DEFAULT_MAX_VINS);
    }

    public int indexDe(Vi vi){
        //nom = StringUtils.normatitza(nom);
        for(int i=0; i<nVins; i++){
            if (vins[i].getNom().equals(vi.getNom())){
                return i;
            }
        }
        return -1;
    }

    public boolean conteVi(Vi vi){
        return indexDe(vi)!=-1;
    }

    public Vi get(int index){
        if (index <0 || index >= nVins){
            return null;
        }

        return vins[index];
    }

    public Vi afegeix(Vi vi) throws BodegaPlenaException {

        if (conteVi(vi)){ //està repetit
            return null;
        }
        if (nVins == vins.length){
            throw new BodegaPlenaException("Bodega plena: vi " + vi.toString() + " no afegit");
        }
        vins[nVins++]=vi;
        return vi;
    }

    public Vi elimina(Vi vi){
        int index = indexDe(vi);
        if (index == -1){
            return null;
        }
        //desplaçar els vins
        vi = vins[index];
        for(int i=index; i<nVins; i++){
            vins[i]=vins[i+1];
        }
        nVins--;
        return vi;
    }

    public int mida() {
        return nVins;
    }

    public static void main(String[] args) {
        Bodega bodega = new Bodega(3);
        try {
            bodega.afegeix(new Vi("ViBo", 1000, 10));
        } catch (BodegaPlenaException e) {
            System.out.println(e.getMessage());
        }
        try {
            bodega.afegeix(new Vi("Segon", 2000, 202));
        } catch (BodegaPlenaException e) {
            System.out.println(e.getMessage());
        }
        try {
            bodega.afegeix(new Vi("tres", 3000));
        } catch (BodegaPlenaException e) {
            System.out.println(e.getMessage());
        }
        try {
            bodega.afegeix(new Vi("quatre", 300)); //no afegeix duplicat
        } catch (BodegaPlenaException e) {
            System.out.println(e.getMessage());
        }
        int mida = bodega.mida();

        for(int i=0; i<mida; i++){
            System.out.println(bodega.get(i));
        }


    }

}
