public class  Pieza implements ItipoPieza{
    public static final char PEON = 'P';
    public static final char CABALLERO = 'C';
    public static final char ALPIL = 'A';
    public static final char TORRE = 'T';
    public static final char REINA = 'R';
    public static final char REY = 'K';

    private char col;
    private int fila;
    private char tipo;

    public Pieza(char tipo, int fila, char col) throws Exception {
        this.col = col;
        this.fila = fila;
        checkTipo(tipo);
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
    public int getColumna() {//error en el pdf, pone return tipo int y es un atributo tipo char
        return (int) col;
    }

    @Override
    public void setPosicion(int fila, char columna) throws Exception{ // habra que controlar posiciones invalidas
    if(fila>=9 || columna< 41 || columna > 48){
        throw new Exception("Posicion incorrecta");
    }
        this.fila = fila;   // del 0-7
        this.col = columna; // del A-H
    }

    @Override
    public boolean fiJoc() {
        if(tipo == 'K') return true;
        return false;
    }

    private void checkTipo (char tipo) throws Exception{
    switch(tipo){
        case PEON: break;
        case CABALLERO: break;
        case ALPIL: break;
        case TORRE: break;
        case REINA: break;
        case REY: break;
        default:
            throw new Exception("Tipo incorrecto");

    }
    }

    public String toString() {//idk de lo que hay que printear aqui
        return String.valueOf(tipo);
    }

    @Override
    public boolean equals(Object obj) {//quiza hay que comparar dos piezas??
        return super.equals(obj);
    }
}
