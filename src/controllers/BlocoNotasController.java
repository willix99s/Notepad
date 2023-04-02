package controllers;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import util.Interfaces.ManipularArquivos.Arquivos;
import util.Log.NaoTemNadaAqui;
import util.ManipulacaoDeArquivos.ArquivoTexto;

public class BlocoNotasController {

    @FXML
    private MenuItem abridorDeArquivo;

    @FXML
    private MenuItem ajuda;

    @FXML
    private TextArea areaTexto;

    @FXML
    private MenuItem salvadorDeArquivo;

    private Arquivos arquivos;

    @FXML
    void abrirArquivo(ActionEvent event) {
        Stage stg = new Stage();
        stg.setTitle("Abrir arquivo");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("src/tmp"));
        File selectedFile =  fileChooser.showOpenDialog(stg);
        this.arquivos = new ArquivoTexto();
        this.arquivos.setPATH(selectedFile.getAbsolutePath());
        try {
            this.areaTexto.appendText(this.arquivos.ler().mostrarPrimeiro().toString());
        } catch (NaoTemNadaAqui e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void abrirMenu(ActionEvent event) {

    }

    @FXML
    void salvarArquivo(ActionEvent event) {
        
    }

}
