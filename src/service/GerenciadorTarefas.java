package service;

import java.util.UUID;

import model.Prioridade;
import model.Tarefa;
import util.Interfaces.List.InterList;
import util.Iterator.IterarListaEncadeada;
import util.List.DuplamenteEncadeada.ListaDuplamenteEncadeada;

public class GerenciadorTarefas {

    private InterList<Tarefa> tarefas;

    private IterarListaEncadeada<Tarefa> iterarTarefas;

    public GerenciadorTarefas(){
        this.tarefas = new ListaDuplamenteEncadeada<>();
    }

    public String adicionarTarefa(Tarefa tarefa){
        this.tarefas.adicionar(tarefa);
        return "Tarefa de id = [ " + tarefa.getID() + " ] adicionada";
    }

    public InterList<Tarefa> listar(){
        if(this.tarefas != null) return this.tarefas;
        else return null;
    }

    public InterList<Tarefa> listarPorPrioridade(Prioridade prioridade){
        InterList<Tarefa> listaPrioridade = new ListaDuplamenteEncadeada<>();
        this.iterarTarefas = this.tarefas.getIterator();
        while (this.iterarTarefas.hasNextDuplo()) {
            if(this.iterarTarefas.getProximoDuplo().getValor().getPrioridade().equals(prioridade)){
                listaPrioridade.adicionar(this.iterarTarefas.getProximoDuplo().getValor());
            }
        }
        return listaPrioridade;
    }

    public Tarefa buscarPorNome(String nome){
        this.iterarTarefas = this.tarefas.getIterator();
        Tarefa tarefa = null;
        while (this.iterarTarefas.hasNextDuplo()) {
            if(this.iterarTarefas.getProximoDuplo().getValor().getNome().equals(nome)){
                tarefa = this.iterarTarefas.getProximoDuplo().getValor();
                break;
            }
        }
        return tarefa;
    }

    public Tarefa buscarPorId(UUID id){
        this.iterarTarefas = this.tarefas.getIterator();
        Tarefa tarefa = null;
        while (this.iterarTarefas.hasNextDuplo()) {
            if(this.iterarTarefas.getProximoDuplo().getValor().getID().equals(id)){
                tarefa = this.iterarTarefas.getProximoDuplo().getValor();
                break;
            }
        }
        return tarefa;
    }

    public Integer totalTarefas(){
        return this.tarefas.getSize();
    }

    public String remover(UUID id){
        Tarefa tarefa = buscarPorId(id);
        this.tarefas.remover(tarefa);
        return "Tarefa de id [ " + tarefa.getID() + " ] removido";
    }

    public String atualizar(UUID id, Tarefa att){
        Tarefa tarefa = buscarPorId(id);
        Tarefa prev = tarefa;

         // NOME
        if(!tarefa.getNome().equals(att.getNome())){
            tarefa.setNome(att.getNome());
        } else {
            tarefa.setNome(prev.getNome());
        }

        // DESCRIÇÃO
        if(!tarefa.getDescricao().equals(att.getDescricao())){
            tarefa.setDescricao(att.getDescricao());
        } else {
            tarefa.setDescricao(prev.getDescricao());
        }

        // PRIORIDADE
        if(!tarefa.getPrioridade().equals(att.getPrioridade())){
            tarefa.setPrioridade(att.getPrioridade());
        } else {
            tarefa.setPrioridade(prev.getPrioridade());
        }

        // DATA
        if(!tarefa.getData().equals(att.getData())){
            tarefa.setData(att.getData());
        } else {
            tarefa.setData(prev.getData());
        }
        
        return "Tarefa de id [ " + tarefa.getID() + " ] atualizado";
    }

}
