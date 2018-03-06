package java8.ex02;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Exercice 02 - Map
 */
public class Lambda_02_Test {

    // tag::PersonToAccountMapper[]
    interface SomethingToSomethingMapper <T,E>{
        E map(T t);
    }
    // end::PersonToAccountMapper[]

    // tag::map[]
    private <T,E> List<E> map(List<T> list, SomethingToSomethingMapper<T, E> mapper) {
        // Implémenter la méthode pour transformer une liste de personnes en liste de comptes
    	List<E> compte = new ArrayList<E>();
    	for(T t : list){
    		compte.add( mapper.map(t));
    	}
    	
        return compte;
    }
    // end::map[]

    // tag::test_map_person_to_account[]
    @Test
    public void test_map_person_to_account() throws Exception {

        List<Person> personList = Data.buildPersonList(100);
        // Transformer la liste de personnes en liste de comptes
        // Tous les objets comptes ont un solde à 100 par défaut
        List<Account> result = map(personList, p -> {
        	Account account = new Account();
        	account.setOwner((Person)p);
        	account.setBalance(100);
        	return account;
        });

        assert result.size() == personList.size();
        for (Account account : result) {
            assert account.getBalance().equals(100);
            assert account.getOwner() != null;
        }
    }
    // end::test_map_person_to_account[]

    // tag::test_map_person_to_firstname[]
    @Test
    public void test_map_person_to_firstname() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // Transformer la liste de personnes en liste de prénoms
        List<String> result = map(personList, p -> p.getFirstname());
        

        assert result.size() == personList.size();
        for (String firstname : result) {
            assert firstname.startsWith("first");
        }
    }
    // end::test_map_person_to_firstname[]
}
