package jp.gr.java_conf.kk.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import jp.gr.java_conf.kk.dao.DAO;
import jp.gr.java_conf.kk.dao.DAOException;

/**
 * DAO class using hibernate.
 * 
 * @author Koichi Kitamura
 * @version 1.0.0 2018/03/03
 */
abstract class DAOImpl<E, PK extends Serializable> implements DAO<E, PK> {
    
    /** hibernate session */
    protected final Session session;
    
    /** entity class */
    private final Class<E> entityClass;
    
    /**
     * Constructor.
     * 
     * @param session hibernate session
     * @param entityClass entity class
     */
    DAOImpl(final Session session, final Class<E> entityClass) {
        assert null != session;
        assert null != entityClass;
        
        this.session = session;
        this.entityClass = entityClass;
    }
    
    @Override
    public E selectByPK(final PK pk) throws DAOException {
        assert null != pk;
        
        E entity = null;
        
        try {
            entity = this.session.get(this.entityClass, pk);
        } catch (final Exception e) {
            throw new DAOException(e);
        }
        
        return entity;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public PK insert(final E entity) throws DAOException {
        assert null != entity;
        
        PK pk = null;
        
        try {
            pk = (PK) this.session.save(entity);
        } catch (final Exception e) {
            throw new DAOException(e);
        }
        
        return pk;
    }
    
    @Override
    public void update(final E entity) throws DAOException {
        assert null != entity;
        
        try {
            this.session.update(entity);
        } catch (final Exception e) {
            throw new DAOException(e);
        }
    }
    
    @Override
    public void delete(final E entity) throws DAOException {
        assert null != entity;
        
        try {
            this.session.delete(entity);
        } catch (final Exception e) {
            throw new DAOException(e);
        }
    }
    
    @Override
    public void delete(final List<E> entityList) throws DAOException {
        assert null != entityList;
        
        for (final E entity : entityList) {
            this.delete(entity);
        }
    }
    
}
