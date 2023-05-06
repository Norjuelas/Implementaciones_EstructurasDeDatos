package sequential;

public class ListaEnlazada {
    public static void main(String[] args) {

    }

    public class ListaEnlazadaob {
        private Nodo cabeza;
        private Nodo cola;
        private int size;

        public ListaEnlazadaob(Nodo cabeza, Nodo cola, int size) {
            this.cabeza = null;
            this.cola = null;
            this.size = 0;
        }

        @Override
        public String toString() {
            return "ListaEnlazada [cabeza=" + cabeza + ", cola=" + cola + ", size=" + size + "]";
        }
        private class Nodo {
            String contenido;
            Nodo siguiente;

            public Nodo(String contenido) {
                this.contenido = contenido;
                siguiente = null;
            }

            public Nodo getSiguiente() {
                return siguiente;
            }

            public String getValor() {
                return contenido;
            }

            public void setSiguiente(Nodo n) {
                siguiente = n;
            }

            public void setContenido(String contenido) {
                this.contenido = contenido;
            }

        }
    }
}