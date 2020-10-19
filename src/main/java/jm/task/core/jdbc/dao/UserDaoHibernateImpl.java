package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

import static jm.task.core.jdbc.util.Util.disHiberFactory;
import static jm.task.core.jdbc.util.Util.hiberFactory;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }


    @Override
    public void createUsersTable() {

        Session session = hiberFactory().openSession();
//        session.close();

    }

    @Override
    public void dropUsersTable() {
        Session session = hiberFactory().openSession();
        Transaction t = session.beginTransaction();
        session.createSQLQuery("DROP TABLE IF EXISTS `User`").executeUpdate();
        t.commit();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = hiberFactory().openSession();
        User currentUser = new User();
        currentUser.setName(name);
        currentUser.setLastName(lastName);
        currentUser.setAge(Byte.valueOf(age));
        Transaction t = session.beginTransaction();
        session.save(currentUser);
        t.commit();
//        session.close();

    }

    @Override
    public void removeUserById(long id) {
        Session session = hiberFactory().openSession();
        Transaction t = session.beginTransaction();
        User currentUser = new User();
        currentUser.setId(id);
        session.delete(currentUser);
        t.commit();
//        session.close();
    }

    @Override
    public List<User> getAllUsers() {
            Session session = hiberFactory().openSession();
            List<User> out = session.createQuery("from User").list();
            for (User usr : out) System.out.println(usr.toString());
//            session.close();
            return out;
    }

    @Override
    public void cleanUsersTable() {
        Session session = hiberFactory().openSession();
        Transaction t = session.beginTransaction();
//        session.delete("User");
        session.createQuery("delete from User").executeUpdate();
        t.commit();

//        session.close();

    }
}
