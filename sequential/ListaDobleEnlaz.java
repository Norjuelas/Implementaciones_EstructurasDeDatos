package sequential;

import java.util.Scanner;
import java.util.Iterator;

public class ListaDobleEnlaz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] list = input.split(" ");
        ListaDobleEnlazada<String> lista = new ListaDobleEnlazada<String>();
        for (int i = 0; i < list.length; i++) {
            lista.agregarFin(list[i]);
        }
        ListaDobleEnlazada<String> Nuevalista = new ListaDobleEnlazada<String>();

        while(!lista.estaVacia()){
            Nuevalista.agregarFin(lista.obtener(0));
            lista.eliminarInicio();
            Nuevalista.agregarFin(lista.obtener(lista.longitud()-1));
            lista.eliminarFin();
        }

        System.out.println(Nuevalista.toString());

    }
}

class ListaDobleEnlazada<T> implements Iterable<T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int longitud;

    private static class Nodo<T> {
        private T valor;
        private Nodo<T> siguiente;
        private Nodo<T> anterior;

        public Nodo(T valor) {
            this.valor = valor;
            this.siguiente = null;
            this.anterior = null;
        }

        public T getValor() {
            return valor;
        }

        public void setValor(T valor) {
            this.valor = valor;
        }

        public Nodo<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<T> siguiente) {
            this.siguiente = siguiente;
        }

        public Nodo<T> getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo<T> anterior) {
            this.anterior = anterior;
        }
    }

    public ListaDobleEnlazada() {
        inicio = null;
        fin = null;
        longitud = 0;
    }

    public boolean estaVacia() {
        if(inicio==null && fin==null) 
            return true;
        else{
            return false;
        }
    }

    public int longitud() {
        return longitud;
    }

    public void agregarInicio(T valor) {
        Nodo<T> nuevoNodo = new Nodo<T>(valor);
        if (estaVacia()) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            nuevoNodo.siguiente = inicio;
            inicio.anterior = nuevoNodo;
            inicio = nuevoNodo;
        }
        longitud++;
    }

    public void agregarFin(T valor) {
        Nodo<T> nuevoNodo = new Nodo<T>(valor);
        if (estaVacia()) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            nuevoNodo.anterior = fin;
            fin = nuevoNodo;
        }
        longitud++;
    }

    public T eliminarInicio() {
        if (estaVacia()) {
            throw new Error("Vacia");
        }
        T valorEliminado = inicio.valor;
        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            inicio = inicio.siguiente;
            inicio.anterior = null;
        }
        longitud--;
        return valorEliminado;
    }

    public void eliminarFin() {
        fin = fin.anterior;
        longitud--;
    }


    public T obtener(int index) {
        if (index == 0) {
            return this.inicio.getValor();
        }
        if (index == this.longitud - 1) {
            this.fin.getValor();
        }
        Nodo<T> node = this.inicio;
        for (int i = 0; i < index; i++) {
            node = node.getSiguiente();
        }
        return node.getValor();
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Nodo<T> node = ListaDobleEnlazada.this.inicio;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                T e = node.getValor();
                node = node.getSiguiente();
                return e;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (T e : this) {
            sb.append(e);
            sb.append("");
        }
        if (sb.length() > 1)
            sb.replace(sb.length() - 1, sb.length(), "");
        sb.append("");
        return sb.toString();
    }

}
