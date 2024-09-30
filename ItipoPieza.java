public interface ItipoPieza {
    public abstract char getTipus();
    public abstract int getFila();
    public abstract char getColumna();
    public abstract void setPosicion(int fila, char columna) throws Exception;
    public abstract boolean fiJoc();
}
