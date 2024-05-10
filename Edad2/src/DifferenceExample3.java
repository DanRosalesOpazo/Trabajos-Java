import java.time.*;
import java.time.LocalDate;
import java.util.*;   
class Quienesmayor {

        //Se crea una matriz de [2][3] y una Variable llamada puntero (ambas globales)
        //en myMatrix guardaremos la cantidad de años meses y dias de ambos usuarios
        // puntero sirve para definir que usuario estamos llenando en la matriz
        static int myMatrix[][] = new int[2][3];
        static int Puntero;

        // Se Crea funcion para calcular cantidad de años ,meses y dias
        // de cada usuario ingresado.
        // La funcion calcula edad por diferencia de fechas entre la fecha actual y
        // la fecha ingresada de cada usuario
    static void find(LocalDate  first_date, LocalDate second_date)   
    {   
        // Toma periodo entre la primera y la segunda fecha
        // la primera fecha es la fecha de nacimiento del usuario
        // y la segunda fecha es siempre la fecha actual del computador.
        Period difference = Period.between(first_date, second_date);   
        // Esta parte del modulo calcula y Muestra en pantalla la cantidad
        // de años , meses y dias de cada usuario , esto lo calcula
        // la funcion viendo la diferencia de dias entre la fecha de nacimiento
        // y la fecha actual
        System.out.printf( "%d años, %d meses and %d dias",
            difference.getYears(),
            difference.getMonths(),   
            difference.getDays());


        // Esta parte de la funcion llena la matriz con los datos de :cantidad de
        // años , meses y dias para cada uno de los usuarios.
        // la variable puntero esta en 0 para llenar la matriz con
        // los datos del primer usuario y posterior queda definida en 1
        // para el llenado de la matriz con los datos del segundo usuario.
        myMatrix[Puntero][0] = difference.getYears(); // llenado de años en la matriz
        myMatrix[Puntero][1] = difference.getMonths();// llenado de meses en la matriz
        myMatrix[Puntero][2] = difference.getDays();// llenado de dias en la matriz
        // puntero define si llenamos usuario uno o usuario dos
    }   
    // Main class  
    public static void main(String[] args)   
    {
        System.out.println ("Empezamos el programa");
        System.out.println ("Por favor ingrese nombre del primer usuario: ");
        String Nombreuno = "";
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        Nombreuno = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner

        System.out.println ("Ingrese Fecha nacimiento de \"" + Nombreuno +"\"");
            System.out.print("En formato AAAA-MM-DD : ");
            Scanner scanner = new Scanner(System.in);
            //Ingresamos fecha de nacimiento del usuario ingresado variable llamada input
            String input = scanner.nextLine();

         //a la variable de nombre input tipo string aplicamos metodo parse que
         // transforma el string ingresado y lo almacena en
         // la variable llamada first_date
            LocalDate first_date = LocalDate.parse(input);

        // posterior definimos la variable second date fecha la fecha actual
        // las variables first_date y second_date son requeridas por la funcion
        // find que calcula los años meses y dias de cada Usuario ingresado
            LocalDate second_date = LocalDate.now();

        // Se define primero puntero=0 , despues se llama a la funcion find.
        // Como matriz y puntero son variables globales, en la funcion find
        // alamacenamos la cantidad de años meses y dias en la matriz
        Puntero = 0;
        System.out.println (Nombreuno+" Tiene");
        find(first_date, second_date);
        // Se realiza un salto de linea
        System.out.println("\n");

        // Prueba y despliegue de llenado de matriz usuario 1
        //System.out.println(myMatrix[Puntero][0]);
        //System.out.println(myMatrix[Puntero][1]);
        //System.out.println(myMatrix[Puntero][2]);

        //Ahora ingresaremos nombre para el segundo usuario
        String Nombredos;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Por favor ingrese nombre del Segundo usuario: ");
        Nombredos = teclado.nextLine();
        //Ahora ingresaremos fecha de nacimiento para el segundo usuario

        System.out.println ("Ingrese Fecha nacimiento de \"" + Nombredos +"\"");
        System.out.print("En formato AAAA-MM-DD : ");
        Scanner teclado2 = new Scanner(System.in);
        String input2 = teclado2.nextLine();
        // realizamos un parse de la varible input2 ( fecha de nacimiento del
        // segundo usuario y la almacenamos en la variable first_date2
        LocalDate first_date2 = LocalDate.parse(input2);
        // Cambiamos el valor de puntero=1
        // LLamamos a la funcion find con las nueva variables
        // first_date2 y second_date. second_date se mantine
        // (porque es la fecha actual del dia de hoy)
        // como puntero es igual ahora = 1 , la funcion find guarda en la matriz
        // la cantidad de años meses y dias para el segundo usuario.
        Puntero = 1;
        System.out.println (Nombredos+" Tiene");
        find(first_date2, second_date);
        // Se realiza un salto de linea
        System.out.println("\n");
        // Prueba y despliegue de llenado de matriz usuario 2
        //System.out.println(myMatrix[Puntero][0]);
        //System.out.println(myMatrix[Puntero][1]);
        //System.out.println(myMatrix[Puntero][2]);

//***************** Quien es Mayor****************************
// Se realiza comparacion de los datos guardados en la matriz para saber
// quien de los dos usurios es mayor o si tienen ambos la misma edad.

        // Si Usuario uno tiene mas años que el Usuario dos
                if ((myMatrix[0][0]) > (myMatrix[1][0])) {
            System.out.println(Nombreuno + " es Mayor que " + Nombredos);
        }
        // Si Usuario uno tiene menos años que el Usuario dos
        if ((myMatrix[0][0]) < (myMatrix[1][0])) {
            System.out.println(Nombreuno + " es Menor que " + Nombredos);
        }
        // Si ambos usuarios tienen la misma cantidad de años
        // definiremos quien es mayor por meses
        if ((myMatrix[0][0]) == (myMatrix[1][0])) {

            // Si Usuario uno tiene mas meses que el Usuario dos
            if ((myMatrix[0][1]) > (myMatrix[1][1])) {
                System.out.println(Nombreuno + " es Mayor que " + Nombredos);

                // Si Usuario uno tiene menos meses que el Usuario dos
            } else if ((myMatrix[0][1]) < (myMatrix[1][1])) {
                System.out.println(Nombreuno + " es Menor que " + Nombredos);

                // Si Usuario uno tiene mismos años y meses que el Usuario dos
                // definiremos quien es mayor por dias
            } else if ((myMatrix[0][1]) == (myMatrix[1][1])) {

                // Si Usuario uno tiene mas dias que el Usuario dos
                if ((myMatrix[0][2]) > (myMatrix[1][2])) {
                    System.out.println(Nombreuno + " es Mayor que " + Nombredos);

                    // Si Usuario uno tiene menos dias que el Usuario dos
                } else if ((myMatrix[0][2]) < (myMatrix[1][2])) {
                    System.out.println(Nombreuno + " es Menor que " + Nombredos);

                    // Usuario uno tiene la misma cantidad de años meses dias que el Usuario dos
                    // Tienen la misma edad
                } else if ((myMatrix[0][2]) == (myMatrix[1][2])) {
                    System.out.println(Nombreuno + " Tiene la misma edad que " + Nombredos);
                }
            }
        }
    }
}