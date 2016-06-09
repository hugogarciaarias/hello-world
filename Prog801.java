import java.io.*;
import java.util.ArrayList;

public class Prog801 {

	public static void main(String[] args) throws IOException {

		String fichero="E:\\HugoGarcíaArias\\Programación\\Tema8\\estadistica.dat";
		FileInputStream f=null;
		int numAlumnos=0, sumaEdades=0, edadMayor, numMenores=0, sumaDesviacion = 0;
		float media=0;
		int edad=0;
		ArrayList<Integer> listaEdades = new ArrayList<Integer>();
		
		try {
			f=new FileInputStream(fichero);
			edad=f.read();
			edadMayor = edad;
			while(edad!=-1) {
				System.out.print(edad + " ");
				numAlumnos++;
				sumaEdades+=edad;
				if (edad > edadMayor) edadMayor = edad;
				if (edad < 18) numMenores++;
				listaEdades.add(edad);
				edad = f.read();
			}
			if(numAlumnos != 0) media = (float)sumaEdades / numAlumnos;
			System.out.println("\nHay " + numAlumnos + " alumnos procesados");
			System.out.println("La media de las edades es " + media);
			System.out.println("La mayor edad es " + edadMayor);
			System.out.println("Hay " + numMenores + " menores de edad");
			
			for(int i =0; i<listaEdades.size(); i++)
				sumaDesviacion += (float)Math.pow(listaEdades.get(i) - media, 2);
			
			if(numAlumnos != 0)
				System.out.println("Desviacion " + (float)Math.sqrt(sumaDesviacion/numAlumnos));
		}
		catch (IOException e) {
			System.out.println("\nEl fichero no se encuentra");
		}
		finally {
			if (f != null) f.close();
		}
	}
}
// Comenrtario
