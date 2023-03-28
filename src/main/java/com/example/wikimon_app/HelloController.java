package com.example.wikimon_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;


public class HelloController {

    ArrayList<Integer> randomIndex = new ArrayList<>();

    //declaration of the objects to show the images

    //Evolutions images for the detailed view

    //Global variables
    public boolean view_one;
    public boolean view_two;
    public boolean view_three;

    //Search button and TextField

    @FXML
    private Button search_button;
    @FXML
    private TextField searchText;

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

    @FXML
    private Button buttonBattle;

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

    //image views for similar pokemons
    @FXML
    private ImageView similar_pokemon1;
    @FXML
    private ImageView similar_pokemon2;
    @FXML
    private ImageView similar_pokemon3;

    //TextArea and label for the description of the pokemon
    @FXML
    private TextArea text_area_descripcion;
    @FXML
    private Label label_descripcion;

    //ImageView for evolutions of the pokemon
    @FXML
    private ImageView img_evolucion1;
    @FXML
    private ImageView img_evolucion2;

    //------------------------view submit ----------------------------------------------------------
    @FXML
    private Button button_submit;
    @FXML
    private Label label_description_send;
    @FXML
    private Label label_element_send;
    @FXML
    private Label label_evo1_send;
    @FXML
    private Label label_evo2_send;
    @FXML
    private Label label_height_send;
    @FXML
    private Label label_image_send;
    @FXML
    private Label label_name_send;
    @FXML
    private Label label_pokeball_send;
    @FXML
    private Label label_weight_send;
    @FXML
    private Label label_category_send;
    @FXML
    private TextField text_category_send;
    @FXML
    private TextField text_element_send;
    @FXML
    private TextField text_evo1_send;
    @FXML
    private TextField text_evo2_send;
    @FXML
    private TextField text_height_send;
    @FXML
    private TextField text_image_send;
    @FXML
    private TextField text_name_send;
    @FXML
    private TextField text_pokeball_send;
    @FXML
    private TextField text_weight_send;
    @FXML
    private TextArea text_area_description_send;
    @FXML
    private Button button_add_pokemon;

    //----------------------------------------end view submit--------------------

    //##########################################################################
    //Button of the first view in the program
    @FXML
    private Button button_tittle;

    //Tittle of the first view
    @FXML
    private Label label_tittle;

    //------------------Methods--------------------------------

    //Function to go to the next view using setVisible -------
    @FXML
    void goToViewTree() {
        view_one = false;
        view_two = false;
        view_three = true;

        //---------------------------buttons visible of view one----------------------------
        //We make the buttons of view_2 invisible
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


        //---------------------elements of view3 visible------------------------
        //We make the labels of view_2 visible
        label_name.setVisible(true);
        label_wigth.setVisible(true);
        label_heigth.setVisible(true);
        label_category.setVisible(true);
        label_element.setVisible(true);
        label_pokeball.setVisible(true);

        //We make the TextFields of view_3 visible
        text_name.setVisible(true);
        text_weigth.setVisible(true);
        text_heigth.setVisible(true);
        text_category.setVisible(true);
        text_element.setVisible(true);
        text_pokeball.setVisible(true);

        pokemon_image.setVisible(true);

        //modifications of the visible property for the last objects of view3
        similar_pokemon1.setVisible(true);
        similar_pokemon2.setVisible(true);
        similar_pokemon3.setVisible(true);

        text_area_descripcion.setVisible(true);

        img_evolucion1.setVisible(true);
        img_evolucion2.setVisible(true);
        label_descripcion.setVisible(true);

        buttonBattle.setVisible(false);

        //Button of back to the view one
        if (view_three == true) {
            buttonBack.setVisible(true);
        }
    }

    boolean ejecucionRead = false;

