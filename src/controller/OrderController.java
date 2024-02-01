package controller;


import DBconnection.DBConnection;
import model.OrderList;
import model.Orders;


public class OrderController {

    public static final double XS = 600;
    public static final double S = 800;
    public static final double M = 900;
    public static final double L = 1000;
    public static final double XL = 1100;
    public static final double XXL = 1200;

    
    public static String generateId() {
        OrderList orderList = DBConnection.getInstance().getOrderList();
        int size = orderList.size();
        if (size > 0) {
            int id = Integer.parseInt(orderList.get(size - 1).getOrderIds().split("#")[1]);
            id++;
            return String.format("ODR#%05d", id);
        }
        return "ODR#00001";
    }
    public static double findAmount(String qty, String size) {
        int x=Integer.parseInt(qty);
        double amount = size.equals("XS") ? XS * x : size.equals("S") ? S * x : size.equals("M") ? M * x : size.equals("L") ? L * x : size.equals("XL") ? XL * x : XXL * x;
        double sum = amount;
        return sum;
    }
    
    public static boolean addOrder(Orders order){
        OrderList orderList = DBConnection.getInstance().getOrderList();
        return  orderList.add(order);
    }
    
     public static Orders searchOrder(String id){
        OrderList orderList = DBConnection.getInstance().getOrderList(); 
        int i=orderList.search(new Orders(id,null,null,0,0.0,0));	
        return  orderList.get(i);
     }
     
    public static boolean deleteOrder(String id) {
        OrderList orderList = DBConnection.getInstance().getOrderList();
        int i = orderList.search(new Orders(id, null, null, 0, 0.0, 0));
        return orderList.remove(i);
    }
      
