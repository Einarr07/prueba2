import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class pantalla {
    JPanel pantalla1;
    private JTable datosTable;
    private JTextField placaTField;
    private JTextField marcaTField;
    private JTextField modeloTField;
    private JTextField colorTField;
    private JComboBox mesBox;
    private JComboBox diaBox;
    private JComboBox anioBox;
    private JButton guardarButton;

    Connection con;

    public pantalla() {

        //Traigo los datos de mi tabla para que se presenten en el Combo Box
        this.diaBox.setModel(optener_dia());
        this.mesBox.setModel(optener_mes());
        this.anioBox.setModel(optener_anio());

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conectar();
                try{
                    PreparedStatement ps;
                    ps = con.prepareStatement("insert into fin2 (dia, mes, anio) values(?,?,?)");
                    ps.setInt(1, Integer.parseInt(diaBox.getSelectedItem().toString()) );
                    ps.setString(2, mesBox.getSelectedItem().toString());
                    ps.setInt(3, Integer.parseInt(anioBox.getSelectedItem().toString()));
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                    limpiarEntradas();
                    con.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public void limpiarEntradas(){
        diaBox.setSelectedIndex(0);
        mesBox.setSelectedIndex(0);
        anioBox.setSelectedIndex(0);
    }
    //Metodo para solo colocar la consulta SQL dentro de los metodos
    public ResultSet consulta(String sql){
        ResultSet res = null;
        conectar();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            res = ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException("Error consulta"+e);
        }
        return res;
    }

    //Metodos para obtener los datos de mis tablas des la BD
    //dia
    public DefaultComboBoxModel optener_dia(){
        DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
        listaModelo.addElement("Escoja el dia");
        ResultSet res = this.consulta("Select * from dia ");
        try{
            while(res.next()){
                listaModelo.addElement(res.getString("num_dia"));
            }
            res.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return listaModelo;
    }
    //mes
    public DefaultComboBoxModel optener_mes(){
        DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
        listaModelo.addElement("Escoger el mes");
        ResultSet res = this.consulta("Select * from mes");
        try{
            while(res.next()){
                listaModelo.addElement(res.getString("Nombre_Mes"));
            }
            res.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return listaModelo;
    }
    //anio
    public DefaultComboBoxModel optener_anio(){
        DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
        listaModelo.addElement("Seleccionar año");
        ResultSet res = this.consulta("Select * from año");
        try{
            while(res.next()){
                listaModelo.addElement(res.getString("Nombre_Anio"));
            }
            res.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return listaModelo;
    }

    //Conectar con la BD
    public void conectar(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fechas", "root", "mateo");
            System.out.println("La coneccion fue exitosa");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
