package org.conversor;

import telaPrincipal.Programa;

import javax.swing.*;


public class App 
{
    public static void main( String[] args ) {
        SwingUtilities.invokeLater(() -> {
            Programa programa = new Programa();
            programa.setVisible(true);
        });

    }
}
