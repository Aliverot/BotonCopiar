/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package botoncopiar;

import javax.swing.JTextArea;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPopupMenu;

public class AreaBotonEmergente extends JTextArea {
    private JPopupMenu menuEmergente;
    private JButton botonCopiar;
    public AreaBotonEmergente() {
        // Configurar el area de texto
        setLineWrap(true);
        setWrapStyleWord(true);
        // Crear boton de copiar
        botonCopiar = new JButton();
        // Cargar la imagen original
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/imagen/Copiar.png"));
        Image imagenRed = iconoOriginal.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon iconoPequeño = new ImageIcon(imagenRed);
        botonCopiar.setIcon(iconoPequeño);
        botonCopiar.setBackground(Color.lightGray);         
        botonCopiar.addActionListener((ActionEvent e) -> {copiarPortapapeles();});
        // Crear popup 
        menuEmergente = new JPopupMenu();
        menuEmergente.add(botonCopiar); 
        menuEmergente.setBackground(new Color(0, 0, 0, 0));
        menuEmergente.setOpaque(false);
                // Escuchar clic para ocultar el botón cuando se haga clic fuera
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuEmergente.setVisible(false);
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent eventoRaton) {
                mostrarMenu(eventoRaton);
            }
        });
    }
    private void mostrarMenu(MouseEvent eventoRaton) {
    String textoSeleccionado = getSelectedText();
    if (textoSeleccionado!=null) {
        // Mostrar el menu en la posición del raton
        menuEmergente.show(this, eventoRaton.getX(), eventoRaton.getY());
        } 
    else 
        menuEmergente.setVisible(false);        
    }
    private void copiarPortapapeles() {
        String texto = getSelectedText();
        if (texto!=null) {
            // Copiar texto al portapapeles
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection selection = new StringSelection(texto);
            clipboard.setContents(selection, null);
            // Ocultar el popup después de copiar
            menuEmergente.setVisible(false);
        }
    }
}
