
package ir.org.acm.exam.khosrojerdi.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class UserOPS {//implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;
    private String password;
    private boolean adminStatus;

    private String role;
    
    private List<OrderOPS> orderList = new ArrayList<OrderOPS>();

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<OrderOPS> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderOPS> orderList) {
        this.orderList = orderList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(boolean adminStatus) {
        this.adminStatus = adminStatus;
    }


}
