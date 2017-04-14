
package ir.org.acm.exam.khosrojerdi.entity;


import java.io.Serializable;


public class PrinterOPS implements Serializable {


    private static final long serialVersionUID = 3L;


    private Long id;
    
    private String webServiceContext;


    private String shortWebserviceCtx;
    
    private String name;
    

    private OrderOPS order;
    
    
    private int jobCount;
    
  
    private boolean active;
    
    public PrinterOPS()
    {
        name = null;
    }
    
    public PrinterOPS(String name)
    {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebServiceContext() {
        return webServiceContext;
    }

    public void setWebServiceContext(String webServiceContext) {
        this.webServiceContext = webServiceContext;
    }

    public OrderOPS getOrder() {
        return order;
    }

    public void setOrder(OrderOPS order) {
        this.order = order;
    }

    public int getJobCount() {
        return jobCount;
    }

    public void setJobCount(int jobCount) {
        this.jobCount = jobCount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public String getShortWebserviceCtx() {
        if (webServiceContext.length() > 20) {
            this.shortWebserviceCtx = webServiceContext.substring(0, 19);
        } else {
            this.shortWebserviceCtx = webServiceContext;
        }
        return shortWebserviceCtx;
    }

    public void setShortWebserviceCtx(String shortWebserviceCtx) {
        this.shortWebserviceCtx = webServiceContext;
    }

    @Override
    public String toString() {
        return "org.acm.khosrojerdi.exam.ejb.entities.Printers[ id=" + id + " ]";
    }
    
}
