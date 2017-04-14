package ir.org.acm.exam.khosrojerdi.onlineprintservice.util;


import ir.org.acm.exam.khosrojerdi.dao.remote.UserDaoRemoteFacadeInterface;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by reza on 7/2/15.
 */
public class Lookup {

    private static final Logger LOGGER = Logger.getLogger(Lookup.class.getName());

    private InitialContext ctx = null;

    public <T> T get(String jndiName, String ip, String port, String username, String password) throws NamingException {

        Properties properties = new Properties();

        try {
            properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//            properties.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());
//            properties.put(Context.PROVIDER_URL, "remote://localhost:8080");
//            properties.put( "remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED","false");
//            properties.put("remote.connections", "default");
//            properties.put("remote.connection.default.host", ip);
//            properties.put("remote.connection.default.port", port);
//            properties.put("remote.connection.default.username", username);
//            properties.put("remote.connection.default.password", password);
//            properties.put("org.jboss.ejb.client.scoped.context", "true");
//            properties.put("remote.connection.one.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS","false");

            // The environment property jboss.naming.client.ejb.context indicates that the InitialContext implementation
            // of the remote naming project will also create an internal EJB client context via the EJB client library.
            // This allows the invocation of EJB components with the remote naming project.
            ctx = new InitialContext(properties);

            return (T) ctx.lookup(jndiName);
        } catch (NamingException e) {
            e.printStackTrace();
        }

        // All proxies become invalid if .close() for the related javax.naming.InitalContext is invoked,
        // or the InitialContext is not longer referenced and gets garbage-collected.

        throw new NamingException("Service not available on specified servers " + ip);
    }

    public void close() {

        if (ctx != null) {
            try {
                ((Context) ctx.lookup("ejb:")).close();
                ctx.close();
            } catch (NamingException e) {
                LOGGER.log(Level.SEVERE,e.getMessage());
            }
        }
    }

    public Object get(String jndi) {
        Object obj = null;
        Context jndiContext = null;
        try {
            final Hashtable jndiProperties = new Hashtable();
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            jndiProperties.put("jboss.naming.client.ejb.context", true);
            jndiContext = new InitialContext(jndiProperties);
            obj = jndiContext.lookup(jndi);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
        return obj;
    }

    public Object get2(String jndi, String ip, String port,String username , String pass) {
        Object obj = null;
        Context jndiContext = null;
        try {
            final Hashtable jndiProperties = new Hashtable();
//            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//            jndiProperties.put("jboss.naming.client.ejb.context", true);
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://" + ip + ":" + port + "");
            jndiProperties.put(Context.SECURITY_PRINCIPAL,username);
            jndiProperties.put(Context.SECURITY_CREDENTIALS, pass);
            jndiContext = new InitialContext(jndiProperties);
            obj = jndiContext.lookup(jndi);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
        return obj;
    }


    public static UserDaoRemoteFacadeInterface lookupRemoteStatelessCalculator() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);
        // The app name is the application name of the deployed EJBs. This is typically the ear name
        // without the .ear suffix. However, the application name could be overridden in the application.xml of the
        // EJB deployment on the server.
        // Since we haven't deployed the application as a .ear, the app name for us will be an empty string
        final String appName = "OnlinePrintServiceMaven-ear-1.0-SNAPSHOT";
        // This is the module name of the deployed EJBs on the server. This is typically the jar name of the
        // EJB deployment, without the .jar suffix, but can be overridden via the ejb-jar.xml
        // In this example, we have deployed the EJBs in a jboss-as-ejb-remote-app.jar, so the module name is
        // jboss-as-ejb-remote-app
        final String moduleName = "OnlinePrintServiceMaven-ejb-1.0-SNAPSHOT";
        // AS7 allows each deployment to have an (optional) distinct name. We haven't specified a distinct name for
        // our EJB deployment, so this is an empty string
        final String distinctName = "";
        // The EJB name which by default is the simple class name of the bean implementation class
        final String beanName = "UserOPSFacadeImp";
        // the remote view fully qualified class name
        final String viewClassName = UserDaoRemoteFacadeInterface.class.getName();
        // let's do the lookup
        String prepared = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;
        System.out.println(prepared);
        return (UserDaoRemoteFacadeInterface) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
    }



}
