import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Escacs<E> {
    public static void main(String[] args) throws Exception {
        while (true) {
            Pieza taulell[][] = new Pieza[9][9];
            Scanner myObj = new Scanner(System.in);
            String llegirTorn;
            int opcion = mostrarMenu();
            if (opcion == 3) {
                return;
            }
            Torns turnos;

            turnos = new Torns();
            Jugador jugadorNegre = new Jugador(jugarNovaPartida("IniciNegres.txt"));
            Jugador jugadorBlanc = new Jugador(jugarNovaPartida("IniciBlanques.txt"));

            taulell = guardarTaulell(jugadorNegre, jugadorBlanc, taulell);
            mostrarTauler(taulell);
            if (opcion == 1) {
                boolean success;
                try {
                    while (true) {
                        do {
                            success = true;
                            try {
                                System.out.print("Introdueix el torn del Blanc Exemple: A1 A4");
                                llegirTorn = myObj.nextLine();
                                tornToPosition(llegirTorn, jugadorBlanc, jugadorNegre, turnos, taulell);

                            } catch (IOException e) {
                                System.out.println("Error: " + e.getMessage());
                                success = false;
                            }
                        } while (!success);
                        do {
                            success = true;
                            try {

                                System.out.print("Introdueix el torn del Negre Exemple: A1 A4");
                                llegirTorn = myObj.nextLine();
                                tornToPosition(llegirTorn, jugadorNegre, jugadorBlanc, turnos, taulell);
                            } catch (IOException e) {
                                System.out.println("Error: " + e.getMessage());
                                success = false;
                            }
                        } while (!success);

                    }
                } catch (FiDeJocException e) {
                    System.out.println(e.getMessage());
                    System.out.println("introdueix nom fitxer per guardar la partida");
                    String nomFit = myObj.nextLine();
                    turnos.guardarAFitxer(nomFit);
                }
            } else if (opcion == 2) {
                try {
                    try {
                        reproduirPartida(myObj, jugadorBlanc, jugadorNegre, turnos, taulell);
                    } catch (JugadorBlancException e) {
                        while (true) {
                            System.out.print("Introdueix el torn del Blanc Exemple: A1 A4");
                            llegirTorn = myObj.nextLine();
                            tornToPosition(llegirTorn, jugadorBlanc, jugadorNegre, turnos, taulell);
                            System.out.print("Introdueix el torn del Negre Exemple: A1 A4");
                            llegirTorn = myObj.nextLine();
                            tornToPosition(llegirTorn, jugadorNegre, jugadorBlanc, turnos, taulell);

                        }
                    } catch (JugadorNegreException e) {
                        while (true) {
                            System.out.print("Introdueix el torn del Negre Exemple: A1 A4");
                            llegirTorn = myObj.nextLine();
                            tornToPosition(llegirTorn, jugadorNegre, jugadorBlanc, turnos, taulell);
                            System.out.print("Introdueix el torn del Blanc Exemple: A1 A4");
                            llegirTorn = myObj.nextLine();
                            tornToPosition(llegirTorn, jugadorBlanc, jugadorNegre, turnos, taulell);


                        }
                    }
                } catch (FiDeJocException e) {
                    System.out.println(e.getMessage());
                    System.out.println("introdueix nom fitxer per guardar la partida");
                    String nomFit = myObj.nextLine();
                    turnos.guardarAFitxer(nomFit);
                }
            }

        }
    }


    private static int mostrarMenu() {
        int value;
        do {
            Scanner myObj = new Scanner(System.in);
            System.out.println("**** Menú Principal ****");
            System.out.println("1. Jugar una partida nova");
            System.out.println("2. Reprodueix una partida des d'un fitxer");
            System.out.println("3. Sortir");
            System.out.println("Seleccioneu una opció: ");
            value = myObj.nextInt();
        } while (value != 1 && value != 2 && value != 3);
        return value;
    }

    private static void mostrarTauler(Pieza[][] taulell) {
        for (int i = 0; i < 9; i++) {
            if (i != 0) {
                System.out.print(i);
            }
            for (int j = 0; j < 9; j++) {
                if (taulell[i][j] == null) {
                    if (i == 0 && j != 0) {
                        System.out.print((char) (65 + j - 1));
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    System.out.print(taulell[i][j].toString());
                }
            }
            System.out.println();
        }
    }

    public static Pieza[][] guardarTaulell(Jugador jugadorNegre, Jugador jugadorBlanc, Pieza taulell[][]) {
        int fila;
        int columna;
        for (int i = 0; i < taulell.length; i++) {
            Arrays.fill(taulell[i], null);  // Efficient null filling
        }

        for (int i = 0; i < jugadorNegre.getPiezasVivas().toArray().length; i++) {

            if (jugadorNegre.getPiezasVivas().get(i) instanceof Pieza) {
                fila = ((Pieza) jugadorNegre.getPiezasVivas().get(i)).getFila();
                columna = ((Pieza) jugadorNegre.getPiezasVivas().get(i)).getColumna() - 65;

                taulell[fila][columna] = (Pieza) jugadorNegre.getPiezasVivas().get(i);
            }

        }
        for (int i = 0; i < jugadorBlanc.getPiezasVivas().toArray().length; i++) {
            fila = ((Pieza) jugadorBlanc.getPiezasVivas().get(i)).getFila();
            columna = ((Pieza) jugadorBlanc.getPiezasVivas().get(i)).getColumna() - 65;

            taulell[fila][columna] = (Pieza) jugadorBlanc.getPiezasVivas().get(i);
        }
        return taulell;
    }

    public static ArrayList jugarNovaPartida(String nomFitxer) throws Exception {
        ArrayList partidaInicial = new ArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader(nomFitxer))) {
            String line;
            while ((line = br.readLine()) != null) {
                partidaInicial.add(new Pieza(line.charAt(0), line.charAt(1) - 48, line.charAt(2)));
            }

            return partidaInicial;
        } catch (Exception e) {
            throw new Exception("no initial file was found");
        }
    }

    private static void reproduirPartida(Scanner myObj, Jugador p1, Jugador p2, Torns torns, Pieza[][] taulell) throws Exception {
        Torns turnos = llegirTrons(myObj);
        while (true) {
            try {
                tornToPosition((String) turnos.agafarPrimerTorn(), p1, p2, torns, taulell);
            } catch (Exception e) {
                throw new JugadorBlancException();
            }
            try {
                tornToPosition((String) turnos.agafarPrimerTorn(), p2, p1, torns, taulell);
            } catch (Exception e) {
                throw new JugadorNegreException();
            }

        }
    }

    private static Torns<String> llegirTrons(Scanner myObj) {

        System.out.println("introdueix nom de fitxer");
        String nomFitxer = myObj.nextLine();
        try {
            Torns<String> torns = new Torns(nomFitxer);
            return torns;
        } catch (Exception e) {
            return llegirTrons(myObj);
        }

    }

    private static void tornToPosition(String torn, Jugador p1, Jugador p2, Torns turnos, Pieza taulell[][]) throws Exception {
        System.out.println(torn);
        String torns[] = torn.split(" ");
        try {
            if (torns[0].equals(torns[1])) {
                throw new IOException("invalid coordenates");
            }


            p1.mourePeca(torns[0].charAt(0), torns[0].charAt(1) - 48, torns[1].charAt(0), torns[1].charAt(1) - 48);
            p2.eliminarPecaPosicio(torns[1].charAt(1) - 48, torns[1].charAt(0));
            turnos.afegirTorn(torn);
        } catch (FiDeJocException e) { // revisar en runeo
            turnos.afegirTorn(torn);
            throw new FiDeJocException();
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
        guardarTaulell(p1, p2, taulell);
        mostrarTauler(taulell);
    }
}

