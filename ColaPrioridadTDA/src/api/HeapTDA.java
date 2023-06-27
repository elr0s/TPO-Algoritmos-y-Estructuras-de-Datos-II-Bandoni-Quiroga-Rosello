package api;
import imp.NodoPrioridad;
public interface HeapTDA {
     void inicializarHeap();
     void insertar(int x,int prioridad);
     void eliminarMayor();
     NodoPrioridad mayor();
     boolean estaVacio();
}
