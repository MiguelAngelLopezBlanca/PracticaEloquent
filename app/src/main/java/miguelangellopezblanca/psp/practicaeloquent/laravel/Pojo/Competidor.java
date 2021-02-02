package miguelangellopezblanca.psp.practicaeloquent.laravel.Pojo;

public class Competidor {

    private long id;
    private String nombre, apellidos, imgCompetidor;
    private int edad;

    public Competidor(String nombre, String apellidos, int edad, String imgCompetidor) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.imgCompetidor = imgCompetidor;
        this.edad = edad;
    }

    public Competidor() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getImgCompetidor() {
        return imgCompetidor;
    }

    public void setImgCompetidor(String imgCompetidor) {
        this.imgCompetidor = imgCompetidor;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Competidor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", imgCompetidor='" + imgCompetidor + '\'' +
                ", edad=" + edad +
                '}';
    }
}
