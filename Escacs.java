/*import java.util.Scanner;
import java.util.ArrayList;
public class Escacs {
    public static void main(String[] args) {
        String taulell[][] =  new String[9][9];
        Scanner myObj = new Scanner(System.in);
        String aux;

        System.out.println("**** Menú Principal ****");
        System.out.println("1. Jugar una partida nova");
        System.out.println("2. Reprodueix una partida des d'un fitxer");
        System.out.println("3. Sortir");
        System.out.println("Seleccioneu una opció: ");
        int opcion = myObj.nextInt();

        if(opcion == 1) {

            Jugador jugadorBlanc = new Jugador<>();
            Jugador jugadorNegre = new Jugador<>();
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    if(i==0&&j!=0) {
                        System.out.print(Character.toString((char) 64+j));
                    }
                    else if(taulell[i][j]!=null) {
                        System.out.print(taulell[i][j]);
                    }
                    else if(j==0&&i==0) {
                        System.out.print(" ");
                    }

                    }


                System.out.println();
                }
            }
        }

       public void imprimirTaulell (String [][]taulell){
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(taulell[i][j]);
            }
        }
       }
       public ArrayList

    }


*/