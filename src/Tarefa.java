public class Tarefa {
    // Exemplo:
    // Tipo - Escola. (Escola, DiaDia, Casa)
    // Descricacao - Fazer tarefa de geografia.
    // Data - Entregar na primeira semana de março.
    // Prioridade - 1. (1,2 e 3)

    private String tipo;
    private String descricao;
    private String data;
    private int prioridade;

    public Tarefa(String tipo, String descricao, String data, int prioridade) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.data = data;
        this.prioridade = prioridade;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public void exibirTarefa() {
        System.out.println("Descrição: " + descricao);
        System.out.println("Data de vencimento: " + data);
        System.out.println("Tipo: " + tipo);
        System.out.println("Prioridade: " + prioridade);
        System.out.println("-----------");
    }
}
