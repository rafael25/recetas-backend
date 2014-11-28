/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetas.backend.model;

import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author rafael
 */
public abstract class DAO {
	SessionFactory factory;
	Session session;
	Transaction transaction;
	
	public abstract String buscar() throws IOException;
	public abstract String buscar(Integer id) throws IOException;
	
	
	protected void openBegin() {
		this.factory = HibernateUtilities.getSessionFactory();
		this.session = this.factory.openSession();
		this.transaction = this.session.beginTransaction();
	}
	
	protected void closeCommit() {
		this.transaction.commit();
		this.session.close();
	}
}
