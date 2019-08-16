package com.datalayer;


public class Libro {
    int ISBN,Cost,Prec,NumEd,Cantidad;
    String Titulo,Autor,NombreEdit,LugarImp,AñoImp;

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int Cost) {
        this.Cost = Cost;
    }

    public int getPrec() {
        return Prec;
    }

    public void setPrec(int Prec) {
        this.Prec = Prec;
    }

    public int getNumEd() {
        return NumEd;
    }

    public void setNumEd(int NumEd) {
        this.NumEd = NumEd;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getNombreEdit() {
        return NombreEdit;
    }

    public void setNombreEdit(String NombreEdit) {
        this.NombreEdit = NombreEdit;
    }

    public String getLugarImp() {
        return LugarImp;
    }

    public void setLugarImp(String LugarImp) {
        this.LugarImp = LugarImp;
    }

    public String getAñoImp() {
        return AñoImp;
    }

    public void setAñoImp(String AñoImp) {
        this.AñoImp = AñoImp;
    }
    
}
