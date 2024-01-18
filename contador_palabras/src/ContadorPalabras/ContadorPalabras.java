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

            palabrasTotales = 0;


            File archivo = new File("src/Archivo.txt");


            contarPalabras(archivo);
        }


        public static void contarPalabras(File archivo) {
            try {

                if(archivo.exists()) {

                    ArrayList<String> palabras = new ArrayList<String>();
                    HashMap<String,Integer> palabras2 = new HashMap<String,Integer>();
                    BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));
                    
                    String lineaLeida;


                    while((lineaLeida = archivoLeer.readLine()) != null) {
                        //System.out.println(lineaLeida);


                        StringTokenizer st = new StringTokenizer(lineaLeida);
                        while (st.hasMoreTokens()) {
                            palabras.add(st.nextToken());
                        }

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


                    archivoLeer.close();
                } else {
                    System.out.println("NO EXISTE EL ARCHIVO");
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }


}
