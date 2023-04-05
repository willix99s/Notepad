package model;

import java.time.LocalDate;
import java.util.UUID;

public class Tarefa {
    // Exemplo:
    // Tipo - Escola. (Escola, DiaDia, Casa)
    // Descricacao - Fazer tarefa de geografia.
    // Data - Entregar na primeira semana de março.
    // Prioridade - 1. (1,2 e 3)

    private UUID id;

    private String nome;

    private String descricao;

    private LocalDate data;

    private Prioridade prioridade;

    public Tarefa(String nome, String descricao, LocalDate data, Prioridade prioridade) {

        this.id = UUID.randomUUID();
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.prioridade = prioridade;

    }

    public Tarefa(){
        this.id = UUID.randomUUID();
    }

    public UUID getID(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public void exibirTarefa() {
        System.out.println("Descrição: " + descricao);
        System.out.println("Data de vencimento: " + data);
        System.out.println("Nome: " + nome);
        System.out.println("Prioridade: " + prioridade);
        System.out.println("-----------");
    }
}
