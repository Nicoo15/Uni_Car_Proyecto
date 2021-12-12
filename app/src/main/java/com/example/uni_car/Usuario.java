package com.example.uni_car;

import java.util.List;

/**
 * @author Nico
 */
public class Usuario {


    private String email, contraseña;
    List<Integer> listaPedidosID; //Le introducimos solo el id de los pedidos

    public Usuario(String email, String contraseña) {
        this.email = email;
        this.contraseña = contraseña;

    }

    public Usuario() {
        super();
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<Integer> getListaPedidosID() {
        return listaPedidosID;
    }

    public void setListaPedidosID(List<Integer> listaPedidosID) {
        this.listaPedidosID = listaPedidosID;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void añadirPedido(int pedidoID) {
        listaPedidosID.add(pedidoID);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                ", email='" + email + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", listaPedidosID=" + listaPedidosID +
                '}';
    }
}
