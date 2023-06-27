package imp;

import api.MinHeapTDA;

public class MinHeapLD implements MinHeapTDA {
    int[] heap;
    int tamanio;
    @Override
    public void inicializarHeap() {
        heap = new int[100];
        tamanio = -1;
    }

    @Override
    public void insertar(int x) {
        tamanio++;
        heap[tamanio] = x;
        shiftUp(tamanio);
    }

    @Override
    public void eliminarMenor() {
        heap[0] = heap[--tamanio];
        shiftDown(0);
    }

    @Override
    public int menor() {
        return heap[0];
    }

    @Override
    public boolean estaVacio() {
        return tamanio<0;
    }

    private int nodoPadre(int i){
        return (i-1) / 2;
    }
    private int hijoIzquierdo(int i){
        return (2*i) + 1;
    }

    private int hijoDerecho(int i){
        return (2*i) + 2;
    }


    private void shiftUp(int i) {
        int padre = nodoPadre(i);

        while (i < 0 && heap[padre] < heap[i]){
            cambiarPosicion(padre, i);
            i = padre;
        }
    }
    private void shiftDown(int i) {
        int minI = i;
        int iIzquierdo = hijoIzquierdo(i);
        int iDerecho = hijoDerecho(i);

        if (iIzquierdo <= tamanio && heap[iIzquierdo] < heap[minI])
            minI = iIzquierdo;

        if (iDerecho <= tamanio && heap[iDerecho] < heap[minI])
            minI = iDerecho;

        if (i != minI){
            cambiarPosicion(i, minI);
            shiftDown(minI);
        }
    }
    private void cambiarPosicion(int i1, int i2){
        int aux = heap[i1];

        heap[i1] = heap[i2];
        heap[i2] = aux;
    }

}