    @FXML
    void goToViewTwo(ActionEvent event) {

        //we call to the method that will pull the information from the BBDD
        //conditional to check if the method is already called
        if (ejecucionRead == false) {
            PokemonsDAO.readRegisters();

            for (int i = 0; i <= (PokemonsDAO.image_routes.size()-1); i++) {
                randomIndex.add(i);
            }
        }

        //pokemons that will be in the ImageViews

        Collections.shuffle(randomIndex);
        System.out.println("Lista desordenada");
        System.out.println(randomIndex);

        System.out.println("Ids");
        System.out.println(PokemonsDAO.ids);

        //setting the images to the ImagesViews
        Image imagen1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(0)))));
        imagen_1.setImage(imagen1);

        Image imagen2 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(1)))));
        imagen_2.setImage(imagen2);

        Image imagen3 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(2)))));
        imagen_3.setImage(imagen3);

        Image imagen4 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(3)))));
        imagen_4.setImage(imagen4);

        Image imagen5 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(4)))));
        imagen_5.setImage(imagen5);

        Image imagen6 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(5)))));
        imagen_6.setImage(imagen6);

        Image imagen7 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(6)))));
        imagen_7.setImage(imagen7);

        Image imagen8 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(7)))));
        imagen_8.setImage(imagen8);

        //-----------------------------------------------------------

        view_one = false;
        view_two = true;
        view_three = false;

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

        button_add_pokemon.setVisible(true);

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

        //we make the elements of the first view invisible
        button_tittle.setVisible(false);
        label_tittle.setVisible(false);

        //we make visible the button of search and the TextField
        search_button.setVisible(true);
        searchText.setVisible(true);

        //modifications of the visible property for the last objects of view3
        similar_pokemon1.setVisible(false);
        similar_pokemon2.setVisible(false);
        similar_pokemon3.setVisible(false);

        text_area_descripcion.setVisible(false);
        label_descripcion.setVisible(false);

        img_evolucion1.setVisible(false);
        img_evolucion2.setVisible(false);

        //we make invisible the view submit
        button_submit.setVisible(false);
        label_description_send.setVisible(false);
        label_element_send.setVisible(false);
        label_evo1_send.setVisible(false);
        label_evo2_send.setVisible(false);
        label_height_send.setVisible(false);
        label_image_send.setVisible(false);
        label_name_send.setVisible(false);
        label_pokeball_send.setVisible(false);
        label_weight_send.setVisible(false);
        label_category_send.setVisible(false);
        text_category_send.setVisible(false);
        text_area_description_send.setVisible(false);
        text_element_send.setVisible(false);
        text_evo1_send.setVisible(false);
        text_evo2_send.setVisible(false);
        text_height_send.setVisible(false);
        text_image_send.setVisible(false);
        text_name_send.setVisible(false);
        text_pokeball_send.setVisible(false);
        text_weight_send.setVisible(false);

        //--------
        //Button to go to the view submit
        button_add_pokemon.setVisible(true);
        buttonBattle.setVisible(true);

        buttonBack.setVisible(false);
        ejecucionRead = true;
    }

    @FXML
    void goToViewBattle(ActionEvent event){
        //We make the buttons of the view1 visible again
        button_1.setVisible(false);
        button_2.setVisible(false);
        button_3.setVisible(false);
        button_4.setVisible(false);
        button_5.setVisible(false);
        button_6.setVisible(false);
        button_7.setVisible(false);
        button_8.setVisible(false);

        //We make the images of the view1 visible again
        imagen_1.setVisible(false);
        imagen_2.setVisible(false);
        imagen_3.setVisible(false);
        imagen_4.setVisible(false);
        imagen_5.setVisible(false);
        imagen_6.setVisible(false);
        imagen_7.setVisible(false);
        imagen_8.setVisible(false);

        button_add_pokemon.setVisible(false);

        button_add_pokemon.setVisible(false);
        buttonBattle.setVisible(false);
        search_button.setVisible(false);
        searchText.setVisible(false);

        label_tittle.setVisible(true);
        button_tittle.setVisible(true);
    }

    @FXML
    void showPokemon(ActionEvent event) {
        //imagen_1.setImage(imagen1);
    }

    @FXML
    void goToViewSubmit(ActionEvent event) {

        //we make visible the elements of view submit
        button_submit.setVisible(true);
        label_description_send.setVisible(true);
        label_element_send.setVisible(true);
        label_evo1_send.setVisible(true);
        label_evo2_send.setVisible(true);
        label_height_send.setVisible(true);
        label_image_send.setVisible(true);
        label_name_send.setVisible(true);
        label_pokeball_send.setVisible(true);
        label_weight_send.setVisible(true);
        label_category_send.setVisible(true);
        text_category_send.setVisible(true);
        text_area_description_send.setVisible(true);
        text_element_send.setVisible(true);
        text_evo1_send.setVisible(true);
        text_evo2_send.setVisible(true);
        text_height_send.setVisible(true);
        text_image_send.setVisible(true);
        text_name_send.setVisible(true);
        text_pokeball_send.setVisible(true);
        text_weight_send.setVisible(true);

        search_button.setVisible(true);
        searchText.setVisible(true);

        buttonBack.setVisible(true);

        //---------------------------view two invisible--------------------------
        //We make the buttons of the view1 visible again
        button_1.setVisible(false);
        button_2.setVisible(false);
        button_3.setVisible(false);
        button_4.setVisible(false);
        button_5.setVisible(false);
        button_6.setVisible(false);
        button_7.setVisible(false);
        button_8.setVisible(false);

        //We make the images of the view1 visible again
        imagen_1.setVisible(false);
        imagen_2.setVisible(false);
        imagen_3.setVisible(false);
        imagen_4.setVisible(false);
        imagen_5.setVisible(false);
        imagen_6.setVisible(false);
        imagen_7.setVisible(false);
        imagen_8.setVisible(false);

    }

    //Methods to buttons Detalles ------------------------------
    @FXML
    void detalles1(ActionEvent event){
        goToViewTree();
        text_name.setText(PokemonsDAO.names.get(randomIndex.get(0)));
        Image imagen1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(0)))));
        pokemon_image.setImage(imagen1);
        text_weigth.setText(PokemonsDAO.weights.get(randomIndex.get(0)));
        text_heigth.setText(PokemonsDAO.heights.get(randomIndex.get(0)));
        text_category.setText(PokemonsDAO.categories.get(randomIndex.get(0)));
        text_element.setText(PokemonsDAO.elements.get(randomIndex.get(0)));
        Image imagenEvo1 = new Image(String.valueOf(new File(PokemonsDAO.evolution_1_routes.get(randomIndex.get(0)))));
        img_evolucion1.setImage(imagenEvo1);
        Image imagenEvo2 = new Image(String.valueOf(new File(PokemonsDAO.evolution_2_routes.get(randomIndex.get(0)))));
        img_evolucion2.setImage(imagenEvo2);
        text_pokeball.setText(PokemonsDAO.pokeball_types.get(randomIndex.get(0)));
        text_area_descripcion.setText(PokemonsDAO.descriptions.get(randomIndex.get(0)));

        Image pokemonSimilar1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(4)))));
        similar_pokemon1.setImage(pokemonSimilar1);
        Image pokemonSimilar2 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(1)))));
        similar_pokemon2.setImage(pokemonSimilar2);
        Image pokemonSimilar3 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(2)))));
        similar_pokemon3.setImage(pokemonSimilar3);
    }
    @FXML
    void detalles2(ActionEvent event){
        goToViewTree();
        text_name.setText(PokemonsDAO.names.get(randomIndex.get(1)));
        Image imagen1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(1)))));
        pokemon_image.setImage(imagen1);
        text_weigth.setText(PokemonsDAO.weights.get(randomIndex.get(1)));
        text_heigth.setText(PokemonsDAO.heights.get(randomIndex.get(1)));
        text_category.setText(PokemonsDAO.categories.get(randomIndex.get(1)));
        text_element.setText(PokemonsDAO.elements.get(randomIndex.get(1)));
        Image imagenEvo1 = new Image(String.valueOf(new File(PokemonsDAO.evolution_1_routes.get(randomIndex.get(1)))));
        img_evolucion1.setImage(imagenEvo1);
        Image imagenEvo2 = new Image(String.valueOf(new File(PokemonsDAO.evolution_2_routes.get(randomIndex.get(1)))));
        img_evolucion2.setImage(imagenEvo2);
        text_pokeball.setText(PokemonsDAO.pokeball_types.get(randomIndex.get(1)));
        text_area_descripcion.setText(PokemonsDAO.descriptions.get(randomIndex.get(1)));

        Image pokemonSimilar1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(7)))));
        similar_pokemon1.setImage(pokemonSimilar1);
        Image pokemonSimilar2 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(5)))));
        similar_pokemon2.setImage(pokemonSimilar2);
        Image pokemonSimilar3 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(3)))));
        similar_pokemon3.setImage(pokemonSimilar3);
    }
    @FXML
    void detalles3(ActionEvent event){
        goToViewTree();
        text_name.setText(PokemonsDAO.names.get(randomIndex.get(2)));
        Image imagen1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(2)))));
        pokemon_image.setImage(imagen1);
        text_weigth.setText(PokemonsDAO.weights.get(randomIndex.get(2)));
        text_heigth.setText(PokemonsDAO.heights.get(randomIndex.get(2)));
        text_category.setText(PokemonsDAO.categories.get(randomIndex.get(2)));
        text_element.setText(PokemonsDAO.elements.get(randomIndex.get(2)));
        Image imagenEvo1 = new Image(String.valueOf(new File(PokemonsDAO.evolution_1_routes.get(randomIndex.get(2)))));
        img_evolucion1.setImage(imagenEvo1);
        Image imagenEvo2 = new Image(String.valueOf(new File(PokemonsDAO.evolution_2_routes.get(randomIndex.get(2)))));
        img_evolucion2.setImage(imagenEvo2);
        text_pokeball.setText(PokemonsDAO.pokeball_types.get(randomIndex.get(2)));
        text_area_descripcion.setText(PokemonsDAO.descriptions.get(randomIndex.get(2)));

        Image pokemonSimilar1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(5)))));
        similar_pokemon1.setImage(pokemonSimilar1);
        Image pokemonSimilar2 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(4)))));
        similar_pokemon2.setImage(pokemonSimilar2);
        Image pokemonSimilar3 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(6)))));
        similar_pokemon3.setImage(pokemonSimilar3);
    }
    @FXML
    void detalles4(ActionEvent event){
        goToViewTree();
        text_name.setText(PokemonsDAO.names.get(randomIndex.get(3)));
        Image imagen1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(3)))));
        pokemon_image.setImage(imagen1);
        text_weigth.setText(PokemonsDAO.weights.get(randomIndex.get(3)));
        text_heigth.setText(PokemonsDAO.heights.get(randomIndex.get(3)));
        text_category.setText(PokemonsDAO.categories.get(randomIndex.get(3)));
        text_element.setText(PokemonsDAO.elements.get(randomIndex.get(3)));
        Image imagenEvo1 = new Image(String.valueOf(new File(PokemonsDAO.evolution_1_routes.get(randomIndex.get(3)))));
        img_evolucion1.setImage(imagenEvo1);
        Image imagenEvo2 = new Image(String.valueOf(new File(PokemonsDAO.evolution_2_routes.get(randomIndex.get(3)))));
        img_evolucion2.setImage(imagenEvo2);
        text_pokeball.setText(PokemonsDAO.pokeball_types.get(randomIndex.get(3)));
        text_area_descripcion.setText(PokemonsDAO.descriptions.get(randomIndex.get(3)));

        Image pokemonSimilar1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(2)))));
        similar_pokemon1.setImage(pokemonSimilar1);
        Image pokemonSimilar2 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(5)))));
        similar_pokemon2.setImage(pokemonSimilar2);
        Image pokemonSimilar3 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(7)))));
        similar_pokemon3.setImage(pokemonSimilar3);
    }
    @FXML
    void detalles5(ActionEvent event){
        goToViewTree();
        text_name.setText(PokemonsDAO.names.get(randomIndex.get(4)));
        Image imagen1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(4)))));
        pokemon_image.setImage(imagen1);
        text_weigth.setText(PokemonsDAO.weights.get(randomIndex.get(4)));
        text_heigth.setText(PokemonsDAO.heights.get(randomIndex.get(4)));
        text_category.setText(PokemonsDAO.categories.get(randomIndex.get(2)));
        text_element.setText(PokemonsDAO.elements.get(randomIndex.get(4)));
        Image imagenEvo1 = new Image(String.valueOf(new File(PokemonsDAO.evolution_1_routes.get(randomIndex.get(4)))));
        img_evolucion1.setImage(imagenEvo1);
        Image imagenEvo2 = new Image(String.valueOf(new File(PokemonsDAO.evolution_2_routes.get(randomIndex.get(4)))));
        img_evolucion2.setImage(imagenEvo2);
        text_pokeball.setText(PokemonsDAO.pokeball_types.get(randomIndex.get(4)));
        text_area_descripcion.setText(PokemonsDAO.descriptions.get(randomIndex.get(4)));

        Image pokemonSimilar1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(3)))));
        similar_pokemon1.setImage(pokemonSimilar1);
        Image pokemonSimilar2 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(5)))));
        similar_pokemon2.setImage(pokemonSimilar2);
        Image pokemonSimilar3 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(7)))));
        similar_pokemon3.setImage(pokemonSimilar3);
    }
    @FXML
    void detalles6(ActionEvent event){
        goToViewTree();
        text_name.setText(PokemonsDAO.names.get(randomIndex.get(5)));
        Image imagen1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(5)))));
        pokemon_image.setImage(imagen1);
        text_weigth.setText(PokemonsDAO.weights.get(randomIndex.get(5)));
        text_heigth.setText(PokemonsDAO.heights.get(randomIndex.get(5)));
        text_category.setText(PokemonsDAO.categories.get(randomIndex.get(5)));
        text_element.setText(PokemonsDAO.elements.get(randomIndex.get(5)));
        Image imagenEvo1 = new Image(String.valueOf(new File(PokemonsDAO.evolution_1_routes.get(randomIndex.get(5)))));
        img_evolucion1.setImage(imagenEvo1);
        Image imagenEvo2 = new Image(String.valueOf(new File(PokemonsDAO.evolution_2_routes.get(randomIndex.get(5)))));
        img_evolucion2.setImage(imagenEvo2);
        text_pokeball.setText(PokemonsDAO.pokeball_types.get(randomIndex.get(5)));
        text_area_descripcion.setText(PokemonsDAO.descriptions.get(randomIndex.get(5)));

        Image pokemonSimilar1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(6)))));
        similar_pokemon1.setImage(pokemonSimilar1);
        Image pokemonSimilar2 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(4)))));
        similar_pokemon2.setImage(pokemonSimilar2);
        Image pokemonSimilar3 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(7)))));
        similar_pokemon3.setImage(pokemonSimilar3);
    }
    @FXML
    void detalles7(ActionEvent event){
        goToViewTree();
        text_name.setText(PokemonsDAO.names.get(randomIndex.get(6)));
        Image imagen1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(6)))));
        pokemon_image.setImage(imagen1);
        text_weigth.setText(PokemonsDAO.weights.get(randomIndex.get(6)));
        text_heigth.setText(PokemonsDAO.heights.get(randomIndex.get(6)));
        text_category.setText(PokemonsDAO.categories.get(randomIndex.get(6)));
        text_element.setText(PokemonsDAO.elements.get(randomIndex.get(6)));
        Image imagenEvo1 = new Image(String.valueOf(new File(PokemonsDAO.evolution_1_routes.get(randomIndex.get(6)))));
        img_evolucion1.setImage(imagenEvo1);
        Image imagenEvo2 = new Image(String.valueOf(new File(PokemonsDAO.evolution_2_routes.get(randomIndex.get(6)))));
        img_evolucion2.setImage(imagenEvo2);
        text_pokeball.setText(PokemonsDAO.pokeball_types.get(randomIndex.get(6)));
        text_area_descripcion.setText(PokemonsDAO.descriptions.get(randomIndex.get(6)));

        Image pokemonSimilar1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(3)))));
        similar_pokemon1.setImage(pokemonSimilar1);
        Image pokemonSimilar2 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(5)))));
        similar_pokemon2.setImage(pokemonSimilar2);
        Image pokemonSimilar3 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(2)))));
        similar_pokemon3.setImage(pokemonSimilar3);
    }
    @FXML
    void detalles8(ActionEvent event){
        goToViewTree();
        text_name.setText(PokemonsDAO.names.get(randomIndex.get(7)));
        Image imagen1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(7)))));
        pokemon_image.setImage(imagen1);
        text_weigth.setText(PokemonsDAO.weights.get(randomIndex.get(7)));
        text_heigth.setText(PokemonsDAO.heights.get(randomIndex.get(7)));
        text_category.setText(PokemonsDAO.categories.get(randomIndex.get(7)));
        text_element.setText(PokemonsDAO.elements.get(randomIndex.get(7)));
        Image imagenEvo1 = new Image(String.valueOf(new File(PokemonsDAO.evolution_1_routes.get(randomIndex.get(7)))));
        img_evolucion1.setImage(imagenEvo1);
        Image imagenEvo2 = new Image(String.valueOf(new File(PokemonsDAO.evolution_2_routes.get(randomIndex.get(7)))));
        img_evolucion2.setImage(imagenEvo2);
        text_pokeball.setText(PokemonsDAO.pokeball_types.get(randomIndex.get(7)));
        text_area_descripcion.setText(PokemonsDAO.descriptions.get(randomIndex.get(7)));

        Image pokemonSimilar1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(2)))));
        similar_pokemon1.setImage(pokemonSimilar1);
        Image pokemonSimilar2 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(5)))));
        similar_pokemon2.setImage(pokemonSimilar2);
        Image pokemonSimilar3 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(6)))));
        similar_pokemon3.setImage(pokemonSimilar3);
    }

    public void buttonSubmit(ActionEvent event){
        //we set the data of the objects in the viewSubmit in the variables of the
        //class Pokemones, to give this data to the method createPokemon
        Pokemones pokemon = new Pokemones(text_name_send.getText(), text_image_send.getText(),
                text_weight_send.getText(), text_height_send.getText(), text_category_send.getText(),
                label_element_send.getText(), text_evo1_send.getText(), text_evo2_send.getText(),
                text_pokeball_send.getText(), text_area_description_send.getText());

        //we call to the function that send the data to the BBDD and we give it as parameters the
        //data to insert into the BBDD
        PokemonsDAO.createPokemon(pokemon.getName(), pokemon.getImage(), pokemon.weigth,
                pokemon.getHeigth(), pokemon.getCategory(), pokemon.getElement(), pokemon.getEvolution_one(),
                pokemon.getGetEvolution_two(), pokemon.getPokeball_type(), pokemon.getDescription());

        //delete the data of the TextFields when the information is already send to the BBDD
        text_name_send.setText("");
        text_image_send.setText("");
        text_weight_send.setText("");
        text_height_send.setText("");
        text_category_send.setText("");
        text_element_send.setText("");
        text_evo1_send.setText("");
        text_evo2_send.setText("");
        text_pokeball_send.setText("");
        text_area_description_send.setText("");
    }

    //Function to the battle between pokemons -----------------------

    int enemy_lives = 3;
    int player_lives = 3;
    String enemy_attack;
    String player_attack;

    @FXML
    void playBattle(ActionEvent event){
        //a new battle starts every time the user press the button play
        //when the lives of any one of the opponents is on 0 the button play is disabled
        enemy_attack = enemyAttack();
        player_attack = playerAttack();

        //set the variables in the text squares

        if (player_attack == enemy_attack){
            //tie
        }else if (player_attack == "water" && enemy_attack == "ray") {
            //you lose
            player_lives --;
        }else if (player_attack == "fire" && enemy_attack == "water") {
            //you lose
            player_lives --;
        }else if (player_attack == "ray" && enemy_attack == "fire") {
            //you lose
            player_lives --;
        }else {
            //you win
            player_lives ++;
        }

        checkLives();
    }

    public String enemyAttack(){
        int randomnumber = randomNumber(3);
        switch (randomnumber){
            case 1:
                enemy_attack = "water";
                break;
            case 2:
                enemy_attack = "ray";
                break;
            case 3:
                enemy_attack = "fire";
        }
        return enemy_attack;
    }
    public String playerAttack(){
        int randomnumber = randomNumber(3);
        switch (randomnumber){
            case 1:
                enemy_attack = "water";
                break;
            case 2:
                enemy_attack = "ray";
                break;
            case 3:
                enemy_attack = "fire";
        }
        return player_attack;
    }

    public void checkLives(){
        if (enemy_lives <= player_lives){
            //tie
            //set the victory in the result text
            button_tittle.setDisable(true);
        }else if (player_lives <= 0){
            //you lose
            //set the defeat in the result text
            button_tittle.setDisable(true);
        } else if (enemy_lives <= 0) {
            //you win
            //set the victory in the result text
            button_tittle.setDisable(true);
        }
    }
    public int randomNumber(int range){
        int numero = (int)(Math.random()*range+1);
        return numero;
    }
}