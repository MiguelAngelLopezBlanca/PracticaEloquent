package miguelangellopezblanca.psp.practicaeloquent.laravel.Pojo;

public class Judogui {

    private long id, idCompetidor;
    private String marca, modelo, imgJudogui, color;
    private int talla;
    private String created_at;
    private String updated_at;

    public Judogui(long idCompetidor, String marca, String modelo, String imgJudogui, String color, int talla) {
        this.idCompetidor = idCompetidor;
        this.marca = marca;
        this.modelo = modelo;
        this.imgJudogui = imgJudogui;
        this.color = color;
        this.talla = talla;
    }

    public Judogui() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCompetidor() {
        return idCompetidor;
    }

    public void setIdCompetidor(long idCompetidor) {
        this.idCompetidor = idCompetidor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getImgJudogui() {
        return imgJudogui;
    }

    public void setImgJudogui(String imgJudogui) {
        this.imgJudogui = imgJudogui;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Judogui{" +
                "id=" + id +
                ", idCompetidor=" + idCompetidor +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", imgJudogui='" + imgJudogui + '\'' +
                ", color='" + color + '\'' +
                ", talla=" + talla +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
