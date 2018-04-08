package jp.gr.java_conf.kk.dao.impl;

import java.io.File;
import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jp.gr.java_conf.kk.dao.AccountDAO;
import jp.gr.java_conf.kk.dao.AccountRoleDAO;
import jp.gr.java_conf.kk.dao.DAO;
import jp.gr.java_conf.kk.dao.DAOException;
import jp.gr.java_conf.kk.dao.DAOSession;
import jp.gr.java_conf.kk.dao.entity.Account;
import jp.gr.java_conf.kk.dao.entity.AccountRole;

/**
 * DAO library class using hibernate.
 * 
 * @author Koichi Kitamura
 * @version 1.0.0 2018/03/03
 */
class DAOLibraryImpl implements DAOLibrary {
    
    /** hibernate configuration file */
    private final File configFile;
    
    /** hibernate sessino factory (singleton) */
    private SessionFactory sessionFactory = null;
    
    /**
     * Constructor.
     * 
     * @param configFile hibernate configuration file
     */
    DAOLibraryImpl(final File configFile) {
        assert null != configFile;
        
        this.configFile = configFile;
    }
    
    @Override
    public DAOSession openSession() throws DAOException {
        try {
            this.createSessionFactory();
            
            return new DAOSessionImpl(this.sessionFactory.openSession());
        } catch (final Exception e) {
            throw new DAOException(e);
        }
    }
    
    @Override
    public DAO<?, ? extends Serializable> createDAO(final DAOSession session,
            final Class<? extends DAO<?, ? extends Serializable>> daoClass) {
        assert null != session;
        assert null != daoClass;
        
        final Session s = ((DAOSessionImpl) session).getSession();
        DAO<?, ? extends Serializable> dao = null;
        
        if (AccountDAO.class == daoClass) {
            dao = new AccountDAOImpl(s);
        } else if (AccountRoleDAO.class == daoClass) {
            dao = new AccountRoleDAOImpl(s);
        }
        
        return dao;
    }
    
    /**
     * Create a hibernate session factory.
     */
    private synchronized void createSessionFactory() {
        if (null == this.sessionFactory) {
            this.sessionFactory = (new Configuration())
                    .configure(this.configFile)
                    .addClass(Account.class)
                    .addClass(AccountRole.class)
                    .buildSessionFactory();
        }
    }
    
}
