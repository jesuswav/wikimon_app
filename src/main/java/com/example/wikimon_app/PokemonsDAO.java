package com.example.wikimon_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PokemonsDAO {

    static ConectionBBDD db_connection = new ConectionBBDD();

    //Arrays to save the information of the pokemons
    static ArrayList<Integer> ids = new ArrayList<Integer>();
    static ArrayList<String> names = new ArrayList<String>();
    static ArrayList<String> image_routes = new ArrayList<String>();
    static ArrayList<String> weights = new ArrayList<String>();
    static ArrayList<String> heights = new ArrayList<String>();
    static ArrayList<String> categories = new ArrayList<String>();
    static ArrayList<String> elements = new ArrayList<String>();
    static ArrayList<String> evolution_1_routes = new ArrayList<String>();
    static ArrayList<String> evolution_2_routes = new ArrayList<String>();
    static ArrayList<String> pokeball_types = new ArrayList<String>();
    static ArrayList<String> descriptions = new ArrayList<String>();

    public static void readRegisters(){


        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conexion = db_connection.getConnection()){

            String query = "SELECT * FROM `pokemones`";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println("ID: " + rs.getInt("id_pokemon") +
                        "\nNombre: " + rs.getString("name") +
                        "\nImagen: " + rs.getString("image") +
                        "\nPeso: " + rs.getString("weight") +
                        "\nAltura: " + rs.getString("heigth") +
                        "\nCategoria: " + rs.getString("category") +
                        "\nElemento: " + rs.getString("element") +
                        "\nEvolucion 1: " + rs.getString("evolution_1") +
                        "\nEvolucion 2" + rs.getString("evolution_2") +
                        "\nTipo de pokebola: " + rs.getString("pokeball_type") +
                        "\nDescripcion: " +  rs.getString("description"));

                ids.add(rs.getInt("id_pokemon"));
                names.add(rs.getString("name"));
                image_routes.add(rs.getString("image"));
                weights.add(rs.getString("weight"));
                heights.add(rs.getString("heigth"));
                categories.add(rs.getString("category"));
                elements.add(rs.getString("element"));
                evolution_1_routes.add(rs.getString("evolution_1"));
                evolution_2_routes.add(rs.getString("evolution_2"));
                pokeball_types.add(rs.getString("pokeball_type"));
                descriptions.add(rs.getString("description"));
            }
        }catch (SQLException e){
            System.out.println("No se recupuperaron los datos");
            System.out.println(e);
        }
    }

    public static void createPokemon(){
        try (Connection conexion = db_connection.getConnection()){
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO pokemones (`name`, `image`, `weight`, `heigth`, `category`, `element`, `evolution_1`, `evolution_2`, `pokeball_type`, `description`) VALUES (?,?,?,?,?,?,?,?,?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, HelloController.text_name_send.getText());
                ps.setString(2, HelloController.text_image_send.getText());
                ps.setString(3, HelloController.text_weight_send.getText());
                ps.setString(4, HelloController.text_height_send.getText());
                ps.setString(5, HelloController.text_category_send.getText());
                ps.setString(6, HelloController.text_element_send.getText());
                ps.setString(7, HelloController.text_evo1_send.getText());
                ps.setString(8, HelloController.text_evo2_send.getText());
                ps.setString(9, HelloController.text_pokeball_send.getText());
                ps.setString(10, HelloController.text_area_description_send.getText());
                ps.executeUpdate();
                System.out.println("Successful register");
            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

}
