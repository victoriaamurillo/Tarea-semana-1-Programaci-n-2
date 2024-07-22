/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1_progra2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Administrator
 */


public class Main {
    private static Transito transito = new Transito();
    private static JTextArea displayArea;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Tránsito");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel codigoLabel = new JLabel("Código");
        codigoLabel.setBounds(10, 20, 80, 25);
        panel.add(codigoLabel);

        JTextField codigoText = new JTextField(20);
        codigoText.setBounds(100, 20, 165, 25);
        panel.add(codigoText);

        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setBounds(10, 50, 80, 25);
        panel.add(nombreLabel);

        JTextField nombreText = new JTextField(20);
        nombreText.setBounds(100, 50, 165, 25);
        panel.add(nombreText);

        JLabel tipoLabel = new JLabel("Tipo");
        tipoLabel.setBounds(10, 80, 80, 25);
        panel.add(tipoLabel);

        JTextField tipoText = new JTextField(20);
        tipoText.setBounds(100, 80, 165, 25);
        panel.add(tipoText);

        JButton agregarButton = new JButton("Agregar Multa");
        agregarButton.setBounds(10, 110, 150, 25);
        panel.add(agregarButton);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(codigoText.getText());
                String nombre = nombreText.getText();
                String tipo = tipoText.getText();
                transito.agregarMulta(codigo, nombre, tipo);
                updateDisplay();
            }
        });

        JButton pagarButton = new JButton("Pagar Multa");
        pagarButton.setBounds(10, 140, 150, 25);
        panel.add(pagarButton);
        pagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(codigoText.getText());
                transito.pagarMulta(codigo);
                updateDisplay();
            }
        });

        JButton imprimirButton = new JButton("Imprimir Multas");
        imprimirButton.setBounds(10, 170, 150, 25);
        panel.add(imprimirButton);
        imprimirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDisplay();
            }
        });

        JButton infoButton = new JButton("Info del Sistema");
        infoButton.setBounds(10, 200, 150, 25);
        panel.add(infoButton);
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(transito.imprimirInformacion());
            }
        });

        displayArea = new JTextArea();
        displayArea.setBounds(270, 20, 200, 300);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(270, 20, 200, 300);
        panel.add(scrollPane);
    }

    private static void updateDisplay() {
        displayArea.setText(transito.imprimirMultas());
    }
}