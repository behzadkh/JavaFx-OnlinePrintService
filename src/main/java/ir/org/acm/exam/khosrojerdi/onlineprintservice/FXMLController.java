package ir.org.acm.exam.khosrojerdi.onlineprintservice;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ir.org.acm.exam.khosrojerdi.entity.UserOPS;
import ir.org.acm.exam.khosrojerdi.onlineprintservice.util.Lookup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {

//To represent the user add the following to the server-identities definition <secret value="QEFDTS5PUkcxQA==" />
///core-service=management/security-realm=ejb-security-realm/server-identity=secret:add(value=QEFDTS5PUkcxQA==)

    private final String IP = "localhost";

    private final String PORT = "8080";

    private final String USERNAME = "@behzad.acm@";

    private final String PASSWORD = "@ACM.ORG1@";

    private Lookup lookup =new Lookup();

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;
    
    @FXML
    private void loginBtnAction(ActionEvent event) {
        try {
            List<UserOPS> users = lookup.lookupRemoteStatelessCalculator().findAll();
//            UserDaoRemoteFacadeInterface u = (UserDaoRemoteFacadeInterface) lookup.get2(UserDaoRemoteFacadeInterface.JNDI_REMOTE2,IP,PORT,USERNAME,PASSWORD);
//            List<UserOPS> users = u.findByUsernameAndPassword("behzad", "123456");
            if(users != null && users.size()>0){
                users.stream().forEach(u -> {
                    System.out.println("username:"+u.getUsername()+" id:"+u.getId()+" isAdmin:"+u.getAdminStatus());
                });
           }
            else {
                System.out.println("user is null from server");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void registerBtnAction(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
