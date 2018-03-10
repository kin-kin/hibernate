package jp.gr.java_conf.kk.dao;

/**
 * DAO exception class.
 * 
 * @author Koichi Kitamura
 * @version 1.0.0 2018/03/03
 */
public class DAOException extends Exception {
    
    /** serial version ID */
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructor.
     * 
     * @param cause the cause
     */
    public DAOException(final Throwable cause) {
        super(cause);
    }
    
}
