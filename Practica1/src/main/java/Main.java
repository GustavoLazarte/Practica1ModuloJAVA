import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("registrosApp.obj"));
        Tienda tienda=(Tienda)entrada.readObject();

        System.out.println();

        //ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("registrosApp.obj"));
        //salida.writeObject(tienda);
    }

    public static void main2(String[] args) throws IOException, ClassNotFoundException {
        Personal p1 = new PersonalCajero("Gustavo", "Lazarte",  LocalDate.of(2022, 7,3));
        Personal p2 = new PersonalPromotor("Gabriel", "Mamani",  LocalDate.now());
        Personal p3 = new PersonalGerente("Adriana", "Torrico",  LocalDate.of(2022,9,28));
        Personal p4 = new PersonalPromotor("Luis" , "Escobar",  LocalDate.of(2022,3,15));

        ArrayList<Personal> empleados = new ArrayList<>(Arrays.asList(p1,p2,p3,p4));

        Carnet cl1c1 = new Carnet(13595671, "cochabamba", LocalDate.of(2004,10,3));
        Cliente cl1 = new Cliente("Harvey", "Specter", cl1c1, "hs22@gmail.com");
        Carnet cl2c2 = new Carnet(13554571, "cochabamba", LocalDate.of(2006,9,25));
        Cliente cl2 = new Cliente("Dona", "poulsen", cl2c2, "dona@gmai.com");
        Carnet cl3c3 = new Carnet(12454671, "la paz", LocalDate.of(2004,12,25));
        Cliente cl3 = new Cliente("Mike", "ross", cl3c3, "mross@gmai.com");
        Carnet cl4c4 = new Carnet(10413671, "cochabamba", LocalDate.of(2000,12,17));
        Cliente cl4 = new Cliente("Luis", "litt", cl4c4);

        ArrayList<Cliente> clientes = new ArrayList<>(Arrays.asList(cl1,cl2,cl3,cl4));

        Libro libro = new Libro("You", "Quien eres", "Del Perio","Perial",Generos.COMEDIA,"32132", 350);
        libro.aumentarStock(25);
        Libro libro2 = new Libro("Star Wars", "Mucha guerra", "Lucas Film","Wars",Generos.CIENCIA_FICCION,"ssaasdf52", 420);
        libro2.aumentarStock(12);
        Libro libro3 = new Libro("Sangre de Campeon", "Adolescencia", "Carlos Cuathemoc","Adls",Generos.CUENTOS,"ss21af52", 220);
        libro3.aumentarStock(100);
        Libro libro4 = new Libro("Yo antes de ti", "amor", "Carlos Quienchucha","Amor y paz",Generos.TERROR,"1ahf52", 320);
        libro4.aumentarStock(20);

        ArrayList<Libro> libros =new ArrayList<>(Arrays.asList(libro,libro2,libro3,libro4));

        Tienda t = new Tienda("LibroTeca", "Calacala #208",empleados,clientes,libros);
        ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("registrosApp.obj"));
        salida.writeObject(t);

    }
}
