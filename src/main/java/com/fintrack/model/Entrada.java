package main.java.com.fintrack.model;

public class Entrada extends Transacao {

    public Entrada(String descricao, double valor) {
        super(descricao, valor);
    }

    @Override
    public double getImpactoSaldo() {
        return getValor();
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Tipo: Entrada");
    }


}
