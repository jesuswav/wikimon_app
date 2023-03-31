package com.example.wikimon_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
    //ImageView for evolutions of the pokemon
    @FXML
    private ImageView img_evolucion1;
    @FXML
    private ImageView img_evolucion2;

    //------------------------view submit ----------------------------------------------------------
    @FXML
    private Label label_element_send;
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
    private Label player_name;
    @FXML
    private Label enemy_name;
    //----------------------------------------end view submit--------------------

    //##########################################################################
    //Button of the first view in the program
    @FXML
    private Button button_tittle;

    //Objects for the views
    @FXML
    private AnchorPane view_two_details;
    @FXML
    private AnchorPane view_one_battle;
    @FXML
    private AnchorPane view_three_details;
    @FXML
    private AnchorPane view_four_register;

    //------------------Methods--------------------------------

    //Function to go to the next view using setVisible -------
    @FXML
    void goToViewTree() {
        view_one = false;
        view_two = false;
        view_three = true;

        view_one_battle.setVisible(false);
        view_two_details.setVisible(false);
        view_three_details.setVisible(true);
        view_four_register.setVisible(false);

    }

    boolean ejecucionRead = false;

    @FXML
    void goToViewTwo(ActionEvent event) {

        Collections.shuffle(randomIndex);
        System.out.println("Lista desordenada");
        System.out.println(randomIndex);

        System.out.println("Ids");
        System.out.println(PokemonsDAO.ids);

        if (randomIndex.size() <= 0) {
            pokemonImages();
        }
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

        view_one_battle.setVisible(false);
        view_two_details.setVisible(true);
        view_three_details.setVisible(false);
        view_four_register.setVisible(false);

    }

    @FXML
    void goToViewBattle(ActionEvent event) {

        view_one_battle.setVisible(true);
        view_two_details.setVisible(false);
        view_three_details.setVisible(false);
        view_four_register.setVisible(false);

        imagesForBattles();
    }

    @FXML
    void selectRandomPokemons() {
        imagesForBattles();
    }

    public void pokemonImages() {
        //we call to the method that will pull the information from the BBDD
        //conditional to check if the method is already called
        if (ejecucionRead == false) {
            PokemonsDAO.readRegisters();

            for (int i = 0; i <= (PokemonsDAO.image_routes.size() - 1); i++) {
                randomIndex.add(i);
            }
        }

        //pokemons that will be in the ImageViews


    }


    public void imagesForBattles() {

        if (randomIndex.size() <= 0) {
            pokemonImages();
        }

        int randomNumberToIndex = randomNumber(randomIndex.size() - 1);
        int randomNumberToIndexEnemy = randomNumber(randomIndex.size() - 4);

        if (randomNumberToIndexEnemy == randomNumberToIndex) {
            randomNumberToIndexEnemy = randomNumber(randomIndex.size() - 2);
        }

        player_name.setText(PokemonsDAO.names.get(randomNumberToIndex));
        Image imagenPlayer = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomNumberToIndex))));
        image_player.setImage(imagenPlayer);

        enemy_name.setText(PokemonsDAO.names.get(randomNumberToIndexEnemy));
        Image imagenEnemy = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomNumberToIndexEnemy))));
        image_enemy.setImage(imagenEnemy);

        System.out.println(PokemonsDAO.names.get(randomNumberToIndex));
        System.out.println(PokemonsDAO.image_routes.get(randomNumberToIndex));


    }


    @FXML
    void showPokemon(ActionEvent event) {
        //imagen_1.setImage(imagen1);
    }

    @FXML
    void goToViewSubmit(ActionEvent event) {

        view_one_battle.setVisible(false);
        view_two_details.setVisible(false);
        view_three_details.setVisible(false);
        view_four_register.setVisible(true);

    }

    int similar_details1;
    int similar_details2;
    int similar_details3;

    //Methods to buttons Detalles ------------------------------
    @FXML
    void detalles1(ActionEvent event) {
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

        similar_details1 = 4;
        similar_details2 = 1;
        similar_details3 = 2;
    }

    @FXML
    void detalles2(ActionEvent event) {
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

        similar_details1 = 7;
        similar_details2 = 5;
        similar_details3 = 3;
    }

    @FXML
    void detalles3(ActionEvent event) {
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

        similar_details1 = 5;
        similar_details2 = 4;
        similar_details3 = 3;
    }

    @FXML
    void detalles4(ActionEvent event) {
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

        similar_details1 = 2;
        similar_details2 = 5;
        similar_details3 = 7;
    }

    @FXML
    void detalles5(ActionEvent event) {
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

        similar_details1 = 3;
        similar_details2 = 5;
        similar_details3 = 7;
    }

    @FXML
    void detalles6(ActionEvent event) {
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

        similar_details1 = 6;
        similar_details2 = 4;
        similar_details3 = 7;
    }

    @FXML
    void detalles7(ActionEvent event) {
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

        similar_details1 = 3;
        similar_details2 = 5;
        similar_details3 = 2;
    }

    @FXML
    void detalles8(ActionEvent event) {
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

        similar_details1 = 2;
        similar_details2 = 5;
        similar_details3 = 6;
    }

    //functions to details in the view details
    @FXML
    private Button similarDetails_1;
    @FXML
    private Button similarDetails_2;
    @FXML
    private Button similarDetails_3;

    @FXML
    void similarDetails1(ActionEvent event) {
        goToViewTree();
        text_name.setText(PokemonsDAO.names.get(randomIndex.get(similar_details1)));
        Image imagen1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(similar_details1)))));
        pokemon_image.setImage(imagen1);
        text_weigth.setText(PokemonsDAO.weights.get(randomIndex.get(similar_details1)));
        text_heigth.setText(PokemonsDAO.heights.get(randomIndex.get(similar_details1)));
        text_category.setText(PokemonsDAO.categories.get(randomIndex.get(similar_details1)));
        text_element.setText(PokemonsDAO.elements.get(randomIndex.get(similar_details1)));
        Image imagenEvo1 = new Image(String.valueOf(new File(PokemonsDAO.evolution_1_routes.get(randomIndex.get(similar_details1)))));
        img_evolucion1.setImage(imagenEvo1);
        Image imagenEvo2 = new Image(String.valueOf(new File(PokemonsDAO.evolution_2_routes.get(randomIndex.get(similar_details1)))));
        img_evolucion2.setImage(imagenEvo2);
        text_pokeball.setText(PokemonsDAO.pokeball_types.get(randomIndex.get(similar_details1)));
        text_area_descripcion.setText(PokemonsDAO.descriptions.get(randomIndex.get(similar_details1)));

        Image pokemonSimilar1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(4)))));
        similar_pokemon1.setImage(pokemonSimilar1);
        Image pokemonSimilar2 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(7)))));
        similar_pokemon2.setImage(pokemonSimilar2);
        Image pokemonSimilar3 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(1)))));
        similar_pokemon3.setImage(pokemonSimilar3);

        similar_details1 = 4;
        similar_details2 = 7;
        similar_details3 = 1;
    }

    @FXML
    void similarDetails2(ActionEvent event) {
        goToViewTree();
        text_name.setText(PokemonsDAO.names.get(randomIndex.get(similar_details2)));
        Image imagen1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(similar_details2)))));
        pokemon_image.setImage(imagen1);
        text_weigth.setText(PokemonsDAO.weights.get(randomIndex.get(similar_details2)));
        text_heigth.setText(PokemonsDAO.heights.get(randomIndex.get(similar_details2)));
        text_category.setText(PokemonsDAO.categories.get(randomIndex.get(similar_details2)));
        text_element.setText(PokemonsDAO.elements.get(randomIndex.get(similar_details2)));
        Image imagenEvo1 = new Image(String.valueOf(new File(PokemonsDAO.evolution_1_routes.get(randomIndex.get(similar_details2)))));
        img_evolucion1.setImage(imagenEvo1);
        Image imagenEvo2 = new Image(String.valueOf(new File(PokemonsDAO.evolution_2_routes.get(randomIndex.get(similar_details2)))));
        img_evolucion2.setImage(imagenEvo2);
        text_pokeball.setText(PokemonsDAO.pokeball_types.get(randomIndex.get(similar_details2)));
        text_area_descripcion.setText(PokemonsDAO.descriptions.get(randomIndex.get(similar_details2)));

        Image pokemonSimilar1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(1)))));
        similar_pokemon1.setImage(pokemonSimilar1);
        Image pokemonSimilar2 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(3)))));
        similar_pokemon2.setImage(pokemonSimilar2);
        Image pokemonSimilar3 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(6)))));
        similar_pokemon3.setImage(pokemonSimilar3);

        similar_details1 = 1;
        similar_details2 = 3;
        similar_details3 = 6;
    }

    @FXML
    void similarDetails3(ActionEvent event) {
        goToViewTree();
        text_name.setText(PokemonsDAO.names.get(randomIndex.get(similar_details3)));
        Image imagen1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(similar_details3)))));
        pokemon_image.setImage(imagen1);
        text_weigth.setText(PokemonsDAO.weights.get(randomIndex.get(similar_details3)));
        text_heigth.setText(PokemonsDAO.heights.get(randomIndex.get(similar_details3)));
        text_category.setText(PokemonsDAO.categories.get(randomIndex.get(similar_details3)));
        text_element.setText(PokemonsDAO.elements.get(randomIndex.get(similar_details3)));
        Image imagenEvo1 = new Image(String.valueOf(new File(PokemonsDAO.evolution_1_routes.get(randomIndex.get(similar_details3)))));
        img_evolucion1.setImage(imagenEvo1);
        Image imagenEvo2 = new Image(String.valueOf(new File(PokemonsDAO.evolution_2_routes.get(randomIndex.get(similar_details3)))));
        img_evolucion2.setImage(imagenEvo2);
        text_pokeball.setText(PokemonsDAO.pokeball_types.get(randomIndex.get(similar_details3)));
        text_area_descripcion.setText(PokemonsDAO.descriptions.get(randomIndex.get(similar_details3)));

        Image pokemonSimilar1 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(5)))));
        similar_pokemon1.setImage(pokemonSimilar1);
        Image pokemonSimilar2 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(2)))));
        similar_pokemon2.setImage(pokemonSimilar2);
        Image pokemonSimilar3 = new Image(String.valueOf(new File(PokemonsDAO.image_routes.get(randomIndex.get(7)))));
        similar_pokemon3.setImage(pokemonSimilar3);

        similar_details1 = 5;
        similar_details2 = 2;
        similar_details3 = 7;
    }

    public void buttonSubmit(ActionEvent event) {
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

    //variables from scene builder to  use the elements in the view battle

    @FXML
    private TextField text_result1;
    @FXML
    private TextField text_result2;
    @FXML
    private TextField text_result3;
    @FXML
    private TextField text_result_final;

    @FXML
    private TextField text_player1;
    @FXML
    private TextField text_player2;
    @FXML
    private TextField text_player3;

    @FXML
    private TextField text_enemy1;
    @FXML
    private TextField text_enemy2;
    @FXML
    private TextField text_enemy3;

    @FXML
    private Label label_result;

    @FXML
    private Label label_attack1;
    @FXML
    private Label label_attack2;

    @FXML
    private ImageView image_enemy;
    @FXML
    private ImageView image_player;

    @FXML
    private Button fire_button;
    @FXML
    private Button ray_button;
    @FXML
    private Button water_button;
    @FXML
    private Button reload_game;

    //Function to the battle between pokemons -----------------------

    int enemy_lives = 3;
    int player_lives = 3;
    String enemy_attack;

    String battle1;

    String battle_player;
    String battle_enemy;


    public String playBattle(String player_attack) {
        String resultado;
        //a new battle starts every time the user press the button play
        //when the lives of any one of the opponents is on 0 the button play is disabled
        enemy_attack = enemyAttack();

        //set the variables in the text squares

        if (player_attack == enemy_attack) {
            //tie
            resultado = "Empate";
        } else if (player_attack == "water" && enemy_attack == "ray") {
            //you lose
            resultado = "Perdiste";
            player_lives--;
        } else if (player_attack == "fire" && enemy_attack == "water") {
            //you lose
            resultado = "Perdiste";
            player_lives--;
        } else if (player_attack == "ray" && enemy_attack == "fire") {
            //you lose
            resultado = "Perdiste";
            player_lives--;
        } else {
            //you win
            resultado = "Ganaste";
            enemy_lives--;
        }

        battle_player = player_attack;
        battle_enemy = enemy_attack;

        checkLives();
        return resultado;
    }

    @FXML
    void reloadGame(ActionEvent event) {
        fire_button.setDisable(false);
        ray_button.setDisable(false);
        water_button.setDisable(false);

        text_player1.setText("");
        text_player2.setText("");
        text_player3.setText("");

        text_enemy1.setText("");
        text_enemy2.setText("");
        text_enemy3.setText("");

        text_result1.setText("");
        text_result2.setText("");
        text_result3.setText("");

        text_result_final.setText("RESULTADO");

        player_lives = 3;
        enemy_lives = 3;
    }

    @FXML
    void buttonWater(ActionEvent event) {
        battle1 = playBattle("water");
        text_player1.setText(battle_player);
        text_enemy1.setText(battle_enemy);
        text_result1.setText(battle1);
    }

    @FXML
    void buttonRay(ActionEvent event) {
        battle1 = playBattle("ray");
        text_player2.setText(battle_player);
        text_enemy2.setText(battle_enemy);
        text_result2.setText(battle1);
    }

    @FXML
    void buttonFire(ActionEvent event) {
        battle1 = playBattle("water");
        text_player3.setText(battle_player);
        text_enemy3.setText(battle_enemy);
        text_result3.setText(battle1);
    }

    public String enemyAttack() {
        int randomnumber = randomNumber(3);
        switch (randomnumber) {
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

    public void checkLives() {
        if (enemy_lives <= 0) {
            //tie
            //set the victory in the result text
            text_result_final.setText("GANASTE");

            fire_button.setDisable(true);
            ray_button.setDisable(true);
            water_button.setDisable(true);

            button_tittle.setDefaultButton(true);

            reload_game.setVisible(true);

        } else if (player_lives <= 0) {
            //you lose
            //set the defeat in the result text
            text_result_final.setText("PERDISTE");

            fire_button.setDisable(true);
            ray_button.setDisable(true);
            water_button.setDisable(true);

            button_tittle.setDefaultButton(true);

            reload_game.setVisible(true);
        }
    }

    public int randomNumber(int range) {
        int numero = (int) (Math.random() * range + 1);
        return numero;
    }
}