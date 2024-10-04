import java.util.ArrayList;

public class Jugador <E extends ItipoPieza> {
    private ArrayList<E> piezasVivas;

    public Jugador(ArrayList<E> piezas) {
        piezasVivas = piezas;
    }

    public ArrayList<E> getPiezasVivas() {
        return piezasVivas;
    }

    public void mourePeca(char col, int fila, char colDesti, int filaDesti) throws Exception { //hay que controlar errores
        if (buscarEnPosicion(filaDesti, colDesti) != null) {
            throw new Exception("A piece is already located in this position");
        }
        buscarEnPosicion(fila, col).setPosicion(filaDesti, colDesti);

    }

    private E buscarEnPosicion(int fil, int col) throws Exception {
        for (int i = 0; i < piezasVivas.size(); i++) {
            if (piezasVivas.get(i).getColumna() == col && piezasVivas.get(i).getFila() == fil) {

                return piezasVivas.get(i);//salimos del bucle
            }
        }
        throw new Exception("no pieces were found in this position");

    }

    public boolean eliminarPecaPosicio(int fila, char col) throws Exception {
        for (int i = 0; i < piezasVivas.size(); i++) {
            if (piezasVivas.get(i).getColumna() == col && piezasVivas.get(i).getFila() == fila) {
                piezasVivas.remove(i);
                return true;
            }

        }
        throw new Exception("no pieces were found in this position");
    }
}
