package dia11.ejerciciosPropios11.models;




public class Alfajor
{
    private static int id;
    private int ownId;
    private long lote;
    private String type;
    private int stock;

    public Alfajor(String type, int stock, long lote) {
        this.type = type;
        this.lote = lote;
        this.stock = stock;
        id++;
        ownId = id;
    }

    public static int getId() {
        return id;
    }

    public int getOwnId() {
        return ownId;
    }

    public void setOwnId(int ownId) {
        this.ownId = ownId;
    }

    public long getLote() {
        return lote;
    }

    public void setLote(long lote) {
        this.lote = lote;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
