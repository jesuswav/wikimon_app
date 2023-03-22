package com.example.wikimon_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;


public class HelloController {

    //Search button

    @FXML
    private Button search_button;

    //Buttons of vista1
    @FXML
    private Button button_1;
    @FXML
    private Button button_2;
    @FXML
    private Button button_3;
    @FXML
    private Button button_4;
    @FXML
    private Button button_5;
    @FXML
    private Button button_6;
    @FXML
    private Button button_7;
    @FXML
    private Button button_8;

    //Buttons of view two
    @FXML
    private Button buttonBack;

    //Imagenes de la vista_1 ---------------------
    @FXML
    private ImageView imagen_1;
    @FXML
    private ImageView imagen_2;
    @FXML
    private ImageView imagen_3;
    @FXML
    private ImageView imagen_4;
    @FXML
    private ImageView imagen_5;
    @FXML
    private ImageView imagen_6;
    @FXML
    private ImageView imagen_7;
    @FXML
    private ImageView imagen_8;


    //-------------------------------
    //Labels of information that comes from BBDD
    @FXML
    private Label label_category;
    @FXML
    private Label label_element;
    @FXML
    private Label label_heigth;
    @FXML
    private Label label_name;
    @FXML
    private Label label_pokeball;
    @FXML
    private Label label_wigth;

    //Image of the pokemon in the detailed view
    @FXML
    private ImageView pokemon_image;

    //TextFields where the information of the BBDD will to show
    @FXML
    private TextField text_category;
    @FXML
    private TextField text_element;
    @FXML
    private TextField text_heigth;
    @FXML
    private TextField text_name;
    @FXML
    private TextField text_pokeball;
    @FXML
    private TextField text_weigth;

    //Radio Buttons to select the evlution of the caracter in the image
    @FXML
    private RadioButton radio_evolution1;
    @FXML
    private RadioButton radio_evolution2;


    //objects Image for the ImageView´s
    //Image imagen1 = new Image(getClass().getResourceAsStream("/src/main/resources/Chikorita_E1.jpg"));
    Image imagen1 = new Image(String.valueOf(new File("C:\\Users\\walte\\IdeaProjects\\wikimon_app\\src\\main\\java\\com\\example\\wikimon_app\\Chikorita_E1.jpg")));

    //Function to go to the next view using setVisible -------
    @FXML
    void pasarVista2(ActionEvent event) {

        //We make the buttons of view_1 invisible
        button_1.setVisible(false);
        button_2.setVisible(false);
        button_3.setVisible(false);
        button_4.setVisible(false);
        button_5.setVisible(false);
        button_6.setVisible(false);
        button_7.setVisible(false);
        button_8.setVisible(false);

        //We make the images of view_1 invisible
        imagen_1.setVisible(false);
        imagen_2.setVisible(false);
        imagen_3.setVisible(false);
        imagen_4.setVisible(false);
        imagen_5.setVisible(false);
        imagen_6.setVisible(false);
        imagen_7.setVisible(false);
        imagen_8.setVisible(false);

        //We make the labels of view_2 visible
        label_name.setVisible(true);
        label_wigth.setVisible(true);
        label_heigth.setVisible(true);
        label_category.setVisible(true);
        label_element.setVisible(true);
        label_pokeball.setVisible(true);

        //We make the TextFields of view_2 visible
        text_name.setVisible(true);
        text_weigth.setVisible(true);
        text_heigth.setVisible(true);
        text_category.setVisible(true);
        text_element.setVisible(true);
        text_pokeball.setVisible(true);

        pokemon_image.setVisible(true);

        radio_evolution1.setVisible(true);
        radio_evolution2.setVisible(true);


        //Set the values fot the view two

        pokemon_image.setImage(imagen1);

        //We use the property visible to make this button appears in the view
        buttonBack.setVisible(true);
    }

    @FXML
    void goToViewOne(ActionEvent event) {

        //We make the buttons of the view1 visible again
        button_1.setVisible(true);
        button_2.setVisible(true);
        button_3.setVisible(true);
        button_4.setVisible(true);
        button_5.setVisible(true);
        button_6.setVisible(true);
        button_7.setVisible(true);
        button_8.setVisible(true);

        //We make the images of the view1 visible again
        imagen_1.setVisible(true);
        imagen_2.setVisible(true);
        imagen_3.setVisible(true);
        imagen_4.setVisible(true);
        imagen_5.setVisible(true);
        imagen_6.setVisible(true);
        imagen_7.setVisible(true);
        imagen_8.setVisible(true);

        //we make insisible the labels of view2 again
        label_name.setVisible(false);
        label_wigth.setVisible(false);
        label_heigth.setVisible(false);
        label_category.setVisible(false);
        label_element.setVisible(false);
        label_pokeball.setVisible(false);

        //we make insisible the TextFields of view2 again
        text_name.setVisible(false);
        text_weigth.setVisible(false);
        text_heigth.setVisible(false);
        text_category.setVisible(false);
        text_element.setVisible(false);
        text_pokeball.setVisible(false);

        //we make insisible the image of view2 of view2 again
        pokemon_image.setVisible(false);

        //we make insisible the RadioButtons of view2 of view2 again
        radio_evolution1.setVisible(false);
        radio_evolution2.setVisible(false);

        buttonBack.setVisible(false);
    }

    @FXML
    void showPokemon(ActionEvent event) {
        imagen_1.setImage(imagen1);
    }

}