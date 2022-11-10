import java.io.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        File f = new File("./Archivos/enunciado.dat");
        File f2 = new File("./Archivos/enunciadoTxt.txt");
        File directorio= new File("./Ejercicios");
        File ficheroDni = new File("./Ejercicios/index.txt");

        if(!f2.exists()){
            try{
                f2.createNewFile();
            }catch (IOException e2){
                e2.printStackTrace();
            }
        }

        String enunciado;

        try{
        enunciado=leerEnunciado(f);
        System.out.println(enunciado);
        escribirEnunciado(f2,enunciado);
        crearDirectorio(directorio);
        arrayDNI(ficheroDni);
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public static String leerEnunciado(File f) throws IOException{
        FileInputStream fImp= new FileInputStream(f);
        DataInputStream dImp=new DataInputStream(fImp);

        StringBuilder sB=new StringBuilder();

        try{
            while(true){
                sB.append(dImp.readUTF());
            }
        }catch(EOFException e){
            System.out.println("Fin de fichero");;
        }
        return sB.toString();
    }

    public static void escribirEnunciado(File f,String texto)throws IOException{

        FileWriter fW = new FileWriter(f);
        fW.write(texto);
        fW.close();
    }

    public static void crearDirectorio(File directorio){

        if (!directorio.exists()){
            directorio.mkdirs();
        }else{
            System.out.println("El directorio ya existe");
        }

    }

    public static void arrayDNI(File f) throws IOException {
        FileReader fR = new FileReader(f);
        BufferedReader bR = new BufferedReader(fR);

        ArrayList <String> arrayDni = new ArrayList<>();
        String Dni="53675054T";

        String linea;
        int puesto=1;
        boolean encontrado=false;
        try{
            while((linea=bR.readLine())!=null){

                arrayDni.add(linea);
                if (arrayDni.contains(Dni) && encontrado==false) {
                    System.out.println("La posicion de mi DNI es: "+puesto);
                    encontrado=true;
                }else{
                    puesto++;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }











}