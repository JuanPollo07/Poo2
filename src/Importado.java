public class Importado extends Producto {
    private String licenciaImportacion;

    public Importado(int codigo, String nombre, String licenciaImportacion) {
        super(codigo, nombre);
        this.licenciaImportacion = licenciaImportacion;
    }

    public String getLicenciaImportacion() {
        return licenciaImportacion;
    }
}