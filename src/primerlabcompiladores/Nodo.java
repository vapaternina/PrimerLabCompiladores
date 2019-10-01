package primerlabcompiladores;

import java.util.ArrayList;

public class Nodo {

    private String dato;
    private int pos;
    private Nodo izq, der;
    public ArrayList<Integer> primeraPos;
    public ArrayList<Integer> ultimaPos;
    public boolean anulable;
    
    public Nodo(String dato) {
        primeraPos = new ArrayList<>();
        ultimaPos = new ArrayList<>();
        this.dato = dato;
        izq = null;
        der = null;
    }

    public boolean isAnulable() {
        return anulable;
    }

    public void setAnulable(boolean anulable) {
        this.anulable = anulable;
    }

    
    
    public ArrayList<Integer> getPrimeraPos() {
        return primeraPos;
    }

    public void setPrimeraPos(ArrayList<Integer> primeraPos) {
        this.primeraPos = primeraPos;
    }

    public ArrayList<Integer> getUltimaPos() {
        return ultimaPos;
    }

    public void setUltimaPos(ArrayList<Integer> ultimaPos) {
        this.ultimaPos = ultimaPos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getDato() {
        return dato;
    }

    public int getPos() {
        return pos;
    }

    public Nodo getIzq() {
        return izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public int nodosCompletos(Nodo n) {
        if (n == null) {
            return 0;
        } else {
            if (n.izq != null && n.der != null) {
                return nodosCompletos(n.izq) + nodosCompletos(n.der) + 1;
            }
            return nodosCompletos(n.izq) + nodosCompletos(n.der);
        }
    }

}
