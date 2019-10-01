package primerlabcompiladores;

import java.util.ArrayList;
import java.util.Arrays;

public class ArbolSintactico {

    private Nodo raiz = null;
    private ArrayList nodos;
    private ArrayList exp;
    private ArrayList pila_aux;
    private int alt;
    ArrayList<Nodo> p1 = new ArrayList<>();

    public ArbolSintactico(ArrayList exp) {
        this.exp = exp;
        String[] cadena = Arrays.stream(exp.toArray()).toArray(String[]::new);
        exp.add(0, "(");
        exp.add(")");
        raiz = generarArbolSintactico(null);
    }
    
    private Nodo generarArbolSintactico(Nodo p) {
        int abre, cierra;
        pila_aux = new ArrayList();
        int j = 0;

        String[] cadena = Arrays.stream(exp.toArray()).toArray(String[]::new);

        for (int i = cadena.length - 1; i >= 0; i--) {
            String dato = cadena[i];
            if (dato.equals(")")) {
                pila_aux.add(i);
            } else if (dato.equals("(")) {
                cierra = (int) pila_aux.remove(pila_aux.size() - 1);
                abre = i;
                String[] cadena2 = Arrays.copyOfRange(cadena, abre + 1, cierra);
                p = subArbol(cadena2);
                p1.add(p);
                ArrayList temp = new ArrayList();
                temp.addAll(exp.subList(0, i));
                temp.add(p.toString());
                temp.addAll(exp.subList(cierra + 1, exp.size()));
                exp = new ArrayList();
                exp.addAll(temp);
                return generarArbolSintactico(p);
            }
        }
        return p;
    }

    private boolean esOperOParent(String str) {
        return str.equals("&") | str.equals("|") | str.equals("*") | str.equals("+") | str.equals("?")
                || str.equals("(") || str.equals(")") || str.equals(".");
    }

    private Nodo subArbol(String[] cadena) {
        return alternancia(cadena);
    }

    private Nodo alternancia(String[] cadena) {
        for (int i = cadena.length - 1; i >= 0; i--) {
            if (cadena[i].equals("|")) {
                Nodo alt = new Nodo(cadena[i]);
                alt.setIzq(subArbol(Arrays.copyOfRange(cadena, 0, i)));
                alt.setDer(subArbol(Arrays.copyOfRange(cadena, i + 1, cadena.length)));
                return alt;
            }
        }
        return concatenacion(cadena);
    }

    private Nodo concatenacion(String[] cadena) {
        for (int i = cadena.length - 1; i >= 0; i--) {
            if (cadena[i].equals(".")) {
                Nodo conc = new Nodo(cadena[i]);
                conc.setIzq(subArbol(Arrays.copyOfRange(cadena, 0, i)));
                conc.setDer(subArbol(Arrays.copyOfRange(cadena, i + 1, cadena.length)));
                return conc;
            }
        }
        return kleenePositivaOpcional(cadena);
    }

    private Nodo kleenePositivaOpcional(String[] cadena) {
        /**
         * Cerradora de Kleene (*)
         * Cerradura positiva (+)
         * Opcional (?)
         */
        for (int i = cadena.length - 1; i >= 0; i--) {
            if (cadena[i].equals("*") || cadena[i].equals("+") || cadena[i].equals("?")) {
                Nodo nodo = new Nodo(cadena[i]);
                nodo.setIzq(subArbol(Arrays.copyOfRange(cadena, 0, i)));
                return nodo;
            }
        }
        return hoja(cadena);
    }

    private Nodo hoja(String[] cadena) {
        if (cadena[0].length() > 1) {
            return subArbol2(cadena[0]);
        }
        return new Nodo(cadena[0]);
    }

    private Nodo subArbol2(String nodo) {
        for (int i = 0; i < p1.size(); i++) {
            if (p1.get(i).toString().equals(nodo)) {
                return p1.get(i);
            }
        }
        return null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    private void altura(Nodo aux, int nivel) {
        if (aux != null) {
            altura(aux.getIzq(), nivel + 1);
            alt = nivel;
            altura(aux.getDer(), nivel + 1);
        }
    }

    public int getAltura() {
        altura(raiz, 1);
        return alt;
    }
}
