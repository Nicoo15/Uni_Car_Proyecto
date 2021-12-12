package com.example.uni_car.recycler;

import com.bumptech.glide.load.resource.gif.StreamGifDecoder;

public class Post {
    private String origen;
    private String destino;
    private String fecha;
    private String usuario;
    private String hora;
    private String telfn;

    public Post(String origen, String destino, String fecha, String usuario, String hora, String telfn) {
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.usuario = usuario;
        this.hora = hora;
        this.telfn = telfn;

    }
    public Post(){

    }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        usuario = usuario;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    private String photo;

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTelfn() {
        return telfn;
    }

    public void setTelfn(String telfn) {
        this.telfn = telfn;
    }
}