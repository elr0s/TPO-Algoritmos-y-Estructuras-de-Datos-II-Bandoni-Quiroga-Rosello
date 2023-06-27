import api.ColaPrioridadHeapTDA;
import imp.ColaPrioridadHeapLD;

public class main {
    public static void printCola(ColaPrioridadHeapTDA a){
        while (!a.ColaVacia()){
            System.out.print("Nro: "+a.Primero());
            System.out.println(" Prioridad:"+a.Prioridad());
            a.Desacolar();
        }
    }
    public static void main(String[] args) {
        ColaPrioridadHeapTDA colaPrioridad = new ColaPrioridadHeapLD();
        colaPrioridad.inicializarCola();

        colaPrioridad.AcolarPrioridad(3,7);
        colaPrioridad.AcolarPrioridad(1,21);
        colaPrioridad.AcolarPrioridad(2,14);
        colaPrioridad.AcolarPrioridad(4,2);
        colaPrioridad.AcolarPrioridad(5,1);

        printCola(colaPrioridad);
    }
}
