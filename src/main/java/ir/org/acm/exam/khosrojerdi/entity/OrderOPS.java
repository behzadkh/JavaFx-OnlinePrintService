package ir.org.acm.exam.khosrojerdi.entity;


import java.io.Serializable;
import java.util.Date;


public class OrderOPS implements Serializable {


    private static final long serialVersionUID = 2L;

    private long id;


    private UserOPS userId;
    

    private PrinterOPS printer;
    

    private FileuploadOPS fileupload;

    

    private StatusEnum status;


    private Date orderDate;


    private Date deliverDate;
    
    private boolean deleteStatus;

    public OrderOPS() {
    }

    public OrderOPS(UserOPS userId, StatusEnum status) {
        this.userId = userId;  
        this.status = status;        
    }

    public FileuploadOPS getFileupload() {
        return fileupload;
    }

    public void setFileupload(FileuploadOPS fileupload) {
        this.fileupload = fileupload;
    }


    public UserOPS getUserId() {
        return userId;
    }

    public void setUserId(UserOPS userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

   
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public PrinterOPS getPrinter() {
        return printer;
    }

    public void setPrinter(PrinterOPS printerOPS) {
        this.printer = printerOPS;
    }

    public boolean isDelete() {
        return deleteStatus;
    }

    public void setDelete(boolean delete) {
        this.deleteStatus = delete;
    }


    @Override
    public String toString() {
        return "org.acm.khosrojerdi.exam.model.entities.OrderOPS[ id=" + id + " ]";
    }

}
