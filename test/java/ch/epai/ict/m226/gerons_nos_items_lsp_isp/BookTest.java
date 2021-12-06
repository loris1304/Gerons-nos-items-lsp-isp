
package ch.epai.ict.m226.gerons_nos_items_lsp_isp;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class BookTest {

    /**
     * Les getter de la classe Book doivent renvoyer les valeurs passé au
     * constructeur lorsque ces valeurs ne sont pas null.
     */
    @Test
    public void constructor_noNullValue_shouldReturnSameValue() {
        ArrayList<PersonNameImpl> authors = new ArrayList<PersonNameImpl>();
        authors.add(new PersonNameImpl("lastName1", "firstName1"));

        Book b = new Book("id", "title", "isbn", "publisher", "year", 10, authors, BookFormat.HARDCOVER, "description",
                "language");

        Assert.assertNotNull(b);

        String expected;
        String actual;

        expected = "id";
        actual = b.getId();
        Assert.assertEquals("L'accesseur getId doit renvoyer la valeur passée au constructeur Book(String title).",
                expected, actual);

        expected = "title";
        actual = b.getTitle();
        Assert.assertEquals(
                "L'accesseur getTitle doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "isbn";
        actual = b.getIsbn();
        Assert.assertEquals(
                "L'accesseur getIsbn doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "publisher";
        actual = b.getPublisher();
        Assert.assertEquals(
                "L'accesseur getPublisher doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "year";
        actual = b.getYear();
        Assert.assertEquals(
                "L'accesseur getYear doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "description";
        actual = b.getDescription();
        Assert.assertEquals(
                "L'accesseur getDescription doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "language";
        actual = b.getLanguage();
        Assert.assertEquals(
                "L'accesseur getLanguage doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        Assert.assertEquals(
                "L'accesseur getYear doit renvoyer une chaîne vide si la valeur passée au constructeur est null.", 10,
                b.getNumOfPages());

        Assert.assertEquals(
                "L'accesseur getYear doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                BookFormat.HARDCOVER, b.getFormat());

        expected = "BOOK";
        actual = b.getKindOfItem();
        Assert.assertEquals("L'accesseur getKindOfItem doit renvoyer la chaîne BOOK.", expected, actual);

    }

    /**
     * Les getter de la classe Book doivent renvoyer des chaînes vides lorsque les
     * valeurs passées au constructeurs sont null.
     */
    @Test
    public void constructor_nullValue_shouldResturnEmptyStrings() {
        ArrayList<PersonNameImpl> authors = new ArrayList<PersonNameImpl>();
        authors.add(new PersonNameImpl("lastName1", "firstName1"));

        Book b = new Book(null, null, null, null, null, 10, null, BookFormat.HARDCOVER, null, null);

        Assert.assertNotNull(b);

        String expected;
        String actual;

        expected = "";
        actual = b.getId();
        Assert.assertEquals("L'accesseur getId doit renvoyer la valeur passée au constructeur Book(String title).",
                expected, actual);

        expected = "";
        actual = b.getTitle();
        Assert.assertEquals(
                "L'accesseur getTitle doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "";
        actual = b.getIsbn();
        Assert.assertEquals(
                "L'accesseur getIsbn doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "";
        actual = b.getPublisher();
        Assert.assertEquals(
                "L'accesseur getPublisher doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "";
        actual = b.getYear();
        Assert.assertEquals(
                "L'accesseur getYear doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "";
        actual = b.getDescription();
        Assert.assertEquals(
                "L'accesseur getYear doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "";
        actual = b.getLanguage();
        Assert.assertEquals(
                "L'accesseur getYear doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "BOOK";
        actual = b.getKindOfItem();
        Assert.assertEquals("L'accesseur getKindOfItem doit renvoyer la chaîne BOOK.", expected, actual);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getAuthors_shouldReturnUnmodifiableList(){
        Book b = new Book(null, null, null, null, null, 0, null, BookFormat.HARDCOVER, null, null);
        b.getAuthors().add(null);
    }

    @Test
    /**
     * La méthode getAuthorsNames renvoie une chaîne qui contient la liste des noms
     * complets (fullName) des auteurs séparés par des virgules.
     */
    public void getAuthorsNames_oneAuthor_shouldReturnAuthor() {
        ArrayList<PersonNameImpl> a = new ArrayList<>();
        a.add(new PersonNameImpl("Lastname1", "1Firstname"));
        Book b = new Book("id", "title", "isbn", "publisher", "year", 10, a, BookFormat.HARDCOVER, "description",
                "language");
        String expected = "1. Lastname1";
        String actual = b.getAuthorsNames();
        Assert.assertEquals(expected, actual);
    }

    @Test
    /**
     * S'il y a plusieurs auteurs, la fonction doit renvoyer une chaîne qui contient
     * les noms complets (fullName) des auteurs séparés par des virgules.
     */
    public void getAuthorsNames_severalAuthors_shouldReturnCommaSeparatedListOfAuthor() {
        ArrayList<PersonNameImpl> a = new ArrayList<PersonNameImpl>();
        a.add(new PersonNameImpl("lastName1", "firstName1"));
        a.add(new PersonNameImpl("lastName2", "firstName2"));
        a.add(new PersonNameImpl("lastName3", "firstName3"));
        a.add(new PersonNameImpl("lastName4", "firstName4"));

        Book b = new Book("id", "title", "isbn", "publisher", "year", 10, a, BookFormat.HARDCOVER, "description",
                "language");

        String expected = "f. lastName1, f. lastName2, f. lastName3, f. lastName4";
        String actual = b.getAuthorsNames();
        Assert.assertEquals(
                "Avec plusieurs auteurs, la méthode getAuthorNames devrait renvoyer la chaîne \"f. lastName1, f. lastName2, ..., f. lastNameN\" où f. lastNameX sont les noms complets des l'auteurs.",
                expected, actual);
    }
}
