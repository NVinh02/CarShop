/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhnd.carshop.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vinhnd.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class CarDAO {

    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public List<CarDTO> getAllAvailableCar() 
            throws ClassNotFoundException, SQLException {
        List<CarDTO> list = new ArrayList();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT carID, carName, quantity, price, sale, "
                        + " categoryID, status FROM Car";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    boolean status = rs.getBoolean("status");
                    if (status) {
                        String carID = rs.getString("carID");
                        String carName = rs.getString("carName");
                        int quantity = rs.getInt("quantity");
                        double price = rs.getDouble("price");
                        double sale = rs.getDouble("sale");
                        String categoryID = rs.getString("categoryID");
                        list.add(new CarDTO(carID, carName, quantity, price, sale,
                                categoryID, status));
                    }
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<CarDTO> searchCar(String search) 
            throws ClassNotFoundException, SQLException {
        List<CarDTO> list = new ArrayList();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT carID, carName, quantity, price, sale, "
                        + " categoryID, status FROM Car "
                        + " WHERE carName LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    boolean status = rs.getBoolean("status");
                    if (status) {
                        String carID = rs.getString("carID");
                        String carName = rs.getString("carName");
                        int quantity = rs.getInt("quantity");
                        double price = rs.getDouble("price");
                        double sale = rs.getDouble("sale");
                        String categoryID = rs.getString("categoryID");
                        list.add(new CarDTO(carID, carName, quantity, price, sale,
                                categoryID, status));
                    }
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }

//    public List<CarDTO> getAllCar() 
//            throws ClassNotFoundException, SQLException {
//        List<CarDTO> list = new ArrayList();
//        try {
//            con = DBUtils.getConnection();
//            if (con != null) {
//                String sql = "SELECT carID, carName, quantity, price, sale, "
//                        + " categoryID, status FROM Car";
//                stm = con.prepareStatement(sql);
//                rs = stm.executeQuery();
//                while (rs.next()) {
//                    String carID = rs.getString("carID");
//                    String carName = rs.getString("carName");
//                    int quantity = rs.getInt("quantity");
//                    double price = rs.getDouble("price");
//                    double sale = rs.getDouble("sale");
//                    String categoryID = rs.getString("categoryID");
//                    boolean status = rs.getBoolean("status");
//                    list.add(new CarDTO(carID, carName, quantity, price, sale,
//                            categoryID, status));
//                }
//            }
//        } finally {
//            closeConnection();
//        }
//        return list;
//    }
    
    public List<CarDTO> adminSearchCar(String search, boolean status) 
            throws ClassNotFoundException, SQLException {
        List<CarDTO> list = new ArrayList();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT carID, carName, quantity, price, sale, "
                        + " categoryID, status FROM Car "
                        + " WHERE carName LIKE ? AND status=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                stm.setBoolean(2, status);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String carID = rs.getString("carID");
                    String carName = rs.getString("carName");
                    int quantity = rs.getInt("quantity");
                    double price = rs.getDouble("price");
                    double sale = rs.getDouble("sale");
                    String categoryID = rs.getString("categoryID");
                    list.add(new CarDTO(carID, carName, quantity, price, sale,
                            categoryID, status));
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean Delete(String carID) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE Car SET status = 'false' "
                        + " WHERE carID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, carID);
                int row = stm.executeUpdate();
                if (row > 0) {
                    check = true;
                }
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean Launch(String carID) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE Car SET status = 'true' "
                        + " WHERE carID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, carID);
                int row = stm.executeUpdate();
                if (row > 0) {
                    check = true;
                }
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean Update(CarDTO car) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE Car SET carName=?, quantity=?, price=?, sale=? "
                        + " WHERE carID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, car.getCarName());
                stm.setInt(2, car.getQuantity());
                stm.setDouble(3, car.getPrice());
                stm.setDouble(4, car.getSale());
                stm.setString(5, car.getCarID());
                int row = stm.executeUpdate();
                if (row > 0) {
                    check = true;
                }
            }
        } finally {
            closeConnection();
        }
        return check;
    }
}
