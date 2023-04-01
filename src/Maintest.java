import java.io.IOException;

public class Maintest {
    public static void main(String[] args) {
            GerenciadorTarefas gt = new GerenciadorTarefas(10);
        gt.adicionarTarefa(new Tarefa("Escola", "Fazer tarefa de geografia", "01/03/2023", 1));
        gt.adicionarTarefa(new Tarefa("Casa", "Fazer compras no supermercado", "05/03/2023", 2));
        gt.adicionarTarefa(new Tarefa("DiaDia", "Marcar consulta no médico", "10/03/2023", 3));

        // GerenciadorTarefas gerenciador = new GerenciadorTarefas(5);
        // Tarefa t1 = new Tarefa("Escola", "Fazer tarefa de matemática", "2023-04-05", 2);
        // Tarefa t2 = new Tarefa("DiaDia", "Ir ao supermercado", "2023-04-02", 1);
        // Tarefa t3 = new Tarefa("Casa", "Lavar louça", "2023-04-03", 3);
        // gerenciador.adicionarTarefa(t1);
        // gerenciador.adicionarTarefa(t2);
        // gerenciador.adicionarTarefa(t3);

        // Remove a segunda tarefa
        // gerenciador.apagarTarefa(1);

        // Exibe as tarefas adicionadas
        for (Tarefa tarefa : gt.getTarefas()) {
            if (tarefa != null) {
                tarefa.exibirTarefa();
            }
        }
    
    try {
        gt.salvarTarefas("Notas.txt");
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
