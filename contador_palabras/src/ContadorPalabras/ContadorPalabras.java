package ContadorPalabras;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.Comparator;



public class ContadorPalabras {

    public static void main(String[] args) {

        //palabrasTotales = 0;


        File archivo = new File("src/Archivo.txt");


        contarPalabras(archivo);

    }
    private static String repeat(String what, int howMany) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < howMany; i++) {
            buf.append(what);
        }
        return buf.toString();
    }




        public static void contarPalabras(File archivo) {
        try {

            if(archivo.exists()) {

                ArrayList<String> palabras = new ArrayList<String>();
                HashMap<String,Integer> palabras2 = new HashMap<String,Integer>();
                HashMap<String, Integer> ordenado = new LinkedHashMap<String,Integer>();
                BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));

                String lineaLeida;
                int contadorCaracteres = 0;



                while((lineaLeida = archivoLeer.readLine()) != null) {
                    //System.out.println(lineaLeida);
                    contadorCaracteres = contadorCaracteres+lineaLeida.length();
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


                List<Entry<String, Integer>> list = new ArrayList<>(palabras2.entrySet());
                list.sort(Entry.comparingByValue());
                Collections.reverse(list);


                List<Map.Entry> l = Arrays.asList(palabras2.entrySet().toArray(new Map.Entry[0]));
                Collections.sort(l, new Comparator<Map.Entry>(){
                    @Override
                    public int compare(Entry entry1, Entry entry2) {
                        return entry1.getValue().toString().compareTo(entry2.getValue().toString());

                    }
                });

               for (Entry<String, Integer> e : l) {
                   ordenado.put(e.getKey(), e.getValue());
               }


                System.out.println("El archivo Contiene: " + palabras.size()+ " palabras");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("El archivo Contiene: " + contadorCaracteres + "caracteres");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


                System.out.println("Palabras ordenadas segun su frecuencia de aparición:");
                list.forEach(System.out::println);
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Histograma de fecuencia representado con *:");
                for(Entry<String, Integer> fila: ordenado.entrySet()){
                    System.out.printf("%s: %s\n",fila.getKey(), repeat("*", fila.getValue().intValue()));
                }
                archivoLeer.close();
            } else {
                System.out.println("NO EXISTE EL ARCHIVO");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
