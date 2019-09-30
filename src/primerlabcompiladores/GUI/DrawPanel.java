/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerlabcompiladores.GUI;

import java.awt.Graphics;
import javax.swing.JPanel;
import primerlabcompiladores.ArbolSintactico;
import primerlabcompiladores.Nodo;

/**
 *
 * @author jpinzonm
 */
public class DrawPanel extends JPanel{
    
    private ArbolSintactico objArbol;
    public static final int diam = 30;
    public static final int radio = diam / 2;
    public static final int ancho = 50;
    
    public void setObjArbol(ArbolSintactico objArbol){
        this.objArbol = objArbol;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        dibujar(g, getWidth()/2, 20, objArbol.getRaiz());
    }

    private void dibujar(Graphics g, int x, int y, Nodo n) {
        if (n != null) {
            int extrasize = n.nodosCompletos(n) * (ancho/2);
            g.drawOval(x, y, diam, diam);
            g.drawString(n.getDato(), x + 12, y + 18);
            if (n.getIzq() != null) {
                g.drawLine(x + radio, y + radio, x - ancho - extrasize + radio, y + ancho + radio);
            }
            if (n.getDer()!= null) {
                g.drawLine(x + radio, y + radio, x + ancho + extrasize + radio, y + ancho + radio);
            }
            dibujar(g, x - ancho - extrasize, y + ancho, n.getIzq());
            dibujar(g, x + ancho + extrasize, y + ancho, n.getDer());
        }   
    }
}
