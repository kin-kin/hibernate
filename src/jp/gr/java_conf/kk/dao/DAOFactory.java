package jp.gr.java_conf.kk.dao;

import jp.gr.java_conf.kk.dao.impl.DAOLibrary;

/**
 * DAO factory class.
 * 
 * @author Koichi Kitamura
 * @version 1.0.0 2018/03/03
 */
public class DAOFactory {
    
    /** DAO library */
    private static final DAOLibrary lib
        = DAOLibrary.createDAOLibrary();
    
    /**
     * Constructor.
     */
    protected DAOFactory() {
        assert false : "factory class is never instantiated";
    }
    
    /**
     * Open a DAO session.
     * 
     * @return DAO session
     * @throws DAOException if database access failed.
     */
    public static DAOSession openSession() throws DAOException {
        return DAOFactory.lib.openSession();
    }
    
    /**
     * Create a DAO for account table.
     * 
     * @param session DAO session
     * @return DAO
     * @throws DAOException if database access failed.
     */
    public static AccountDAO createAccountDAO(final DAOSession session)
            throws DAOException {
        assert null != session;
        
        return (AccountDAO) DAOFactory.lib.createDAO(session, AccountDAO.class);
    }
    
    /**
     * Create a DAO for account_role table.
     * 
     * @param session DAO session
     * @return DAO
     * @throws DAOException if database access failed.
     */
    public static AccountRoleDAO createAccountRoleDAO(final DAOSession session)
            throws DAOException {
        assert null != session;
        
        return (AccountRoleDAO) DAOFactory.lib.createDAO(session, AccountRoleDAO.class);
    }
    
}
