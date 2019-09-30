package primerlabcompiladores;

public class Nodo {
    private String dato;
    private int pos;
    private Nodo izq,der;
    public Nodo(String dato){
        this.dato = dato;
        izq = null;
        der = null;
    }

    public String getDato() {
        return dato;
    }
    
    public int getPos(){
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
        }else {
            if (n.izq != null && n.der != null) {
                return nodosCompletos(n.izq) + nodosCompletos(n.der) + 1;
            }
            return nodosCompletos(n.izq) + nodosCompletos(n.der);
        }
    }
     
}
