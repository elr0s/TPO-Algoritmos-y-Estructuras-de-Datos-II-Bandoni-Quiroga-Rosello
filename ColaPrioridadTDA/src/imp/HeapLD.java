package imp;

import api.HeapTDA;


public class HeapLD implements HeapTDA {
    NodoPrioridad[] heap;

    int tamanio;
    @Override
    public void inicializarHeap() { //Se inicializa con el tamaño -1 para que el nodo padre sea tamaño = 0
        heap = new NodoPrioridad[100];
        tamanio = -1;
    }
    private int nodoPadre(int i){ // Se toma el nodo actual y resta 1, despues de divide el resultado por 2
        // Esto se hace para encontrar el indice del padre del nodo en el arreglo
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
        //Funcion: ajustar la posición de un nodo recién insertado hacia arriba
        //Se calcula el indice padre
        int padre = nodoPadre(i);

        // Se inicia el ciclo hasta que llegue a 0 (nodo raiz)

        while (i > 0 && heap[padre].prioridad < heap[i].prioridad){
            // Se intercambia la posicion del nodo en el indice padre con el nodo en el indice i
            cambiarPosicion(padre, i);
            //Se actualiza el índice "i" para que sea igual al índice del padre, ya que ahora el nodo se encuentra en la posición del padre.
            i = padre;
        }
    }
    private void shiftDown(int i) {
        // maxI variable para comparar y fijar el indice del nodo
        int maxI = i;
        int iIzquierdo = hijoIzquierdo(i);
        
        //Se verifica si el índice del hijo izquierdo es menor tamaño del heap y si la prioridad del nodo en el índice "iIzquierdo" es mayor que la prioridad del nodo en el índice "maxI". 
        //Si se cumple esta condición, se actualiza el valor de "maxI" con el valor de "iIzquierdo".
        if (iIzquierdo <= tamanio && heap[iIzquierdo].prioridad > heap[maxI].prioridad)
            maxI = iIzquierdo;

        int iDerecho = hijoDerecho(i);
        //Se toma el hijo derecho
        
        //Se verifica si el índice del hijo derecho es menor tamaño del heap y si la prioridad del nodo en el índice "iDerecho" es mayor que la prioridad del nodo en el índice "maxI". 
        //Si se cumple esta condición, se actualiza el valor de "maxI" con el valor de "iDerecho".
        if (iDerecho <= tamanio && heap[iDerecho].prioridad > heap[maxI].prioridad)
            maxI = iDerecho;
        
        //Se verifica que i sea distinto a maxI, si lo es se intercambia la posicion hacia abajo
        if (i != maxI){
            cambiarPosicion(i, maxI);
            //Se repite el proceso hasta q no se encuentren hijos con una prioridad mayor o que se alcance una posicion donde i = maxI
            shiftDown(maxI);
        }
    }
    @Override
    public void eliminarMayor() {
        //Se verifica que no este vacio el arreglo
        if(!estaVacio()){
            //Pone el ultimo elemento y lo coloca en el nodo raiz
            heap[0] = heap[tamanio];
            //Ordena el Heap con la funcion shiftDown
            shiftDown(0);
            tamanio--;
        }
    }

    @Override
    public NodoPrioridad mayor() {
        //retorna el nodo raiz
        return heap[0];
    }

    @Override
    public boolean estaVacio() {
        return tamanio<0;
    }

    @Override
    public void insertar(int x, int prioridad) {
        //Creamos un objeto NodoPrioridad, se le asignan
        //los atribustos correspondientes
        NodoPrioridad nodo =  new NodoPrioridad();
        nodo.info          = x;
        nodo.prioridad     = prioridad;
        tamanio++;
        //Se añadie el nodo al arreglo
        heap[tamanio] = nodo;
        //Ordena el Heap con la funcion shiftUp
        shiftUp(tamanio);
    }

}
