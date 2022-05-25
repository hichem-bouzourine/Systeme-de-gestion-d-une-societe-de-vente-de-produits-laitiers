package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import methode.Agent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AgentCommercialC implements Initializable {


    private static Agent agent;
    @FXML
    private Button GP;
    @FXML private Button GC;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button retourBtn;

    @FXML
    private ImageView imageView,imageView2,imageView3, imageView4,imageView5;
    @FXML
    private Image image1 = new Image(getClass().getResourceAsStream("/Images/milky.png"));
    @FXML
    private Image image2 = new Image(getClass().getResourceAsStream("/Images/back.png"));
    @FXML
    private Image image3 = new Image(getClass().getResourceAsStream("/Images/agentCommercial.png"));

    @FXML
    private Image image4 = new Image(getClass().getResourceAsStream("/Images/modifierProduit.png"));

    @FXML
    private Image image5 = new Image(getClass().getResourceAsStream("/Images/gestionClient.png"));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imageView.setImage(image1);
        imageView2.setImage(image2);
        imageView3.setImage(image3);
        imageView4.setImage(image4);
        imageView5.setImage(image5);
        retourBtn.setGraphic(imageView2);
    }

    public AgentCommercialC() throws SQLException {
    }

    public void setAgentCommercial(Agent agent) {
        this.agent = agent;
    }

    public void GestionDesProduitsBouton()
    {
        Stage stage =(Stage)this.GP.getScene().getWindow();
        stage.close();

        try {
            Stage primaryStage =new Stage();

            Parent root= FXMLLoader.load(getClass().getResource("/AgentCommercial/ModifierProduit.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            System.out.println("Vous avez un probleme avec GestionProduits/UIProduits.fxml");
            e.printStackTrace();
        }
    }

    public void GestionDeClienteleBouton()
    {
        Stage stage =(Stage)this.GC.getScene().getWindow();
        stage.close();

        try {
            Stage primaryStage =new Stage();

            Parent root= FXMLLoader.load(getClass().getResource("/AgentCommercial/UIClientele.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            System.out.println("Vous avez un probleme avec GestionClientele/UIClientele.fxml");
            e.printStackTrace();
        }
    }

    public void switchToPreviousScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Login/Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
        stage.show();
    }

}
