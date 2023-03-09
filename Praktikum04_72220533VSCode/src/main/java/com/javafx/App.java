package com.javafx;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*  1. pop up input salah dan input dibuang tapi data lama tetap disimpan
    2. felxible tampungan array 
    3. delete data
    4. Bubble sort belum jadi
    5. 
*/
public class App extends Application {
    Text txtJudul = new Text("Data Mahasiswa");
    Label lblNim = new Label("Nim");
    Label lblNama = new Label("Nama");
    Label lblKota = new Label("Kota");
    Label lblSemua = new Label("Daftar Mahasiswa :");
    Label lblUrut = new Label("Urut berdasarkan");
    Label lblOrder = new Label("Jenis Urutan");
    TextField txtNim = new TextField();
    TextField txtNama = new TextField();
    TextField txtKota = new TextField();
    TextArea txtDaftar = new TextArea();
    Button btnTambah = new Button("Tambah");
    Button btnProcess = new Button("Proses Bubble Sort");
    Button btnClose = new Button("Tutup");
    ComboBox cbUrut = new ComboBox();
    ComboBox cbOrder = new ComboBox();
    HBox hb1 = new HBox();
    HBox hb2 = new HBox();
    HBox hb3 = new HBox();

    public static void errorDisplay(String message) {
        // tampilkan error, buang data error, cleartextfield
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("An error has occured");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void cleartextfield() {
        txtNim.clear();
        txtKota.clear();
        txtNama.clear();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        txtJudul.setFont(Font.font("Arial", 28));
        hb1.getChildren().add(btnTambah);
        hb1.setAlignment(Pos.BASELINE_RIGHT);
        hb2.getChildren().add(btnClose);
        hb2.setAlignment(Pos.BOTTOM_RIGHT);
        hb3.getChildren().addAll(cbOrder, btnProcess);
        hb3.setSpacing(5);
        txtNim.setMaxWidth(80);
        txtDaftar.setMinHeight(300);
        cbUrut.getItems().addAll("Nim", "Nama", "Kota");
        cbUrut.setValue("Nim");
        cbOrder.getItems().addAll("Ascending", "Descending");
        cbOrder.setValue("Ascending");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(3);
        grid.setHgap(10);
        grid.setGridLinesVisible(false);
        grid.add(txtJudul, 0, 0, 2, 1);
        grid.add(lblNim, 0, 1);
        grid.add(txtNim, 1, 1);
        grid.add(lblNama, 0, 2);
        grid.add(txtNama, 1, 2);
        grid.add(lblKota, 0, 3);
        grid.add(txtKota, 1, 3);
        grid.add(hb1, 1, 4);
        grid.add(lblUrut, 0, 5);
        grid.add(cbUrut, 1, 5);
        grid.add(lblOrder, 0, 6);
        grid.add(hb3, 1, 6);
        grid.add(lblSemua, 0, 7);
        grid.add(txtDaftar, 0, 8, 2, 1);
        grid.add(hb2, 0, 9, 2, 1);

        DaftarMahasiswa list = new DaftarMahasiswa(1);

        /* Event Handler btnTambah */
        btnTambah.setOnAction(new EventHandler<ActionEvent>() {
            String addNama, addNim, addKota;

            @Override
            public void handle(ActionEvent e) {
                addNama = txtNama.getText();
                addNim = txtNim.getText();
                addKota = txtKota.getText();
                list.tambah(addNim, addNama, addKota);
                if (list.getCekNim()) {
                    if (list.getCekString()) {
                        txtDaftar.setText(list.getAll());
                        cleartextfield();
                        txtNim.requestFocus();
                    } else {
                        cleartextfield();
                        list.deleteData();
                        errorDisplay("Nama yang anda masukkan salah  ");
                        txtNim.requestFocus();
                    }
                } else {
                    cleartextfield();
                    list.deleteData();
                    errorDisplay("NIM yang anda masukkan salah  ");
                    txtNim.requestFocus();
                }

            }
        });

        btnProcess.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (cbUrut.getValue().equals("Nim")) {
                    if(cbOrder.getValue().equals("Ascending")){
                        list.bubbleNIM("Ascending");
                        txtDaftar.setText(list.getAll());
                    }else{
                        list.bubbleNIM("Descending");
                        txtDaftar.setText(list.getAll());
                    }
                } else if (cbUrut.getValue().equals("Nama")) {
                    if(cbOrder.getValue().equals("Ascending")){
                        list.bubbleNama("Ascending");
                        txtDaftar.setText(list.getAll());
                    }else{
                        list.bubbleNama("Descending");
                        txtDaftar.setText(list.getAll());
                    }
                } else if (cbUrut.getValue().equals("Kota")) {
                    if(cbOrder.getValue().equals("Ascending")){
                        list.bubbleKota("Ascending");
                        txtDaftar.setText(list.getAll());
                    }else{
                        list.bubbleKota("Descending");
                        txtDaftar.setText(list.getAll());
                    }
                }
            }
        });
        /* Event Handler btnClose */
        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.exit(0);
            }
        });

        // grid.setGridLinseVisible(true);
        Scene scene = new Scene(grid, 500, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Data Mahasiswa");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}