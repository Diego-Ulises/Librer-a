package com.datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Handler {

    private Statement sentencia;

    public Handler() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria", "root", null);
            sentencia = (Statement) conexion.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Libro> showLib() {
        String qry = "SELECT * FROM libro";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Libro> lista = new ArrayList<>();
            while (rs.next()) {

                Libro obj = new Libro();
                obj.setISBN(rs.getInt("ISBN"));
                obj.setTitulo(rs.getString("Titulo"));
                obj.setAutor(rs.getString("Autor"));
                obj.setCost(rs.getInt("Cost"));
                obj.setPrec(rs.getInt("Prec"));
                obj.setNombreEdit(rs.getString("NombreEdit"));
                obj.setNumEd(rs.getInt("NumED"));
                obj.setLugarImp(rs.getString("LugarImp"));
                obj.setAñoImp(rs.getString("AñoImp"));
                obj.setCantidad(rs.getInt("Cantidad"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Cliente> showClientes() {
        String qry = "SELECT * FROM cliente";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Cliente> lista = new ArrayList<>();
            while (rs.next()) {

                Cliente obj = new Cliente();
                obj.setCveCliente(rs.getInt("CveCliente"));
                obj.setcNombre(rs.getString("cNombre"));
                obj.setcApPat(rs.getString("cApPat"));
                obj.setcApMat(rs.getString("cApMat"));
                obj.setcCalle(rs.getString("cCalle"));
                obj.setcNum(rs.getInt("cNum"));
                obj.setcColonia(rs.getString("cColonia"));
                obj.setcCiudad(rs.getString("cCiudad"));
                obj.setcEstado(rs.getString("cEstado"));
                obj.setcTelCasa(rs.getInt("cTelCasa"));
                obj.setcCelular(rs.getInt("cCelular"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int Venta(String CveCliente, int Nomina, String Fecha, String PrecioTot) {
        String stm = "insert into ventas (CveCliente,Nomina,Fecha,PrecTot) values (" + CveCliente + "," + Nomina + ",'" + Fecha + "','" + PrecioTot + "');";
        String stm2 = "select max(IDVenta) from ventas";
        try {
            sentencia.execute(stm);
            ResultSet rs = sentencia.executeQuery(stm2);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void LibVen(int IDVenta, int ISBN, double Cantidad) {
        String stm = "insert into lib_ven (IDVenta,ISBN,Cantidad) values (" + IDVenta + "," + ISBN + "," + Cantidad + ");";
        try {
            sentencia.execute(stm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El folio del cliente y/o la clave del libro no existe");
        }
    }

    public void reducirExistencia(int ISBN, int nuevaExistencia) {
        String qry = "update libro set Cantidad=" + nuevaExistencia + " where ISBN=" + ISBN;
        try {
            sentencia.execute(qry);
        } catch (Exception e) {
        }
    }

    public void AltaCliente(String cNombre, String cApPat, String cApMat, String cCalle, int cNum, String cColonia, String cCiudad, String cEstado, int cTelCasa, int cCelular) throws SQLException {
        String stm = "insert into cliente (cNombre,cApPat,cApMat,cCalle,cNum,cColonia,cCiudad,cEstado,cTelCasa,cCelular) values ('" + cNombre + "','" + cApPat + "','" + cApMat + "','" + cCalle + "'," + cNum + ",'" + cColonia + "','" + cCiudad + "','" + cEstado + "'," + cTelCasa + "," + cCelular + ");";
        try {
            sentencia.execute(stm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void BajaCliente(int CveCliente) {
        String stm = "delete from cliente where CveCliente=" + CveCliente + ";";
        try {
            sentencia.execute(stm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación");
        }
    }

    public ArrayList<Editorial> showEdit() {
        String qry = "SELECT * FROM editorial";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Editorial> lista = new ArrayList<>();
            while (rs.next()) {

                Editorial obj = new Editorial();
                obj.setNombreEdit(rs.getString("NombreEdit"));
                obj.setEdCalle(rs.getString("edCalle"));
                obj.setEdNum(rs.getInt("edNum"));
                obj.setEdColonia(rs.getString("edColonia"));
                obj.setEdCiudad(rs.getString("edCiudad"));
                obj.setEdEstado(rs.getString("edEstado"));
                obj.setEdTel(rs.getInt("edTel"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int Pedido(int Nomina, String Fecha) {
        String stm = "insert into pedidos (Nomina,Fecha) values (" + Nomina + ",'" + Fecha + "');";
        String stm2 = "select max(IDPedido) from pedidos";
        try {
            sentencia.execute(stm);
            ResultSet rs = sentencia.executeQuery(stm2);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void LibPed(int IDPedido, int ISBN, int Cantidad,String NombreEdit) {
        String stm = "insert into lib_ped (IDPedido,ISBN,Cantidad,NombreEdit) values (" + IDPedido + "," + ISBN + "," + Cantidad + ",'" + NombreEdit + "');";
        try {
            sentencia.execute(stm);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "El folio de la editorial y/o la clave del libro no existe");
        }
    }

    public ArrayList<Us> showUs() {
        String qry = "SELECT * FROM usuarios";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Us> lista = new ArrayList<>();
            while (rs.next()) {
                Us obj = new Us();
                obj.setUsuario(rs.getString("Usuario"));
                obj.setContraseña(rs.getString("Contraseña"));
                obj.setNomina(rs.getInt("Nomina"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void AltaLibro(String ISBN, String Titulo, String Autor, String Cost, int Prec, String NombreEdit, String NumEd, String LugarImp, int AñoImp) {
        String stm = "insert into libro (ISBN,Titulo,Autor,Cost,Prec,NombreEdit,NumEd,LugarImp,AñoImp,Cantidad) values ('" + ISBN + "','" + Titulo + "','" + Autor + "','" + Cost + "'," + Prec + ",'" + NombreEdit + "','" + NumEd + "','" + LugarImp + "'," + AñoImp + ",0);";
        try {
            sentencia.execute(stm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void BajaLib(int ISBN) {
        String stm = "delete from libro where ISBN=" + ISBN + ";";
        try {
            sentencia.execute(stm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación");
        }
    }

    public void AltaEdit(String NombreEdit, String edCalle, String edNum, String edColonia, String edCiudad, String edEstado, String edTel) {
        String stm = "insert into editorial (NombreEdit,edCalle,edNum,edColonia,edCiudad,edEstado,edTel) values ('" + NombreEdit + "','" + edCalle + "'," + edNum + ",'" + edColonia + "','" + edCiudad + "','" + edEstado + "'," + edTel + ");";
        try {
            sentencia.execute(stm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void BajaEdit(String NombreEdit) {
        String stm = "delete from editorial where NombreEdit='" + NombreEdit + "';";
        try {
            sentencia.execute(stm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación");
        }
    }

    public ArrayList<Empleado> showEm() {
        String qry = "SELECT * FROM empleado";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Empleado> lista = new ArrayList<>();
            while (rs.next()) {
                Empleado obj = new Empleado();
                obj.setNomina(rs.getInt("Nomina"));
                obj.setNomEmp(rs.getString("NomEmp"));
                obj.seteApPat(rs.getString("eApPat"));
                obj.seteApMat(rs.getString("eApMat"));
                obj.setPuesto(rs.getString("Puesto"));
                obj.setSueldo(rs.getInt("Sueldo"));
                obj.seteCalle(rs.getString("eCalle"));
                obj.seteNum(rs.getInt("eNum"));
                obj.seteColonia(rs.getString("eColonia"));
                obj.seteCiudad(rs.getString("eCiudad"));
                obj.seteEstado(rs.getString("eEstado"));
                obj.setFechaIng(rs.getString("FechaIng"));
                obj.seteTelCasa(rs.getInt("eTelCasa"));
                obj.seteCelular(rs.getInt("eCelular"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void AltaEm(String Nomina, String NomEmp, String eApPat, String eApMat, String Puesto, String Sueldo, String eCalle, String eNum, String eColonia, String eCiudad, String eEstado, String FechaIng, String eTelCasa, String eCelular) {
        String stm = "insert into empleado (Nomina,NomEmp,eApPat,eApMat,Puesto,Sueldo,eCalle,eNum,eColonia,eCiudad,eEstado,FechaIng,eTelCasa,eCelular) values (" + Nomina + ",'" + NomEmp + "','" + eApPat + "','" + eApMat + "','" + Puesto + "'," + Sueldo + ",'" + eCalle + "'," + eNum + ",'" + eColonia + "','" + eCiudad + "','" + eEstado + "','" + FechaIng + "'," + eTelCasa + "," + eCelular + ");";
        try {
            sentencia.execute(stm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void BajaEmp(String Nomina) {
        String stm = "delete from empleado where Nomina='" + Nomina + "';";
        try {
            sentencia.execute(stm);
            JOptionPane.showMessageDialog(null, "Se ha eliminado el Empleado");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en la eliminación");
        }
    }

    public void AltaUs(String Usuario, String Contraseña, int Nomina) {
        String stm = "insert into usuarios (Usuario,Contraseña,Nomina) values ('" + Usuario + "','" + Contraseña + "'," + Nomina + ");";
        try {
            sentencia.execute(stm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Ventas> showVen() {
        String qry = "SELECT * FROM ventas";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Ventas> lista = new ArrayList<>();
            while (rs.next()) {
                Ventas obj = new Ventas();
                obj.setIDVenta(rs.getInt("IDVenta"));
                obj.setCveCliente(rs.getInt("CveCliente"));
                obj.setNomina(rs.getInt("Nomina"));
                obj.setFecha(rs.getString("Fecha"));
                obj.setPrecTot(rs.getInt("PrecTot"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Lib_Ven> showLibVen() {
        String qry = "SELECT * FROM lib_ven";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Lib_Ven> lista = new ArrayList<>();
            while (rs.next()) {
                Lib_Ven obj = new Lib_Ven();
                obj.setIDVenta(rs.getInt("IDVenta"));
                obj.setISBN(rs.getInt("ISBN"));
                obj.setCantidad(rs.getInt("Cantidad"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Ventas> showVenD(String Fd) {
        String qry = "SELECT * FROM ventas where Day(Fecha)=" + Fd + "";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Ventas> lista = new ArrayList<>();
            while (rs.next()) {
                Ventas obj = new Ventas();
                obj.setIDVenta(rs.getInt("IDVenta"));
                obj.setCveCliente(rs.getInt("CveCliente"));
                obj.setNomina(rs.getInt("Nomina"));
                obj.setFecha(rs.getString("Fecha"));
                obj.setPrecTot(rs.getInt("PrecTot"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Ventas> showVenM(String Fm) {
        String qry = "SELECT * FROM ventas where Month(Fecha)=" + Fm + "";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Ventas> lista = new ArrayList<>();
            while (rs.next()) {
                Ventas obj = new Ventas();
                obj.setIDVenta(rs.getInt("IDVenta"));
                obj.setCveCliente(rs.getInt("CveCliente"));
                obj.setNomina(rs.getInt("Nomina"));
                obj.setFecha(rs.getString("Fecha"));
                obj.setPrecTot(rs.getInt("PrecTot"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Ventas> showVenY(String Fy) {
        String qry = "SELECT * FROM ventas where Year(Fecha)=" + Fy + "";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Ventas> lista = new ArrayList<>();
            while (rs.next()) {
                Ventas obj = new Ventas();
                obj.setIDVenta(rs.getInt("IDVenta"));
                obj.setCveCliente(rs.getInt("CveCliente"));
                obj.setNomina(rs.getInt("Nomina"));
                obj.setFecha(rs.getString("Fecha"));
                obj.setPrecTot(rs.getInt("PrecTot"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Ventas> showVenE(String data) {
        String qry = "SELECT * FROM ventas where Nomina='" + data + "'";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Ventas> lista = new ArrayList<>();
            while (rs.next()) {
                Ventas obj = new Ventas();
                obj.setIDVenta(rs.getInt("IDVenta"));
                obj.setCveCliente(rs.getInt("CveCliente"));
                obj.setNomina(rs.getInt("Nomina"));
                obj.setFecha(rs.getString("Fecha"));
                obj.setPrecTot(rs.getInt("PrecTot"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Ventas> showVenEd(String data) {
        String qry = "SELECT * FROM `ventas` WHERE `IDVenta` IN(SELECT `IDVenta` FROM lib_ven WHERE `ISBN` IN(SELECT `ISBN` FROM libro WHERE `NombreEdit`='" + data + "'))";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Ventas> lista = new ArrayList<>();
            while (rs.next()) {
                Ventas obj = new Ventas();
                obj.setIDVenta(rs.getInt("IDVenta"));
                obj.setCveCliente(rs.getInt("CveCliente"));
                obj.setNomina(rs.getInt("Nomina"));
                obj.setFecha(rs.getString("Fecha"));
                obj.setPrecTot(rs.getInt("PrecTot"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void UpLibT(String ISBN, String text0, String text1, String text2, String text3, String toString, String text4, String text5, String text6, String text7, int isbn) {
        String stm = "UPDATE libro SET ISBN=" + ISBN + ",Titulo='" + text0 + "',Autor='" + text1 + "',Cost=" + text2 + ",Prec=" + text3 + ",NombreEdit='" + toString + "',NumEd=" + text4 + ",LugarImp='" + text5 + "',AñoImp='" + text6 + "',Cantidad=" + text7 + " WHERE ISBN=" + isbn + ";";
        try {
            sentencia.execute(stm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Libro> showLibT(String data) {
        String qry = "SELECT * FROM libro where Titulo='" + data + "'";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Libro> lista = new ArrayList<>();
            while (rs.next()) {

                Libro obj = new Libro();
                obj.setISBN(rs.getInt("ISBN"));
                obj.setTitulo(rs.getString("Titulo"));
                obj.setAutor(rs.getString("Autor"));
                obj.setCost(rs.getInt("Cost"));
                obj.setPrec(rs.getInt("Prec"));
                obj.setNombreEdit(rs.getString("NombreEdit"));
                obj.setNumEd(rs.getInt("NumED"));
                obj.setLugarImp(rs.getString("LugarImp"));
                obj.setAñoImp(rs.getString("AñoImp"));
                obj.setCantidad(rs.getInt("Cantidad"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Libro> showLibA(String data) {
        String qry = "SELECT * FROM libro where Autor='" + data + "'";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Libro> lista = new ArrayList<>();
            while (rs.next()) {

                Libro obj = new Libro();
                obj.setISBN(rs.getInt("ISBN"));
                obj.setTitulo(rs.getString("Titulo"));
                obj.setAutor(rs.getString("Autor"));
                obj.setCost(rs.getInt("Cost"));
                obj.setPrec(rs.getInt("Prec"));
                obj.setNombreEdit(rs.getString("NombreEdit"));
                obj.setNumEd(rs.getInt("NumED"));
                obj.setLugarImp(rs.getString("LugarImp"));
                obj.setAñoImp(rs.getString("AñoImp"));
                obj.setCantidad(rs.getInt("Cantidad"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void UpEmp(String text, String text0, String text1, String text2, String text3, String text4, String text5, String text6, String text7, String text8, String text9, String text10, String text11, int nomina) {
        String stm = "UPDATE empleado SET Nomina=" + text + ",NomEmp='" + text0 + "',eApPat='" + text1 + "',eApMat='" + text2 + "',Puesto='" + text3 + "',Sueldo=" + text4 + ",eCalle='" + text5 + "',eNum=" + text6 + ",eColonia='" + text7 + "',eCiudad='" + text8 + "',eEstado='" + text9 + "',eTelCasa=" + text10 + ",eCelular=" + text11 + " WHERE Nomina='" + nomina + "';";
        try {
            sentencia.execute(stm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpUs(String text, String text0, int nomina) {
        String stm = "UPDATE usuarios SET Usuario='" + text + "',Contraseña='" + text0 + "' WHERE Nomina=" + nomina + ";";
        try {
            sentencia.execute(stm);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "El Usuario ya existe", "Error al registrar", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Empleado> showEmpNomima(int data) {
        String qry = "SELECT * FROM empleado where Nomina=" + data + ";";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Empleado> lista = new ArrayList<>();
            while (rs.next()) {
                Empleado obj = new Empleado();
                obj.setNomina(rs.getInt("Nomina"));
                obj.setNomEmp(rs.getString("NomEmp"));
                obj.seteApPat(rs.getString("eApPat"));
                obj.seteApMat(rs.getString("eApMat"));
                obj.setPuesto(rs.getString("Puesto"));
                obj.setSueldo(rs.getInt("Sueldo"));
                obj.seteCalle(rs.getString("eCalle"));
                obj.seteNum(rs.getInt("eNum"));
                obj.seteColonia(rs.getString("eColonia"));
                obj.seteCiudad(rs.getString("eCiudad"));
                obj.seteEstado(rs.getString("eEstado"));
                obj.setFechaIng(rs.getString("FechaIng"));
                obj.seteTelCasa(rs.getInt("eTelCasa"));
                obj.seteCelular(rs.getInt("eCelular"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Empleado> showEmpNombre(String data) {
        String qry = "SELECT * FROM empleado where Nombre='" + data + "';";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Empleado> lista = new ArrayList<>();
            while (rs.next()) {
                Empleado obj = new Empleado();
                obj.setNomina(rs.getInt("Nomina"));
                obj.setNomEmp(rs.getString("NomEmp"));
                obj.seteApPat(rs.getString("eApPat"));
                obj.seteApMat(rs.getString("eApMat"));
                obj.setPuesto(rs.getString("Puesto"));
                obj.setSueldo(rs.getInt("Sueldo"));
                obj.seteCalle(rs.getString("eCalle"));
                obj.seteNum(rs.getInt("eNum"));
                obj.seteColonia(rs.getString("eColonia"));
                obj.seteCiudad(rs.getString("eCiudad"));
                obj.seteEstado(rs.getString("eEstado"));
                obj.setFechaIng(rs.getString("FechaIng"));
                obj.seteTelCasa(rs.getInt("eTelCasa"));
                obj.seteCelular(rs.getInt("eCelular"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Pedidos> showPed() {
        String qry = "SELECT * FROM pedidos";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Pedidos> lista = new ArrayList<>();
            while (rs.next()) {
                Pedidos obj = new Pedidos();
                obj.setIDPedido(rs.getInt("IDPedido"));
                obj.setNomina(rs.getInt("Nomina"));
                obj.setFecha(rs.getString("Fecha"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Lib_Ped> showLibPed() {
        String qry = "SELECT * FROM lib_ped";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Lib_Ped> lista = new ArrayList<>();
            while (rs.next()) {
                Lib_Ped obj = new Lib_Ped();
                obj.setIDPedido(rs.getInt("IDPedido"));
                obj.setISBN(rs.getInt("ISBN"));
                obj.setCantidad(rs.getInt("Cantidad"));
                obj.setNombreEdit(rs.getString("NombreEdit"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Pedidos> showPedN(String data) {
        String qry = "SELECT * FROM pedidos where Nomina=" + data + ";";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Pedidos> lista = new ArrayList<>();
            while (rs.next()) {
                Pedidos obj = new Pedidos();
                obj.setIDPedido(rs.getInt("IDPedido"));
                obj.setNomina(rs.getInt("Nomina"));
                obj.setFecha(rs.getString("Fecha"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Pedidos> showPedEd(String data) {
        String qry = "SELECT * FROM `pedidos` WHERE `IDPedido` IN(SELECT `IDPedido` FROM lib_ped WHERE `ISBN` IN(SELECT `ISBN` FROM libro WHERE `NombreEdit`='" + data + "'))";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Pedidos> lista = new ArrayList<>();
            while (rs.next()) {
                Pedidos obj = new Pedidos();
                obj.setIDPedido(rs.getInt("IDPedido"));
                obj.setNomina(rs.getInt("Nomina"));
                obj.setFecha(rs.getString("Fecha"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Pedidos> showPedD(String Fd) {
        String qry = "SELECT * FROM pedidos where Day(Fecha)=" + Fd + ";";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Pedidos> lista = new ArrayList<>();
            while (rs.next()) {
                Pedidos obj = new Pedidos();
                obj.setIDPedido(rs.getInt("IDPedido"));
                obj.setNomina(rs.getInt("Nomina"));
                obj.setFecha(rs.getString("Fecha"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Pedidos> showPedM(String Fm) {
        String qry = "SELECT * FROM pedidos where Month(Fecha)=" + Fm + ";";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Pedidos> lista = new ArrayList<>();
            while (rs.next()) {
                Pedidos obj = new Pedidos();
                obj.setIDPedido(rs.getInt("IDPedido"));
                obj.setNomina(rs.getInt("Nomina"));
                obj.setFecha(rs.getString("Fecha"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Pedidos> showPedY(String Fy) {
        String qry = "SELECT * FROM pedidos where YEAR(Fecha)=" + Fy + ";";
        try {
            ResultSet rs = sentencia.executeQuery(qry);
            ArrayList<Pedidos> lista = new ArrayList<>();
            while (rs.next()) {
                Pedidos obj = new Pedidos();
                obj.setIDPedido(rs.getInt("IDPedido"));
                obj.setNomina(rs.getInt("Nomina"));
                obj.setFecha(rs.getString("Fecha"));
                lista.add(obj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
