public class Pieza implements ItipoPieza{
    public static final char PEON = 'P';
    public static final char CABALLO = 'C';
    public static final char ALPIL = 'A';
    public static final char TORRE = 'B';
    public static final char REINA = 'R';
    public static final char REY = 'K';

    private char col;
    private int fila;
    private char tipo;

    public Pieza(char col, int fila, char tipo) {
        this.col = col;
        this.fila = fila;
        this.tipo = tipo;
    }
    @Override
    public char getTipus() {
        return tipo;
    }

    @Override
    public int getFila() {
        return fila;
    }

    @Override
    public char getColumna() {//error en el pdf, pone return tipo int y es un atributo tipo char
        return col;
    }

    @Override
    public void setPosicion(int fila, char columna) { // no se si habra que controlar posiciones invalidas
    this.fila = fila;
    this.col = columna;
    }

    @Override
    public boolean fiJoc() {
        return false;
    }
}
