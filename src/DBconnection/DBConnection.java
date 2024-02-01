package DBconnection;

import model.OrderList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class DBConnection {
    private OrderList orderList;
    private static DBConnection dBConnection;
    private DBConnection(){
        orderList=new OrderList();
    }
    public static DBConnection getInstance(){
        if(dBConnection==null){
            dBConnection=new DBConnection();
        }
        return dBConnection;
    }
    public OrderList getOrderList(){
       return  orderList;
    }
}
