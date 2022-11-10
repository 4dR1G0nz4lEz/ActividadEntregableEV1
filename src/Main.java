import java.io.*;


public class Main {
    public static void main(String[] args) {

        File f = new File("./Archivos/enunciado.dat");
        File f2 = new File("./Archivos/enunciadoTxt.txt");
        File directorio= new File("./Ejercicios");
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

    public static void arrayDNI(){
        
    }











}