package java8.ex02;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 02 - Redéfinition
 */
public class Method_02_Test {

    // tag::IDao[]
    interface IDao {
        List<Person> findAll();

        default String format(){
        	int nb_personnes = findAll().size();
        	String s="[" + nb_personnes + " persons]";
        	return s;
        }
        // TODO créer une méthode String format()
        // TODO la méthode retourne une chaîne de la forme [<nb_personnes> persons]
        // TODO exemple de résultat : "[14 persons]", "[30 persons]"
    }
    // end::IDao[]

    // tag::DaoA[]
    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }

        // L'implémentation réutilise la méthode format() de l'interface
        @Override
        public String format(){
        	String sA = "DaoA" + IDao.super.format();
        	
        	return sA;
        }
       

    }
    // end::DaoA[]

    @Test
    public void test_daoA_format() throws Exception {

        DaoA daoA = new DaoA();

        // Invoquer la méthode format() pour que le test soit passant
        String result = daoA.format();

        assert "DaoA[20 persons]".equals(result);
    }
}
