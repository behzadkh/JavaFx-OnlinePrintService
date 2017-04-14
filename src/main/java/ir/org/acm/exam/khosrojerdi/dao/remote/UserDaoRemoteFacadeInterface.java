package ir.org.acm.exam.khosrojerdi.dao.remote;


import ir.org.acm.exam.khosrojerdi.entity.UserOPS;

import java.util.List;


public interface UserDaoRemoteFacadeInterface {
    String JNDI =
            "java:global/OnlinePrintServiceMaven-ear-1.0-SNAPSHOT/OnlinePrintServiceMaven-ejb-1.0-SNAPSHOT/UserOPSFacadeImp!ir.org.acm.exam.khosrojerdi.dao.remote.UserDaoRemoteFacadeInterface";

    String JNDI_REMOTE = "ejb:/core//WSConnectionManager!com.art.vesal.factory.WSConnectionManagerRemoteInf";

    String JNDI_REMOTE2 =
            "ejb:OnlinePrintServiceMaven-ear-1.0-SNAPSHOT/OnlinePrintServiceMaven-ejb-1.0-SNAPSHOT//UserOPSFacadeImp!ir.org.acm.exam.khosrojerdi.dao.remote.UserDaoRemoteFacadeInterface";

    public List<UserOPS> findByUsernameAndPassword(String username, String password);

    public UserOPS save(UserOPS userOPS) throws Exception;

    public UserOPS update(UserOPS userOPS) throws Exception;

    public void delete(UserOPS userOPS) throws Exception;

    public UserOPS find(long entityID);

    public List<UserOPS> findAll();

}
