/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eldodev;

import com.eldodev.gui.Menu;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Teck Trakker
 */


public class Principal {

    public static void main(String[] args) {
        // Cria e exibe a interface GUI Menu na thread de despacho de eventos
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Cria uma nova instância de Menu
                Menu menu = null;
                try {
                    menu = new Menu();
                } catch (Exception ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Torna a interface GUI Menu visível
                menu.setVisible(true);
            }
        });
    }
}

