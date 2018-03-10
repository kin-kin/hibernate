package jp.gr.java_conf.kk.dao;

/**
 * DAO session interface.
 * 
 * @author Koichi Kitamura
 * @version 1.0.0 2018/03/03
 */
public interface DAOSession extends AutoCloseable {
    
    /**
     * Begin the transaction.
     * 
     * @throws DAOException if database access failed.
     */
    void txBegin() throws DAOException;
    
    /**
     * Commit the transaction.
     * 
     * @throws DAOException if database access failed.
     */
    void txCommit() throws DAOException;
    
    /**
     * Roll-back the transaction.
     * 
     * @throws DAOException if database access failed.
     */
    void txRollback() throws DAOException;
    
    /**
     * Flush the session.
     * 
     * @throws DAOException if database access failed.
     */
    void flush() throws DAOException;
    
}
