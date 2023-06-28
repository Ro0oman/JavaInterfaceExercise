import java.util.Random;

class Empleado
{

    String Nombre, Apellido;
    int salario;
    boolean sabeingles;
    boolean activo;

    //CONSTRUCTOR

    Empleado (String Nombre, String Apellido, int salario, boolean sabeingles, boolean activo){
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.salario = salario;
        this.sabeingles = sabeingles;
        this.activo = activo;
    }


    //METODOS

    void subesueldo(int cantidad){
        this.salario += cantidad;
    }

    void despedir(){
        this.activo = false;
    }
}

class administrativo extends Empleado{

    int numfacturas;
    boolean titulado;

    public administrativo(String Nombre, String Apellido, int salario, boolean sabeingles, boolean activo,
                          int numfacturas, boolean titulado) {
        super(Nombre, Apellido, salario,sabeingles, activo);
        this.numfacturas=numfacturas;
        this.titulado = titulado;
    }
}

class tecnico extends Empleado{

   int numeroreparaciones;
   boolean sabejava;

    public tecnico(String Nombre, String Apellido, int salario, boolean sabeingles, boolean activo,
                          int numeroreparaciones, boolean sabejava) {
        super(Nombre, Apellido, salario,sabeingles, activo);
        this.numeroreparaciones=numeroreparaciones;
        this.sabejava = sabejava;
    }

    void aprendejava(){
        this.sabejava = true;
    }
}




public class Main{
    public static void main (String[]args){
        administrativo administrativo1 = new administrativo("Roman", "Myziuk",
                2000, true, true, 200, true);
        administrativo administrativo2 = new administrativo("Talia", "Idanez",
                2000, true, true, 200, true);
        tecnico tecnico1 = new tecnico("Jaime", "Mestre",
                2000, true, true, 200, true);
        tecnico tecnico2 = new tecnico("Alfonso", "Capilla",
                2000, true, true, 200, true);

        Empleado [] vecEmple = new Empleado[4];
        vecEmple[0]=administrativo1;
        vecEmple[1]=administrativo2;
        vecEmple[2]=tecnico1;
        vecEmple[3]=tecnico2;
        for (int i = 0; i<4; i++){
            if (vecEmple[i].sabeingles){
                vecEmple[i].subesueldo(100);
            }
        }

        for (int i = 0; i<4; i++){
            if (vecEmple[i].getClass() == administrativo.class){
                if (!((administrativo)vecEmple[i]).titulado && ((administrativo)vecEmple[i]).numfacturas<200){
                    vecEmple[i].activo=false;
                }
            }
        }
    }
}