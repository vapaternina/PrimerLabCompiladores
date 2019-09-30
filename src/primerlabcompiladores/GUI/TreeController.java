/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerlabcompiladores.GUI;

import primerlabcompiladores.ArbolSintactico;

/**
 *
 * @author jpinzonm
 */
public class TreeController {
    private ArbolSintactico ojbArbol;
    private DrawPanel objDP;

    public TreeController(ArbolSintactico ojbArbol, DrawPanel objDP) {
        this.ojbArbol = ojbArbol;
        this.objDP = objDP;
    }
    
    public void start(){
        objDP.setObjArbol(ojbArbol);
    }
    
}
