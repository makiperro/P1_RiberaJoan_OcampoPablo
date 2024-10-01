import java.util.ArrayList;

public class Jugador <E extends ItipoPieza>{
    private ArrayList<E> piezasVivas;

    public Jugador(ArrayList<E> piezas){
        piezasVivas = piezas;
    }
    public  void getPiezasVivas(ArrayList<E> piezas){

    }
    public void mourePeca(char col, int fila, char colDesti, int filaDesti) throws RuntimeException{

    }
    private E buscarEnPosicion(int fil, int col) {
        return null;
    }
    public boolean eliminarPecaPòsicio(int fila ,char col){
    return false;
    }
}
