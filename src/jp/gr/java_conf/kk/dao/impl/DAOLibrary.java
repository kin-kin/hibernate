package jp.gr.java_conf.kk.dao.impl;

import java.io.File;
import java.io.Serializable;

import jp.gr.java_conf.kk.dao.DAO;
import jp.gr.java_conf.kk.dao.DAOException;
import jp.gr.java_conf.kk.dao.DAOSession;

/**
 * DAO library interface.
 * 
 * @author Koichi Kitamura
 * @version 1.0.0 2018/03/03
 */
public interface DAOLibrary {
    
    /**
     * Create a DAO library using hibernate.
     * 
     * @return DAO library
     */
    static DAOLibrary createDAOLibrary() {
        return new DAOLibraryImpl(new File(
                DAOLibrary.class.getClassLoader()
                .getResource("hibernate.cfg.xml").getPath()));
    }
    
    /**
     * Open a DAO session.
     * 
     * @return DAO session
     * @throws DAOException if database access failed.
     */
    DAOSession openSession() throws DAOException;
    
    /**
     * Create a DAO.
     * 
     * @param session DAO session
     * @param daoClass DAO interface class
     * @return DAO (null if no DAO was found)
     * @throws DAOException
     */
    DAO<?, ? extends Serializable> createDAO(final DAOSession session,
            final Class<? extends DAO<?, ? extends Serializable>> daoClass)
            throws DAOException;
    
}
