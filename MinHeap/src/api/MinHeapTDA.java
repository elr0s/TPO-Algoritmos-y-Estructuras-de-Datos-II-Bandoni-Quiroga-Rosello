package api;

public interface MinHeapTDA {
     void inicializarHeap();
     void insertar(int x);
     void eliminarMenor();
     int menor();
     boolean estaVacio();
}
