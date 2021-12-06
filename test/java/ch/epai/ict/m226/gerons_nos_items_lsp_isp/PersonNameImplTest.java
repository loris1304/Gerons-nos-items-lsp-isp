package ch.epai.ict.m226.gerons_nos_items_lsp_isp;

import org.junit.Assert;
import org.junit.Test;

public class PersonNameImplTest {

    /**
     * L'accesseur getLastName doit renvoyer la valeur de l'attribut lastName. Après
     * l'instanciation, la valeur de l'attribut lastName doit être celle du
     * paramètre lastName passée au constructeur ou une chaîne vide si cette valeur
     * est null.
     */
    @Test
    public void getLastName_instanciateNewObject_returnLastName() {

        PersonName a;
        String expected;
        String actual;

        expected = "lastName2";
        a = new PersonNameImpl(expected, "");
        actual = a.getLastName();
        Assert.assertEquals(
                "L'accesseur getLastName doit renvoyer la valeur passée au constructeur.",
                expected, actual);

        expected = "";
        a = new PersonNameImpl(null, "");
        actual = a.getLastName();
        Assert.assertEquals(
                "L'accesseur getLastName doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);
    }


    /**
     * L'accesseur getFirstName doit renvoyer la valeur de l'attribut firstName.
     * Après l'instanciation, la valeur de l'attribut firstName doit être celle du
     * paramètre firstName passée au constructeur ou une chaîne vide si cette valeur
     * est null.
     */
    @Test
    public void getFirstName_instanciateNewObject_shouldReturnFirstName() {

        PersonName a;
        String expected;
        String actual;

        expected = "firstName";
        a = new PersonNameImpl("lastName", expected);
        actual = a.getFirstName();
        Assert.assertEquals(
                "L'accesseur getFirstName doit renvoyer la valeur passée au constructeur.",
                expected, actual);

        expected = "";
        a = new PersonNameImpl("lastName", null);
        actual = a.getFirstName();
        Assert.assertEquals(
                "L'accesseur getFirstName doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);
    }


    @Test
    /**
     * Si l'attribut firstName est une chaîne vide, la méthode doit renvoyer la
     * valeur de l'attribut lastName.
     */
    public void getFullName_lastNameOnly_shouldReturnLastName() {

        PersonName a;
        String expected;
        String actual;

        expected = "lastName1";
        a = new PersonNameImpl("lastName1", "");
        actual = a.getFullName();
        Assert.assertEquals(
                "Si l'attribut firstName est une chaîne vide, la méthode getFullName doit renvoyer la valeur de l'attribut lastName.",
                expected, actual);

        expected = "lastName2";
        a = new PersonNameImpl("lastName2", "");
        actual = a.getFullName();
        Assert.assertEquals("Le mutateur setFirstName doit modifier la valeur de l'attribut firstName.", expected,
                actual);
    }

    @Test
    /**
     * Si l'attribut lastName est une chaîne vide, la méthode doit renvoyer la
     * valeur de l'attribut firstName.
     */
    public void getFullName_firstNameOnly_shouldReturnFirstName() {

        PersonName a;
        String expected;
        String actual;

        expected = "firstName1";
        a = new PersonNameImpl("", "firstName1");
        actual = a.getFullName();
        Assert.assertEquals(
                "Si l'attribut lastName est une chaîne vide, la méthode getFullName doit renvoyer la valeur de l'attribut firstName.",
                expected, actual);

        expected = "firstName2";
        a = new PersonNameImpl("", "firstName2");
        actual = a.getFullName();
        Assert.assertEquals(
                "Si l'attribut lastName est une chaîne vide, la méthode getFullName doit renvoyer la valeur de l'attribut firstName.",
                expected, actual);
    }

    @Test
    /**
     * Si l'attribut firstName et l'attribut lastName ont une valeur, la méthode
     * doit renvoyer une chaîne composée de l'initiale du prénom suivies d'une
     * espace et du noms.
     */
    public void getFullName_lastNameAndFirstName_shouldReturnFirstNameSpaceLastName() {

        PersonName a = new PersonNameImpl("lastName", "firstName");

        String expected = "f. lastName";
        String actual = a.getFullName();

        Assert.assertEquals(
                "Si l'attribut firstName et l'attribut lastName ont une valeur, la méthodegetFullName doit renvoyer une chaîne composée du nom suivi d'une virgule etde l'initiale du prénom.",
                expected, actual);
    }

}
