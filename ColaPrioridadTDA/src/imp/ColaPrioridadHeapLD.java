package imp;

import api.ColaPrioridadHeapTDA;
import api.HeapTDA;

public class ColaPrioridadHeapLD implements ColaPrioridadHeapTDA {
    HeapTDA ColaPrioridad;
    @Override
    public void inicializarCola() {
        ColaPrioridad = new HeapLD();
        ColaPrioridad.inicializarHeap();
    }

    @Override
    public void AcolarPrioridad(int x, int prioridad) {
        ColaPrioridad.insertar(x, prioridad);
    }

    @Override
    public void Desacolar() {
        ColaPrioridad.eliminarMayor();
    }

    @Override
    public int Primero() {
        return ColaPrioridad.mayor().info;
    }

    @Override
    public int Prioridad() {
        return ColaPrioridad.mayor().prioridad;
    }

    @Override
    public boolean ColaVacia() {
        return ColaPrioridad.estaVacio();
    }
}
