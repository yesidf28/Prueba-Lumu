package ContadorPalabras;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
public class ContadorPalabras {



        static int palabrasTotales;

        public static void main(String[] args) {
            // VARIABLE PARA LLEVAR EL CONTADOR DE PALABRAS
            palabrasTotales = 0;

            // OBJETO ARCHIVO CON LA RUTA DEL ARCHIVO A LEER
            File archivo = new File("src/Archivo.txt");

            // LLAMADA AL METODO PARA CONTAR LAS PALABRAS Y LAS LINEAS
            contarPalabras(archivo);
        }

        // METODO QUE LEE EL ARCHIVO Y CUENTA LAS PALABRAS Y LAS LINEAS
        public static void contarPalabras(File archivo) {
            try {
                // SI EXISTE EL ARCHIVO
                if(archivo.exists()) {
                    // ABRE LECTURA
                    ArrayList<String> palabras = new ArrayList<String>();
                    HashMap<String,Integer> palabras2 = new HashMap<String,Integer>();
                    BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));

                    String lineaLeida;

                    // MIENTRAS LA LINEA LEIDA NO SEA NULL
                    while((lineaLeida = archivoLeer.readLine()) != null) {
                        //System.out.println(lineaLeida);

                        // CONTAMOS LAS PALABRAS DE LA LINEA
                        StringTokenizer st = new StringTokenizer(lineaLeida);
                        while (st.hasMoreTokens()) {
                            palabras.add(st.nextToken());
                        }


                        // AUMENTA EL CONTADOR DE LINEAS Y DE PALABRAS

                        //palabrasTotales = palabrasTotales + st.countTokens();
                    }
                    Iterator<String> nombreIterator = palabras.iterator();
                    while(nombreIterator.hasNext()){
                        String elemento = nombreIterator.next();
                        palabras2.put(elemento, palabras2.getOrDefault(elemento, 0) + 1);
                    }

                    for (String k : palabras2.keySet()) {
                        System.out.println(k + " : " + palabras2.get(k));
                    }
                    System.out.println("");
                    System.out.println("Numero de palabras: " + palabras.size());

                    // CIERRA LA LECTURA
                    archivoLeer.close();
                } else {
                    System.out.println("NO EXISTE EL ARCHIVO");
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }


}
