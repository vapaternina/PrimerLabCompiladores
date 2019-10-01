/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerlabcompiladores.GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Panel;
import javax.swing.JPanel;
import primerlabcompiladores.ArbolSintactico;
import primerlabcompiladores.Nodo;

/**
 *
 * @author jpinzonm
 */
public class DrawPanel extends JPanel{
    
    private ArbolSintactico objArbol;
    public static final int DIAM = 30;
    public static final int RADIO = DIAM / 2;
    public static final int ANCHO = 50;
    
    public void setObjArbol(ArbolSintactico objArbol){
        this.objArbol = objArbol;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        dibujar(g, getWidth()/2, 20, objArbol.getRaiz());
        // your custom painting code here
    }

    /*@Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        dibujar(g, getWidth()/2, 20, objArbol.getRaiz());
    }*/
    
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(40, 40);
    }

    private void dibujar(Graphics g, int x, int y, Nodo n) {
        if (n != null) {
            int extrasize = n.nodosCompletos(n) * (ANCHO/2) - 15;
            g.drawOval(x, y, DIAM, DIAM);
            g.drawString(n.getDato(), x + 12, y + 18);
            if (n.getIzq() != null) {
                g.drawLine(x + RADIO, y + RADIO, x - ANCHO - extrasize + RADIO, y + ANCHO + RADIO);
            }
            if (n.getDer()!= null) {
                g.drawLine(x + RADIO, y + RADIO, x + ANCHO + extrasize + RADIO, y + ANCHO + RADIO);
            }
            dibujar(g, x - ANCHO - extrasize, y + ANCHO, n.getIzq());
            dibujar(g, x + ANCHO + extrasize, y + ANCHO, n.getDer());
        }   
    }
}
