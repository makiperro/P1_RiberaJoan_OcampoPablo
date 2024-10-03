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
        llistaTorns = new ArrayList();
        carregarDesdeFitxer(nomFitxer);
    }

    public void afegirTorn(E torn){
    llistaTorns.add(torn);
    }

    public E agafarPrimerTorn() throws NoSuchElementException{ //to be tested
        if(llistaTorns.isEmpty()){
            throw new NoSuchElementException();
        }
        E torn = llistaTorns.get(0);
        llistaTorns.remove(0);
        return torn;
    }

    public void guardarAFitxer(String nomFitxer) throws IOException { //to be tested
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFitxer, true))){
            for(int i=0; i<llistaTorns.size(); i++){
                writer.write((String)llistaTorns.get(i)+"\n");
            }
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    private void carregarDesdeFitxer(String nomFitxer) throws Exception{ //to be tested

        try(BufferedReader br = new BufferedReader(new FileReader(nomFitxer))){
            String line;

            while((line = br.readLine())!=null){
                afegirTorn((E) line);
                }
            }
        catch(Exception e){
                throw new Exception();
            }
        }
    }





