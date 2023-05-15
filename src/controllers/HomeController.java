package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;
import java.io.File;

import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.Prioridade;
import model.Tarefa;
import service.GerenciadorTarefas;
import util.Interfaces.List.InterList;
import util.Iterator.IterarListaEncadeada;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HomeController<E> implements Initializable {

    @FXML
    private TableView<Tarefa> TABELA = new TableView<>();

    // @FXML
    // private TableColumn<Tarefa, ?> col_botao_abrir;

    // @FXML
    // private TableColumn<Tarefa, ?> col_botao_deletar;

    @FXML
    private TableColumn<Tarefa, LocalDate> col_data = new TableColumn<>("Data");

    @FXML
    private TableColumn<Tarefa, String> col_descricao = new TableColumn<>("Descricao");

    @FXML
    private TableColumn<Tarefa, UUID> col_id = new TableColumn<>("ID");

    @FXML
    private TableColumn<Tarefa, String> col_nome = new TableColumn<>("Nome");

    @FXML
    private TableColumn<Tarefa, Prioridade> col_prioridade = new TableColumn<>("Prioridade");

    @FXML
    private Pane CRIAR_MODAL_PANE;

    @FXML
    private Pane EDITAR_MODAL_PANE;

    @FXML
    private Pane TABELA_PANE;

    @FXML
    private Button atualizarBotaoEditar;

    @FXML
    private Button cancelarBotaoEditar;

    @FXML
    private Button cancelarBottaoAdd;

    @FXML
    private Button criarBotaoAdd;

    @FXML
    private Button criar_icon;

    @FXML
    private Button editar_icon;

    @FXML
    private Button home_icon;

    @FXML
    private Button logout_icon;

    @FXML
    private RadioMenuItem prioridade_alta;

    @FXML
    private RadioMenuItem prioridade_baixa;

    @FXML
    private RadioMenuItem prioridade_media;

    @FXML
    private RadioMenuItem tarefa_alta_editar;

    @FXML
    private RadioMenuItem tarefa_baixa_editar;

    @FXML
    private TextField tarefa_caminho_editar;

    @FXML
    private DatePicker tarefa_data;

    @FXML
    private TextField tarefa_descricao;

    @FXML
    private TextField tarefa_descricao_editar;

    @FXML
    private TextField tarefa_id_editar;

    @FXML
    private RadioMenuItem tarefa_media_editar;

    @FXML
    private TextField tarefa_nome;

    @FXML
    private TextField tarefa_nome_editar;

    private GerenciadorTarefas tarefas = new GerenciadorTarefas();

    private ObservableList<Tarefa> observableTarefas;

    private IterarListaEncadeada<Tarefa> iterarListaEncadeada;

    private List<Tarefa> lista = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarTabelaTarefas();
    }

    public void carregarTabelaTarefas(){

        this.col_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        this.col_nome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        this.col_descricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
        this.col_data.setCellValueFactory(new PropertyValueFactory<>("Data"));
        this.col_prioridade.setCellValueFactory(new PropertyValueFactory<>("Prioridade"));

        this.TABELA.getColumns().addAll(col_id, col_nome, col_descricao, col_data, col_prioridade);

        try {
            this.iterarListaEncadeada = this.tarefas.listar().getIterator();

            while(this.iterarListaEncadeada.hasNextDuplo()){
                this.lista.add(this.iterarListaEncadeada.getProximoDuplo().getValor());
            }

            this.observableTarefas = FXCollections.observableArrayList(
                this.lista
            );
            this.TABELA.setItems(observableTarefas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abrirModalCriar(ActionEvent event) {
        TABELA_PANE.setVisible(false);
        EDITAR_MODAL_PANE.setVisible(false);
        CRIAR_MODAL_PANE.setVisible(true);
    }

    private void addPrioridade(Tarefa task){
        if(this.prioridade_alta.isSelected()) task.setPrioridade(Prioridade.ALTA);
        else if(this.prioridade_media.isSelected()) task.setPrioridade(Prioridade.MEDIA);
        else task.setPrioridade(Prioridade.BAIXA);
    }

    @FXML
    void abrirModalEditar(ActionEvent event) {
        TABELA_PANE.setVisible(false);
        CRIAR_MODAL_PANE.setVisible(false);
        EDITAR_MODAL_PANE.setVisible(true);
    }

    @FXML
    void atualizar(ActionEvent event) {

    }

    @FXML
    void criarModalAdd(ActionEvent event) {
        Tarefa nova_tarefa = new Tarefa();
        nova_tarefa.setNome(this.tarefa_nome.getText());
        nova_tarefa.setDescricao(this.tarefa_descricao.getText());
        this.addPrioridade(nova_tarefa);
        nova_tarefa.setData(this.tarefa_data.getValue());
        this.tarefas.adicionarTarefa(nova_tarefa);
        CRIAR_MODAL_PANE.setVisible(false);
        TABELA_PANE.setVisible(true);
    }

    @FXML
    void fechar(ActionEvent event) {

    }

    @FXML
    void fecharEdicao(ActionEvent event) {
        EDITAR_MODAL_PANE.setVisible(false);
        TABELA_PANE.setVisible(true);
    }

    @FXML
    void fecharModalAdd(ActionEvent event) {
        CRIAR_MODAL_PANE.setVisible(false);
        TABELA_PANE.setVisible(true);
    }

    @FXML
    void irParaHome(ActionEvent event) {
        TABELA_PANE.setVisible(true);
        CRIAR_MODAL_PANE.setVisible(false);
        EDITAR_MODAL_PANE.setVisible(false);
    }
}
