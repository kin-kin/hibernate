package jp.gr.java_conf.kk.dao.impl;

import org.hibernate.Session;

import jp.gr.java_conf.kk.dao.DAOException;
import jp.gr.java_conf.kk.dao.DAOSession;

/**
 * DAO session class using hibernate.
 * 
 * @author Koichi Kitamura
 * @version 1.0.0 2018/03/03
 */
class DAOSessionImpl implements DAOSession {
    
    /** hibernate session */
    private final Session session;
    
    /**
     * Constructor.
     * 
     * @param session hibernate session
     */
    DAOSessionImpl(final Session session) {
        assert null != session;
        
        this.session = session;
    }
    
    @Override
    public void txBegin() throws DAOException {
        try {
            this.session.getTransaction().begin();
        } catch (final Exception e) {
            throw new DAOException(e);
        }
    }
    
    @Override
    public void txCommit() throws DAOException {
        try {
            this.session.getTransaction().commit();
        } catch (final Exception e) {
            throw new DAOException(e);
        }
    }
    
    @Override
    public void txRollback() throws DAOException {
        try {
            this.session.getTransaction().rollback();
        } catch (final Exception e) {
            throw new DAOException(e);
        }
    }
    
    @Override
    public void flush() throws DAOException {
        try {
            this.session.flush();
        } catch (final Exception e) {
            throw new DAOException(e);
        }
    }
    
    @Override
    public void close() throws DAOException {
        try {
            this.session.close();
        } catch (final Exception e) {
            throw new DAOException(e);
        }
    }
    
    /**
     * Get the hibernate session.
     * 
     * @return hibernate session
     */
    public final Session getSession() {
        return this.session;
    }
    
}
