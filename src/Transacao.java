import java.time.LocalDate;

public class Transacao {
    
    private static int proximoId = 1;
    private int id;
    private String descricao;
    private double valor;
    private LocalDate dataTransacao;
    private boolean entrada;


    public Transacao(String descricao, double valor, boolean entrada) {
        this.descricao = descricao;
        this.valor = valor;
        this.entrada = entrada;

        this.id = proximoId++;
        this.dataTransacao = LocalDate.now();

    }

    public int getId() {
        return id;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public double getValor() {
        return valor;
    }


    public void setValor(double valor) {
        this.valor = valor;
    }


    public LocalDate getDataTransacao() {
        return dataTransacao;
    }


    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }


    public boolean isEntrada() {
        return entrada;
    }


    public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }

    
    public void mostrarDados() {

        String tipo;

        if (entrada) {
            tipo = "Entrada";
        } else {
            tipo = "Saída";
        }

        System.out.println("ID: " + id);
        System.out.println("Descrição: " + descricao);
        System.out.println("Valor: R$ " + valor);
        System.out.println("Tipo: " + tipo);
        System.out.println("Data: " + dataTransacao);
    }
    
    


}
