import java.util.Scanner;

public class UserMessage {

    public static void main(String[] args) {

        Boolean iniciar = true;
        Scanner scan = new Scanner(System.in);
        System.out.println("Iniciando sistema ..........!");
        String otraOperacion = "";

        while (iniciar){
            System.out.println("Deseas iniciar alguna operación: Sí(y), No (x)");
            otraOperacion = scan.next();
            if(otraOperacion.equals("y")){
                listClientes();
                enviarMensajesCliente();
            } else if (otraOperacion.equals("x")){
                System.out.println("Good Bye!");
                iniciar = false;
                return;
            }


        }

    }

    private static void enviarMensajesCliente() {
        Scanner sc = new Scanner(System.in);
        int [] ids = new int[100];
        String clintesIDs = "";
        Boolean iniciar = true;
        int contador = 0;

        System.out.println("Envío de SMS");
        System.out.println("Ingrese ID del cliente");
        clintesIDs = sc.next();
        ids[contador] = Integer.parseInt(clintesIDs);

        while (iniciar){
            if (clintesIDs.equals("x")){
                System.out.println("Se cancela el envio de mensaje");
                return;
            }else if (clintesIDs.equals("y")){
                iniciar = false;
            } else {
                System.out.println("Ingrese nuevo ID de cliente (x: cancelar, y: continuar):");
                clintesIDs = sc.next();
                if(!clintesIDs.equals("y") && !clintesIDs.equals("x")) {
                    contador += 1;
                    ids[contador] = Integer.parseInt(clintesIDs);
                }
            }
        }

        System.out.println("Ingrese el mensaje:");
        Scanner input = new Scanner(System.in);
        String message = input.nextLine();

        int [] result = new int[contador + 1];
        System.arraycopy(ids, 0, result, 0, contador + 1);


        for(int i = 0; i < result.length; i++){
            getClientes(result[i], message);
            System.out.println("----------------------------------------OK---->");
        }
        System.out.println("###################### MENSAJES ENVIDOS #####################");


    }

    private static void  getClientes(int id, String message){
        int [] dni_cliente = dataDNICliente();
        int [] phone_cliente =  dataTelefonoCliente();
        String [] name_cliente = dataNombreCliente();
        if(id <= dni_cliente.length){
            System.out.println("ID:" + id);
            System.out.println("DNI:" + dni_cliente[id]);
            System.out.println("Teléfono:" + phone_cliente[id]);
            System.out.println("Nombre:" + name_cliente[id]);
            System.out.println("Hola "+ name_cliente[id] + ", "+ message);
        }else {
            System.out.println("Usuario no encontrado");
            System.out.println("ID: " + id);
        }
    }

    private static void listClientes() {
        int [] dni_cliente = dataDNICliente();
        int [] phone_cliente =  dataTelefonoCliente();
        String [] name_cliente = dataNombreCliente();

        for (int i = 0; i < dni_cliente.length; i++){
            if(i == 0){
                System.out.println("##################################################################");
                System.out.println("Business REATAIL ABC");
                System.out.println("##################################################################");
                System.out.println("Sistema de envío de mensajes");
                System.out.println("##################################################################");
                System.out.println("ID | DNI      | Teléfono  | Nombres");
                System.out.println("_________________________________________");
            }
            System.out.println(i + " | " + dni_cliente[i] + " | " +  phone_cliente[i] + " | " + name_cliente[i]);
        }
        System.out.println("##################################################################");
    }

    private static int[] dataDNICliente() {
        return new int[]{45645604, 54645566, 42342343, 42342214, 46532342, 34542423, 25422334, 23433444};
    }
    private static int[] dataTelefonoCliente() {
        return new int[]{921321231, 954645566, 942342343, 942342214, 946532342, 934542423, 925422334, 923433444};
    }

    private static String[] dataNombreCliente() {
        return new String[]{"Pedro", "Pablo", "María", "Juan", "Luis", "Antonio", "Julio", "Isabel"};
    }


}
