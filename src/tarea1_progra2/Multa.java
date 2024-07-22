package tarea1_progra2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class Multa {
    private int codigo;
    private String nombreInfractor;
    private String tipo;
    private double montoPagar;
    private boolean pagada;

    public static final double TIPO_GRAVE = 3000.0;
    public static final double TIPO_MEDIO = 1500.0;
    public static final double TIPO_LEVE = 500.0;

    public Multa(int codigo, String nombreInfractor, String tipo) {
        this.codigo = codigo;
        this.nombreInfractor = nombreInfractor;
        this.pagada = false;

        if (tipo.equalsIgnoreCase("GRAVE")) {
            this.tipo = "GRAVE";
            this.montoPagar = TIPO_GRAVE;
        } else if (tipo.equalsIgnoreCase("MEDIO")) {
            this.tipo = "MEDIO";
            this.montoPagar = TIPO_MEDIO;
        } else {
            this.tipo = "LEVE";
            this.montoPagar = TIPO_LEVE;
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public double getMontoPagar() {
        return montoPagar;
    }

    public boolean isPagada() {
        return pagada;
    }

    public String print() {
        return "Código: " + codigo + "\nNombre del infractor: " + nombreInfractor + "\nTipo de multa: " + tipo +
               "\nMonto a pagar: Lps. " + montoPagar + "\n" + (pagada ? "Pagada por un monto de Lps. " + montoPagar : "Multa pendiente") + "\n";
    }

    public void pay() {
        this.pagada = true;
        System.out.println("Multa con Código " + codigo + " fue pagada por un monto de Lps. " + montoPagar);
    }
}