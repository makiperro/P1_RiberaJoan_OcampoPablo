import java.io.IOException;
import java.util.*;
import java.lang.Object;
import java.io.*;
public class Torns <E>{
    private ArrayList<E> llistaTorns;

    public Torns(){
        llistaTorns = new ArrayList();
    }
    public Torns(String nomFitxer) throws Exception{
        carregarDesdeFitxer(nomFitxer);
    }

    public void afegirTorn(E torn){
    llistaTorns.add(torn);
    }

    public E agafarPrimerTorn(){
        E torn = llistaTorns.get(0);
        llistaTorns.remove(0);
        return torn;
    }

    public void guardarAFitxer(String nomFitxer) throws IOException {

    }

    private void carregarDesdeFitxer(String nomFitxer) throws Exception{
        llistaTorns = new ArrayList();
        try(BufferedReader br = new BufferedReader(new FileReader(nomFitxer))){
            String line;
            while((line = br.readLine())!=null){
            llistaTorns.add(line);
            }
            catch(Exception){
                throw new Exception();
            }
        }
    }

    public void imprimirTorns(){

    }

}
