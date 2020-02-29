package TiradaMoneda;

import java.util.Scanner;

public class TiradaMonedaCX {

    public static void main(String[] args) {
//las variables result_primera_tirada y result_segunda_tirada servirán para guardar el resultado de la tirada de dos monedas
        int result_primera_tirada, result_segunda_tirada;
        int contadorCaras = 0, contadorCruces = 0, numTiradas;
//las variables contador1 y contador2 servirán para guardar el número de caras y cruces dobles consecutivas
        int cont1 = 0, cont2 = 0;
        int maximoCarasDoblesConsecutivas = 0, maximoCrucesDoblesConsecutivas = 0;
        boolean esCruzDoble = false, esCaraDoble = false;
        String tirada1;
        String tirada2;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.print("Introduce el número de veces que se van a lanzar las monedas (max 50): ");
            numTiradas = teclado.nextInt();
        } while (numTiradas < 1 || numTiradas > 50);

        for (int i = 0; i < numTiradas; i++) {
            result_primera_tirada = (int) (Math.random() * 2);
            result_segunda_tirada = (int) (Math.random() * 2);

            if (result_primera_tirada == 0) {
                contadorCaras++;
                tirada1 = "cara";
            } else {
                contadorCruces++;
                tirada1 = "cruz";
            }
            if (result_segunda_tirada == 0) {
                contadorCaras++;
                tirada2 = "cara";
            } else {
                contadorCruces++;
                tirada2 = "cruz";
            }
            System.out.println("Moneda 1: " + tirada1 + ", Moneda 2: " + tirada2);

            if (result_primera_tirada == result_segunda_tirada) {
                if (result_primera_tirada == 0) {
                    esCaraDoble = true;
                    esCruzDoble = false;
                } else {
                    esCaraDoble = false;
                    esCruzDoble = true;
                }
            } else {
                esCaraDoble = false;
                esCruzDoble = false;
            }

            if (esCaraDoble) {
                cont1++;
                if (cont1 > maximoCarasDoblesConsecutivas) {
                    maximoCarasDoblesConsecutivas = cont1;
                }
            } else {
                cont1 = 0;
            }

            if (esCruzDoble) {
                cont2++;
                if (cont2 > maximoCrucesDoblesConsecutivas) {
                    maximoCrucesDoblesConsecutivas = cont2;
                }
            } else {
                cont2 = 0;
            }
        }

        imprimir(contadorCaras, contadorCruces, maximoCarasDoblesConsecutivas, maximoCrucesDoblesConsecutivas);
    }

    public static void imprimir(int contadorCaras, int contadorCruces, int maximoCarasDoblesConsecutivas, int maximoCrucesDoblesConsecutivas) {
        System.out.println("Caras: " + contadorCaras + ", Cruces: " + contadorCruces);
        System.out.println("Maximo de caras dobles consecutivas: " + maximoCarasDoblesConsecutivas);
        System.out.println("Maximo de cruces dobles consecutivas: " + maximoCrucesDoblesConsecutivas);
    }
}
