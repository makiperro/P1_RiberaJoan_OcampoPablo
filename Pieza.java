public class  Pieza implements ItipoPieza{
    public static final char PEON = 'P';
    public static final char CABALLO = 'C';
    public static final char ALPIL = 'A';
    public static final char TORRE = 'B';
    public static final char REINA = 'R';
    public static final char REY = 'K';

    private char col;
    private int fila;
    private char tipo;

    public Pieza(char col, int fila, char tipo) throws Exception {
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
    public char getColumna() {//error en el pdf, pone return tipo int y es un atributo tipo char
        return col;
    }

    @Override
    public void setPosicion(int fila, char columna) { // habra que controlar posiciones invalidas
    this.fila = fila;
    this.col = columna;
    }

    @Override
    public boolean fiJoc() {
        if(tipo == 'K') return true;
        return false;
    }

    private void checkTipo (char tipo) throws Exception{
    switch(tipo){
        case PEON: break;
        case CABALLO: break;
        case ALPIL: break;
        case TORRE: break;
        case REINA: break;
        case REY: break;
        default:
            throw new Exception("Tipo incorrecto");

    }
    }

    public String toString() {//idk de lo que hay que printear aqui
        return "";
    }

    @Override
    public boolean equals(Object obj) {//quiza hay que comparar dos piezas??
        return super.equals(obj);
    }
}
