public class Nacional extends Producto {
    private String registroDIAN;

    public Nacional(int codigo, String nombre, String registroDIAN) {
        super(codigo, nombre);
        this.registroDIAN = registroDIAN;
    }

    public String getRegistroDIAN() {
        return registroDIAN;
    }
}