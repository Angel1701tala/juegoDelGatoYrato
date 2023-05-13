package gatoRaton;

import java.util.Scanner;

public class GatoYRaton {
    private static final char VACIO = ' ';
    private static final char RATON = 'R';
    private static final char GATO = 'G';
    private static final char QUESO = 'Q';

    private static final int TAMANO_TABLERO = 3;
    private static final int PARTIDAS_GANADORAS = 2;

    private char[][] tablero;
    private char jugadorActual;
    private int partidasGanadasJugador;
    private int partidasGanadasMaquina;

    public GatoYRaton() {
        tablero = new char[TAMANO_TABLERO][TAMANO_TABLERO];
        jugadorActual = RATON;
        partidasGanadasJugador = 0;
        partidasGanadasMaquina = 0;
        reiniciarTablero();
    }

    public void iniciarJuego() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Quién inicia? (1 - Jugador / 2 - Máquina): ");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            jugadorActual = RATON;
            System.out.println("Empiezas como el ratón (R).");
        } else {
            jugadorActual = GATO;
            System.out.println("La máquina empieza como el gato (G).");
        }

        while (partidasGanadasJugador < PARTIDAS_GANADORAS && partidasGanadasMaquina < PARTIDAS_GANADORAS) {
            System.out.println("\n¡Comienza una nueva partida!");
            reiniciarTablero();
            imprimirTablero();

            while (!juegoTerminado()) {
                if (jugadorActual == RATON) {
                    turnoJugador();
                } else {
                    turnoMaquina();
                }
                imprimirTablero();
                cambiarTurno();
            }

            char ganador = determinarGanador();
            if (ganador == RATON) {
                System.out.println("\n¡El ratón (R) ha ganado la partida!");
                partidasGanadasJugador++;
            } else if (ganador == GATO) {
                System.out.println("\n¡El gato (G) ha ganado la partida!");
                partidasGanadasMaquina++;
            } else {
                System.out.println("\n¡La partida ha terminado en empate!");
            }

            System.out.println("Puntuación:");
            System.out.println("Jugador (R): " + partidasGanadasJugador);
            System.out.println("Máquina (G): " + partidasGanadasMaquina);
        }

        if (partidasGanadasJugador == PARTIDAS_GANADORAS) {
            System.out.println("\n¡Has ganado!");
        } else {
            System.out.println("\n¡La máquina ha ganado!");
        }
    }

    private void reiniciarTablero() {
        for (int i = 0; i < TAMANO_TABLERO; i++) {
            for (int j = 0; j < TAMANO_TABLERO; j++) {
                tablero[i][j] = V

