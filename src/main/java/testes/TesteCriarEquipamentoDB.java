package testes;

import infra.DAO;
import model.Equipamento;
import model.Fornecedor;
import model.Setor;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLOutput;

public class TesteCriarEquipamentoDB {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("InventarioHGV");
    static EntityManager em = emf.createEntityManager();
    public static void main(String[] args) {

        Fornecedor fornecedor = new Fornecedor("SIMPRESS","SIMPRESS@SIMPRESS.COM",40028922);
        Setor setor = new Setor("VASCULAR",3,40028922);
        Equipamento eqp1 = new Equipamento();


        setor.adicionarEquipamento(eqp1);

       DAO<Object> dao = new DAO<>();

       dao.openTransaction();
       dao.include(fornecedor);
       dao.include(setor.getEquipamentos().get(0));
       dao.include(eqp1);
       dao.closeTransaction();
       dao.close();

        System.out.println(fornecedor);

}

}

