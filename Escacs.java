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
        Torns turnos;
        if(opcion == 1) {
            turnos = new Torns();
            Jugador jugadorNegre = new Jugador(jugarNovaPartida("C://Users//juan_//Desktop//prog av//P1_RiberaJoan_OcampoPablo//IniciNegres.txt"));
            Jugador jugadorBlanc = new Jugador(jugarNovaPartida("C://Users//juan_//Desktop//prog av//P1_RiberaJoan_OcampoPablo//IniciBlanques.txt"));

            taulell = guardarTaulell(jugadorNegre,jugadorBlanc,taulell);
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
        System.out.print(" ");
        for(int i = 0; i < 9; i++){
            if(i !=0){
                System.out.print(i);
            }
            for(int j = 0; j < 9; j++){
                if(taulell[i][j] == null){
                    if(i==0 && j!=0){
                        System.out.print((char)(65+j-1));
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                else {
                    System.out.print(taulell[i][j].toString());
                }
            }
            System.out.println();
        }
        }

        public static Pieza[][] guardarTaulell(Jugador jugadorNegre, Jugador jugadorBlanc, Pieza taulell[][]){
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
            return taulell;
        }

       public static ArrayList jugarNovaPartida(String nomFitxer)throws Exception{
          ArrayList partidaInicial = new ArrayList();

           try(BufferedReader br = new BufferedReader(new FileReader(nomFitxer))){
               String line;
               while((line = br.readLine())!=null){
                   partidaInicial.add( new Pieza(line.charAt(0),line.charAt(1)-48,line.charAt(2)));
                   }

               return partidaInicial;
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

       private static void tornToPosition(String torn, Jugador p1, Jugador p2) throws Exception { //to be tested
        String torns[] = torn.split(" ");
        if(torns[0].equals(torns[1])){
            p2.eliminarPecaPosicio(torns[1].charAt(1),torns[1].charAt(0));
            p1.mourePeca(torns[0].charAt(0), torns[0].charAt(1),torns[1].charAt(0),torns[1].charAt(1));
        }
        else{
            p1.mourePeca(torns[0].charAt(0), torns[0].charAt(1),torns[1].charAt(0),torns[1].charAt(1));

        }

       }




    }

