package com.datalayer;

public class Ventas {
    int IDVenta,CveCliente,Nomina,PrecTot;
    String Fecha;

    public int getIDVenta() {
        return IDVenta;
    }

    public void setIDVenta(int IDVenta) {
        this.IDVenta = IDVenta;
    }

    public int getCveCliente() {
        return CveCliente;
    }

    public void setCveCliente(int CveCliente) {
        this.CveCliente = CveCliente;
    }

    public int getNomina() {
        return Nomina;
    }

    public void setNomina(int Nomina) {
        this.Nomina = Nomina;
    }

    public int getPrecTot() {
        return PrecTot;
    }

    public void setPrecTot(int PrecTot) {
        this.PrecTot = PrecTot;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
}
