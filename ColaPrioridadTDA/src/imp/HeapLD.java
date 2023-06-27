package imp;

import api.HeapTDA;


public class HeapLD implements HeapTDA {
    NodoPrioridad[] heap;

    int tamanio;
    @Override
    public void inicializarHeap() {
        heap = new NodoPrioridad[100];
        tamanio = -1;
    }
    private int nodoPadre(int i){
        return ((i-1) / 2);
    }
    private int hijoIzquierdo(int i){
        return ((2*i) + 1);
    }
    private int hijoDerecho(int i){
        return ((2*i) + 2);
    }
    private void cambiarPosicion(int i1, int i2){
        NodoPrioridad aux = heap[i1];
        heap[i1] = heap[i2];
        heap[i2] = aux;
    }

    private void shiftUp(int i) {
        int padre = nodoPadre(i);

        while (i > 0 && heap[padre].prioridad < heap[i].prioridad){
            cambiarPosicion(padre, i);
            i = padre;
        }
    }
    private void shiftDown(int i) {
        int maxI = i;
        int iIzquierdo = hijoIzquierdo(i);

        if (iIzquierdo <= tamanio && heap[iIzquierdo].prioridad > heap[maxI].prioridad)
            maxI = iIzquierdo;

        int iDerecho = hijoDerecho(i);

        if (iDerecho <= tamanio && heap[iDerecho].prioridad > heap[maxI].prioridad)
            maxI = iDerecho;

        if (i != maxI){
            cambiarPosicion(i, maxI);
            shiftDown(maxI);
        }
    }
    @Override
    public void eliminarMayor() {
        if(!estaVacio()){
            heap[0] = heap[tamanio];
            shiftDown(0);
            tamanio--;
        }
    }

    @Override
    public NodoPrioridad mayor() {
        return heap[0];
    }

    @Override
    public boolean estaVacio() {
        return tamanio<0;
    }

    @Override
    public void insertar(int x, int prioridad) {
        NodoPrioridad nodo =  new NodoPrioridad();
        nodo.info          = x;
        nodo.prioridad     = prioridad;
        tamanio++;
        heap[tamanio] = nodo;
        shiftUp(tamanio);
    }

}
