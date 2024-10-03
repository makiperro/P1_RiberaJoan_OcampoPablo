import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Array;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class Escacs <E> {
    public static void main(String[] args) throws Exception {
        Pieza taulell[][] =  new Pieza[9][9];
        Scanner myObj = new Scanner(System.in);
        int opcion = mostrarMenu();
        if(opcion == 1) {

            Jugador jugadorNegre = new Jugador(jugarNovaPartida("C://Users//juan_//Desktop//prog av//P1_RiberaJoan_OcampoPablo//IniciNegres.txt"));
            Jugador jugadorBlanc = new Jugador(jugarNovaPartida("C://Users//juan_//Desktop//prog av//P1_RiberaJoan_OcampoPablo//IniciBlanques.txt"));

            int fila;
            int columna;
            for(int i = 0; i < jugadorNegre.getPiezasVivas().toArray().length; i++) {//hay que limpiar esto de alguna manera

                    if(jugadorNegre.getPiezasVivas().get(i) instanceof Pieza) {
                        fila =((Pieza) jugadorNegre.getPiezasVivas().get(i)).getFila();
                        columna = (int) ((Pieza) jugadorNegre.getPiezasVivas().get(i)).getColumna() -64;

                        taulell[fila][columna] = (Pieza) jugadorNegre.getPiezasVivas().get(i);

                        fila =((Pieza) jugadorBlanc.getPiezasVivas().get(i)).getFila();
                        columna = (int) ((Pieza) jugadorBlanc.getPiezasVivas().get(i)).getColumna()-64 ;

                        taulell[fila][columna] = (Pieza) jugadorBlanc.getPiezasVivas().get(i);
                }
            }
            mostrarTauler(taulell);
        }
    }


        private static int mostrarMenu(){
            Scanner myObj = new Scanner(System.in);
            System.out.println("**** Menú Principal ****");
            System.out.println("1. Jugar una partida nova");
            System.out.println("2. Reprodueix una partida des d'un fitxer");
            System.out.println("3. Sortir");
            System.out.println("Seleccioneu una opció: ");
            return myObj.nextInt();
        }

        private static void mostrarTauler(Pieza[][] taulell){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(taulell[i][j] == null){
                    System.out.print(" ");
                }
                else {
                    System.out.print(taulell[i][j].toString());
                }
            }
            System.out.println();
        }
        }

       public static ArrayList jugarNovaPartida(String nomFitxer)throws Exception{
          ArrayList llistaTorns = new ArrayList();

           try(BufferedReader br = new BufferedReader(new FileReader(nomFitxer))){
               String line;
               while((line = br.readLine())!=null){
                   llistaTorns.add( new Pieza(line.charAt(0),line.charAt(1)-48,line.charAt(2)));
                   }

               return llistaTorns;
           }
           catch(Exception e){
               throw new Exception("no initial file was found");
           }
       }

       private static void reproduirPartida(){

       }

       private static Torns<String> llegirTrons(){
        return null;
       }

       private static void tornToPosition(){


       }




    }

