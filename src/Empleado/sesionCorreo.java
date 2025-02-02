package Empleado;

public class sesionCorreo {
    private static String correo;
    private static int id;

    public static void setCorreo(String email) {
        correo = email;
    }

    public static String getCorreo() {
        return correo;
    }

    public static void setID(int userID){
        id = userID;
    }
    public static int getID(){
        return id;
    }
}
