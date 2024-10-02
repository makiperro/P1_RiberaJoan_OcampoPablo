public interface ItipoPieza {
    public abstract char getTipus();
    public abstract int getFila();
    public abstract int getColumna();
    public abstract void setPosicion(int fila, char columna) throws Exception;
    public abstract boolean fiJoc();
}
