/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1_progra2;

/**
 *
 * @author Administrator
 */
public class Transito {
    private Multa[] multas;
    private int contador;

    public Transito() {
        this.multas = new Multa[100];
        this.contador = 0;
    }

    public Multa buscarMultaPorCodigo(int codigo) {
        for (int i = 0; i < contador; i++) {
            if (multas[i].getCodigo() == codigo) {
                return multas[i];
            }
        }
        return null;
    }

    public void agregarMulta(int codigo, String nombre, String tipo) {
        if (contador >= multas.length) {
            System.out.println("No hay espacio para agregar más multas.");
            return;
        }
        if (buscarMultaPorCodigo(codigo) != null) {
            System.out.println("El código de la multa ya existe.");
            return;
        }
        multas[contador] = new Multa(codigo, nombre, tipo);
        contador++;
    }

    public void pagarMulta(int codigo) {
        Multa multa = buscarMultaPorCodigo(codigo);
        if (multa == null) {
            System.out.println("No existe una multa con ese código.");
            return;
        }
        multa.pay();
    }

    public String imprimirMultas() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contador; i++) {
            sb.append(multas[i].print()).append("\n");
        }
        return sb.toString();
    }

    public String imprimirInformacion() {
        int pagadas = 0;
        double montoPagadas = 0;
        int pendientes = 0;
        double montoPendientes = 0;

        for (int i = 0; i < contador; i++) {
            if (multas[i].isPagada()) {
                pagadas++;
                montoPagadas += multas[i].getMontoPagar();
            } else {
                pendientes++;
                montoPendientes += multas[i].getMontoPagar();
            }
        }

        return "Cantidad de Multas generadas: " + contador + "\n" +
               "Cantidad de Multas Pagadas: " + pagadas + " con un monto de Lps. " + montoPagadas + "\n" +
               "Cantidad de Multas pendientes de pagar: " + pendientes + " con un monto de Lps. " + montoPendientes + "\n";
    }
}