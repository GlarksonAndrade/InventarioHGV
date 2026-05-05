package testes;

import infra.DAO;
import model.HashSenhas;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;


public class TesteCriarUsuarioDB {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("InventarioHGV");
    static EntityManager em = emf.createEntityManager();
      public static void main(String[] args) {
        Usuario usuario = new Usuario();
        HashSenhas hs = new HashSenhas();
        Scanner sc = new Scanner(System.in);
        DAO<Object> dao = new DAO<>();


        usuario.setLogin("login2");
        usuario.setNome("Cristovão Colombo");
        usuario.setAdmin(true);
        usuario.setHashSenha(hs.hashPassword(sc.nextLine() + usuario.getSalt())); //Digitar a senha.
       // DAO<Object> dao = new DAO<>();

        /*dao.openTransaction();
        dao.include(usuario);
        dao.include(hs);
        //dao.include(eqp1);
        dao.closeTransaction();
        dao.close();*/

        System.out.println(usuario.getHashSenha());

        dao.atomicInclude(usuario);



    }

}
