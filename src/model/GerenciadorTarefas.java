package model;

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
                    break;
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
}
