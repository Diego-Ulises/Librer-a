package com.datalayer;


public class Lib_Ped {
    int IDPedido,ISBN,Cantidad;
    String NombreEdit;

    public String getNombreEdit() {
        return NombreEdit;
    }

    public void setNombreEdit(String NombreEdit) {
        this.NombreEdit = NombreEdit;
    }

    public int getIDPedido() {
        return IDPedido;
    }

    public void setIDPedido(int IDPedido) {
        this.IDPedido = IDPedido;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
}
