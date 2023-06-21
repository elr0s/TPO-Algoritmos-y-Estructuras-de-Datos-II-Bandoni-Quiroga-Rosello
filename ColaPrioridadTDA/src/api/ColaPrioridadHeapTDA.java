package api;

public interface ColaPrioridadHeapTDA {
    void inicializarCola();

    void AcolarPrioridad(int x, int prioridad);

    void Desacolar();

    int Primero();

    int Prioridad();

    boolean ColaVacia();
}
