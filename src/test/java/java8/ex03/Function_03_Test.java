package java8.ex03;

import java8.data.Person;
import org.junit.Test;

import java.util.function.BinaryOperator;

/**
 * Exercice 03 - java.util.function.BinaryOperator
 */
public class Function_03_Test {

    //  tag::makeAChild[]
    // Compléter la fonction makeAChild
    // l'enfant possède le nom du père
    // l'enfant possède le prenom "<PRENOM_PERE> <PRENOM_MERE>"
    // l'age de l'enfant est 0
    // le mot de passe de l'enfant est null
    BinaryOperator<Person> makeAChild = (p,m) -> {
    	String prenom = p.getFirstname() + " " + m.getFirstname();
    	Person c = new Person(prenom, p.getLastname(), 0, null);
    	return c;
    };
    //  end::makeAChild[]


    @Test
    public void test_makeAChild() throws Exception {

        Person father = new Person("John", "France", 25, "johndoe");
        Person mother = new Person("Aline", "Lebreton", 22, "alino");

        // compléter le test pour qu'il soit passant
        Person child = makeAChild.apply(father, mother);

        assert child.getFirstname().equals("John Aline");
        assert child.getLastname().equals("France");
        assert child.getAge().equals(0);
        assert child.getPassword() == null;
    }

}
