package jp.gr.java_conf.kk.dao;

import java.io.Serializable;
import java.util.List;

/**
 * DAO interface.
 * 
 * @author Koichi Kitamura
 * @version 1.0.0 2018/03/03
 */
public interface DAO<E, PK extends Serializable> {
    
    /**
     * Get all entities.
     * 
     * @return entity list (empty if no entity was found)
     * @throws DAOException if database access failed.
     */
    List<E> selectAll() throws DAOException;
    
    /**
     * Get an entity selected by the primary key.
     * 
     * @param pk primary key
     * @return entity (null if no entity was found)
     * @throws DAOException if database access failed.
     */
    E selectByPK(PK pk) throws DAOException;
    
    /**
     * Get an entity selected by the primary key for update.
     * 
     * @param pk primary key
     * @return entity (null if no entity was found)
     * @throws DAOException if database access failed.
     */
    E selectByPKForUpdate(PK pk) throws DAOException;
    
    /**
     * Get all entity counts.
     * 
     * @return all entity counts.
     * @throws DAOException if database access failed.
     */
    long selectCountAll() throws DAOException;
    
    /**
     * Insert an entity.
     * 
     * @param entity entity
     * @return primary key
     * @throws DAOException if database access failed.
     */
    PK insert(E entity) throws DAOException;
    
    /**
     * Update an entity.
     * 
     * @param entity entity
     * @throws DAOException if database access failed.
     */
    void update(E entity) throws DAOException;
    
    /**
     * Delete an entity.
     * 
     * @param entity entity
     * @throws DAOException if database access failed.
     */
    void delete(E entity) throws DAOException;
    
    /**
     * Delete some entities.
     * 
     * @param entityList entity list
     * @throws DAOException if database access failed.
     */
    void delete(List<E> entityList) throws DAOException;
    
}
