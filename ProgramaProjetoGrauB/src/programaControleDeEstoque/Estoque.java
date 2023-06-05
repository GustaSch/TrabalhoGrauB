package programaControleDeEstoque;

import java.util.ArrayList;

public class Estoque {
    private ArrayList<Item> estoque = new ArrayList();

    public Estoque(ArrayList<Item> estoque) {
        this.estoque = estoque;
    }

    public ArrayList<Item> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<Item> estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Estoque: \n" +
                "estoque = " + estoque;
    }
}
