package model;
import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorTarefas {
        private Tarefa[] tarefas;

        public GerenciadorTarefas(int tamanho) {
            tarefas = new Tarefa[tamanho];
        }

        //Get e Set
        public Tarefa[] getTarefas() {
            return tarefas;
        }
        
        public void setTarefas(Tarefa[] tarefas) {
            this.tarefas = tarefas;
        }

        public void adicionarTarefa(Tarefa tarefa) {
            // Encontra o primeiro elemento vazio no array e adiciona a tarefa.
            for (int index = 0; index < tarefas.length; index++) {
                if (tarefas[index] == null) {
                    tarefas[index] = tarefa;
                    return;
                }               
            }
            // Se não houver espaço disponível, lançar uma exceção.
            throw new RuntimeException("Não há espaço disponível para adicionar mais tarefas.");
        }

        public void apagarTarefa(int indice) {
            if (indice < 0 || indice >= tarefas.length) {
            throw new IllegalArgumentException("Índice inválido.");
            }
            tarefas[indice] = null;
            }

        // Salvar em um arquivo de texto.
        public void salvarTarefas(String nomeArquivo) throws IOException {
            FileWriter fw = new FileWriter(nomeArquivo);
            for (Tarefa t : tarefas) {
                if (t != null) {
                    fw.write(t.getTipo() + "," + t.getDescricao() + "," + t.getData() + "," + t.getPrioridade() + "\n");
                }
            }
            fw.close();
        }
        

}