    @SuppressWarnings("empty-statement")
    public static Object[] searchCustomer(String number) {
        OrderList orderList = DBConnection.getInstance().getOrderList();
        int index = orderList.search(new Orders(null, number, null, 0, 0.0, 0));
        if (index != -1) {
            Orders order = orderList.get(index);
            Orders[] orderArray = orderList.toArray();

            int[] tempSizes = new int[6];

            for (int j = 0; j < orderList.size(); j++) {

                if ((number).equals(orderArray[j].getMobileNumber())) {
                    switch (orderArray[j].getSizes()) {
                        case "XS":
                            tempSizes[0] += orderArray[j].getQty();
                            break;
                        case "S":
                            tempSizes[1] += orderArray[j].getQty();
                            break;
                        case "M":
                            tempSizes[2] += orderArray[j].getQty();
                            break;
                        case "L":
                            tempSizes[3] += orderArray[j].getQty();
                            break;
                        case "XL":
                            tempSizes[4] += orderArray[j].getQty();
                            break;
                        case "XXL":
                            tempSizes[5] += orderArray[j].getQty();
                            break;

                    }
                }
            }

            double[] amount1 = new double[6];
            amount1[0] = tempSizes[0] * XS;
            amount1[1] = tempSizes[1] * S;
            amount1[2] = tempSizes[2] * M;
            amount1[3] = tempSizes[3] * L;
            amount1[4] = tempSizes[4] * XL;
            amount1[5] = tempSizes[5] * XXL;
            String[] tmpsize = {"XS", "S", "M", "L", "XL", "XXL"};

            for (int i = 1; i < amount1.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (amount1[i] > amount1[(j)]) {
                        double t = amount1[i];
                        amount1[i] = amount1[j];
                        amount1[j] = t;

                        int tmp = tempSizes[i];
                        tempSizes[i] = tempSizes[j];
                        tempSizes[j] = tmp;

                        String tm = tmpsize[i];
                        tmpsize[i] = tmpsize[j];
                        tmpsize[j] = tm;
                    }
                }
            }

            Object[] result = {tmpsize, amount1, tempSizes};

            return result;

        }
        return null;

    }
    
    public static Object[] viewCustomer() {
        OrderList orderList = DBConnection.getInstance().getOrderList();
        String[] customers = new String[0];
        double[] totalAmount = new double[0];
        int[] totalQty = new int[0];
        Orders[] orderArray = orderList.toArray();

        if (orderArray.length > 0) {
            L1:
            for (int i = 0; i < orderArray.length; i++) {
                for (int j = 0; j < customers.length; j++) {
                    if (orderArray[i].getMobileNumber().equals(customers[j])) {
                        continue L1;
                    }
                }
                customers = extendArray(customers);
                customers[customers.length - 1] = orderArray[i].getMobileNumber();
            }
        }
        for (int i = 0; i < customers.length; i++) {
            int[] tempSizes = new int[6];
            for (int j = 0; j < orderArray.length; j++) {
                if (customers[i].equals(orderArray[j].getMobileNumber())) {

                    switch (orderArray[j].getSizes()) {
                        case "XS":
                            tempSizes[0] += orderArray[j].getQty();
                            break;
                        case "S":
                            tempSizes[1] += orderArray[j].getQty();
                            break;
                        case "M":
                            tempSizes[2] += orderArray[j].getQty();
                            break;
                        case "L":
                            tempSizes[3] += orderArray[j].getQty();
                            break;
                        case "XL":
                            tempSizes[4] += orderArray[j].getQty();
                            break;
                        case "XXL":
                            tempSizes[5] += orderArray[j].getQty();
                            break;
                    }
                }
            }
            int total1 = 0;
            for (int k = 0; k < 6; k++) {
                total1 += tempSizes[k];
            }
            double total = 0;
            total += tempSizes[0] * XS;
            total += tempSizes[1] * S;
            total += tempSizes[2] * M;
            total += tempSizes[3] * L;
            total += tempSizes[4] * XL;
            total += tempSizes[5] * XXL;

            totalQty = extendArray(totalQty);
            totalQty[totalQty.length - 1] = total1;

            totalAmount = extendArray(totalAmount);
            totalAmount[totalAmount.length - 1] = total;
        }

        Object[] result = {customers, totalQty, totalAmount};
        return result;
    }
    public static Object[] bestInCustomer() {
        OrderList orderList = DBConnection.getInstance().getOrderList();
        String[] customers = new String[0];
        double[] totalAmount = new double[0];
        int[] totalQty = new int[0];
        Orders[] orderArray = orderList.toArray();

        if (orderArray.length > 0) {
            L1:
            for (int i = 0; i < orderArray.length; i++) {
                for (int j = 0; j < customers.length; j++) {
                    if (orderArray[i].getMobileNumber().equals(customers[j])) {
                        continue L1;
                    }
                }
                customers = extendArray(customers);
                customers[customers.length - 1] = orderArray[i].getMobileNumber();
            }
        }
        for (int i = 0; i < customers.length; i++) {
            int[] tempSizes = new int[6];
            for (int j = 0; j < orderArray.length; j++) {
                if (customers[i].equals(orderArray[j].getMobileNumber())) {

                    switch (orderArray[j].getSizes()) {
                        case "XS":
                            tempSizes[0] += orderArray[j].getQty();
                            break;
                        case "S":
                            tempSizes[1] += orderArray[j].getQty();
                            break;
                        case "M":
                            tempSizes[2] += orderArray[j].getQty();
                            break;
                        case "L":
                            tempSizes[3] += orderArray[j].getQty();
                            break;
                        case "XL":
                            tempSizes[4] += orderArray[j].getQty();
                            break;
                        case "XXL":
                            tempSizes[5] += orderArray[j].getQty();
                            break;
                    }
                }
            }
            int total1 = 0;
            for (int k = 0; k < 6; k++) {
                total1 += tempSizes[k];
            }
            double total = 0;
            total += tempSizes[0] * XS;
            total += tempSizes[1] * S;
            total += tempSizes[2] * M;
            total += tempSizes[3] * L;
            total += tempSizes[4] * XL;
            total += tempSizes[5] * XXL;

            totalQty = extendArray(totalQty);
            totalQty[totalQty.length - 1] = total1;

            totalAmount = extendArray(totalAmount);
            totalAmount[totalAmount.length - 1] = total;
        }

        for (int i = 1; i < totalAmount.length; i++) {
            for (int j = 0; j < i; j++) {
                if (totalAmount[i] > totalAmount[(j)]) {
                    double t = totalAmount[i];
                    totalAmount[i] = totalAmount[j];
                    totalAmount[j] = t;

                    int tmp = totalQty[i];
                    totalQty[i] = totalQty[j];
                    totalQty[j] = tmp;

                    String tm = customers[i];
                    customers[i] = customers[j];
                    customers[j] = tm;
                }
            }
        }

        Object[] result = {customers, totalQty, totalAmount};
        return result;
    }
    
    public static Object[] itemsBYQty() {
        OrderList orderList = DBConnection.getInstance().getOrderList();
        Orders[] orderArray = orderList.toArray();
        int[] tempSizes = new int[6];
        for (int j = 0; j < orderArray.length; j++) {

            switch (orderArray[j].getSizes()) {
                case "XS":
                    tempSizes[0] += orderArray[j].getQty();
                    break;
                case "S":
                    tempSizes[1] += orderArray[j].getQty();
                    break;
                case "M":
                    tempSizes[2] += orderArray[j].getQty();
                    break;
                case "L":
                    tempSizes[3] += orderArray[j].getQty();
                    break;
                case "XL":
                    tempSizes[4] += orderArray[j].getQty();
                    break;
                case "XXL":
                    tempSizes[5] += orderArray[j].getQty();
                    break;
            }
        }

        double[] amount1 = new double[6];
        amount1[0] = tempSizes[0] * XS;
        amount1[1] = tempSizes[1] * S;
        amount1[2] = tempSizes[2] * M;
        amount1[3] = tempSizes[3] * L;
        amount1[4] = tempSizes[4] * XL;
        amount1[5] = tempSizes[5] * XXL;
        String[] tmpsize = {"XS", "S", "M", "L", "XL", "XXL"};

        for (int i = 1; i < amount1.length; i++) {
            for (int j = 0; j < i; j++) {
                if (tempSizes[i] > tempSizes[(j)]) {

                    int tmp = tempSizes[i];
                    tempSizes[i] = tempSizes[j];
                    tempSizes[j] = tmp;

                    double t = amount1[i];
                    amount1[i] = amount1[j];
                    amount1[j] = t;

                    String tm = tmpsize[i];
                    tmpsize[i] = tmpsize[j];
                    tmpsize[j] = tm;
                }
            }
        }

        Object[] result = {tmpsize, tempSizes, amount1};
        return result;
    }

    public static Object[] itemsByAmount() {
        OrderList orderList = DBConnection.getInstance().getOrderList();
        Orders[] orderArray = orderList.toArray();
        int[] tempSizes = new int[6];
        for (int j = 0; j < orderArray.length; j++) {

            switch (orderArray[j].getSizes()) {
                case "XS":
                    tempSizes[0] += orderArray[j].getQty();
                    break;
                case "S":
                    tempSizes[1] += orderArray[j].getQty();
                    break;
                case "M":
                    tempSizes[2] += orderArray[j].getQty();
                    break;
                case "L":
                    tempSizes[3] += orderArray[j].getQty();
                    break;
                case "XL":
                    tempSizes[4] += orderArray[j].getQty();
                    break;
                case "XXL":
                    tempSizes[5] += orderArray[j].getQty();
                    break;
            }
        }
        double[] amount1 = new double[6];
        amount1[0] = tempSizes[0] * XS;
        amount1[1] = tempSizes[1] * S;
        amount1[2] = tempSizes[2] * M;
        amount1[3] = tempSizes[3] * L;
        amount1[4] = tempSizes[4] * XL;
        amount1[5] = tempSizes[5] * XXL;
        String[] tmpsize = {"XS", "S", "M", "L", "XL", "XXL"};

        for (int i = 1; i < amount1.length; i++) {
            for (int j = 0; j < i; j++) {
                if (amount1[i] > amount1[(j)]) {

                    double t = amount1[i];
                    amount1[i] = amount1[j];
                    amount1[j] = t;

                    int tmp = tempSizes[i];
                    tempSizes[i] = tempSizes[j];
                    tempSizes[j] = tmp;

                    String tm = tmpsize[i];
                    tmpsize[i] = tmpsize[j];
                    tmpsize[j] = tm;
                }
            }
        }

        Object[] result = {tmpsize, tempSizes, amount1};
        return result;
    }
    public static Orders[] allorders() {
        OrderList orderList = DBConnection.getInstance().getOrderList();
        int size = orderList.size();
        Orders[] tempOrderArray = orderList.toArray();

        int i = 0;
        int j = tempOrderArray.length - 1;
        while (i < j) {
            Orders temp = tempOrderArray[i];
            tempOrderArray[i] = tempOrderArray[j];
            tempOrderArray[j] = temp;
            i++;
            j--;
        }
        return tempOrderArray;
    }
    
    public static Orders[] ordersByAmount() {
        OrderList orderList = DBConnection.getInstance().getOrderList();
        int size = orderList.size();
        Orders[] tempOrderArray = orderList.toArray();

        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                Orders s1 = tempOrderArray[j];
                Orders s2 = tempOrderArray[j + 1];
                if (s1.getAmount() < s2.getAmount()) {
                    Orders temp = tempOrderArray[j];
                    tempOrderArray[j] = tempOrderArray[j + 1];
                    tempOrderArray[j + 1] = temp;
                }
            }
        }

        return tempOrderArray;
    }
   public static Object[] allCustomerReport() {
    OrderList orderList = DBConnection.getInstance().getOrderList();
    String[] customers = new String[0];
    Orders[] orderArray = orderList.toArray();
    
    if (orderArray.length > 0) {
        L1:
        for (int i = 0; i < orderArray.length; i++) {
            for (int j = 0; j < customers.length; j++) {
                if (orderArray[i].getMobileNumber().equals(customers[j])) {
                    continue L1;
                }
            }
            customers = extendArray(customers);
            customers[customers.length - 1] = orderArray[i].getMobileNumber();
        }
    }

    
    String[] customerReports = new String[customers.length];
    int[][] tempSizesArray = new int[customers.length][6];
    double[] totalArray = new double[customers.length];
    
    for (int i = 0; i < customers.length; i++) {
        int[] tempSizes = new int[6];
        for (int j = 0; j < orderArray.length; j++) {
            if (customers[i].equals(orderArray[j].getMobileNumber())) {
                switch (orderArray[j].getSizes()) {
                    case "XS":
                        tempSizes[0] += orderArray[j].getQty();
                        break;
                    case "S":
                        tempSizes[1] += orderArray[j].getQty();
                        break;
                    case "M":
                        tempSizes[2] += orderArray[j].getQty();
                        break;
                    case "L":
                        tempSizes[3] += orderArray[j].getQty();
                        break;
                    case "XL":
                        tempSizes[4] += orderArray[j].getQty();
                        break;
                    case "XXL":
                        tempSizes[5] += orderArray[j].getQty();
                        break;
                }
            }
        }
        
       
        int total1 = 0;
        for (int k = 0; k < 6; k++) {
            total1 += tempSizes[k];
        }
        double total = 0;
        total += tempSizes[0] * XS;
        total += tempSizes[1] * S;
        total += tempSizes[2] * M;
        total += tempSizes[3] * L;
        total += tempSizes[4] * XL;
        total += tempSizes[5] * XXL;

        
        customerReports[i] = customers[i];
        tempSizesArray[i] = tempSizes;
        totalArray[i] = total;
    }

    
    return new Object[] { customerReports, tempSizesArray, totalArray };
}


  public static String[] extendArray(String[] br) {
        String[] temp = new String[br.length + 1];
        for (int i = 0; i < br.length; i++) {
            temp[i] = br[i];
        }
        return temp;
    }

    public static int[] extendArray(int[] br) {
        int[] temp = new int[br.length + 1];
        for (int i = 0; i < br.length; i++) {
            temp[i] = br[i];
        }
        return temp;
    }

    public static double[] extendArray(double[] br) {
        double[] temp = new double[br.length + 1];
        for (int i = 0; i < br.length; i++) {
            temp[i] = br[i];
        }
        return temp;
    }
    
    
}
