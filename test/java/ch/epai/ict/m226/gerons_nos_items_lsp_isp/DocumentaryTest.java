package ch.epai.ict.m226.gerons_nos_items_lsp_isp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class DocumentaryTest {

    /**
     * Les getter de la classe Documentary doivent renvoyer les valeurs passé au
     * constructeur lorsque ces valeurs ne sont pas null.
     */
    @Test
    public void constructor_noNullValue_shouldReturnSameValue() {
        ArrayList<PersonName> directors = new ArrayList<PersonName>();
        directors.add(new PersonNameImpl("lastName1", "firstName1"));

        ArrayList<PersonName> writers = new ArrayList<PersonName>();
        writers.add(new PersonNameImpl("lastName1", "firstName1"));

        LocalDate launchDate = LocalDate.now();

        Documentary b = new Documentary("id", "title", directors, writers, launchDate, "description", "language");

        Assert.assertNotNull(b);

        String expected;
        String actual;

        expected = "id";
        actual = b.getId();
        Assert.assertEquals(
                "L'accesseur getId doit renvoyer la valeur passée au constructeur Documentary(String title).", expected,
                actual);

        expected = "title";
        actual = b.getTitle();
        Assert.assertEquals(
                "L'accesseur getTitle doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = launchDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        actual = b.getLaunchDate();
        Assert.assertEquals(
                "L'accesseur getLaunchDate doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
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

        expected = "DOCUMENTARY";
        actual = b.getKindOfItem();
        Assert.assertEquals("L'accesseur getKindOfItem doit renvoyer la chaîne DOCUMENTARY.", expected, actual);

    }

    /**
     * Les getter de la classe Documentary doivent renvoyer des chaînes vides
     * lorsque les valeurs passées au constructeurs sont null.
     */
    @Test
    public void constructor_nullValue_shouldResturnEmptyStrings() {

        Documentary b = new Documentary(null, null, null, null, null, null, null);

        Assert.assertNotNull(b);

        String expected;
        String actual;

        expected = "";
        actual = b.getId();
        Assert.assertEquals(
                "L'accesseur getId doit renvoyer la valeur passée au constructeur.", expected,
                actual);

        expected = "";
        actual = b.getTitle();
        Assert.assertEquals(
                "L'accesseur getTitle doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "";
        actual = b.getLaunchDate();
        Assert.assertEquals(
                "L'accesseur getLaunchDate doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "";
        actual = b.getDescription();
        Assert.assertEquals(
                "L'accesseur getDescription doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "";
        actual = b.getLanguage();
        Assert.assertEquals(
                "L'accesseur getLanguage doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        Assert.assertNotNull(
                "L'accesseur getLanguage doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                b.getDirectors());

        Assert.assertNotNull(
                "L'accesseur getLanguage doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                b.getWriters());

    }

    @Test(expected = UnsupportedOperationException.class)
    public void getDirectors_shouldReturnUnmodifiableList(){
        Documentary b = new Documentary(null, null, null, null, null, null, null);
        b.getDirectors().add(null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getWriters_shouldReturnUnmodifiableList(){
        Documentary b = new Documentary(null, null, null, null, null, null, null);
        b.getWriters().add(null);
    }

    @Test
    /**
     * S'il y a plusieurs directors, la fonction doit renvoyer une chaîne qui contient
     * les noms des directors séparés par des virgules.
     */
    public void getDirectorsNames_severalDirectors_shouldReturnCommaSeparatedListOfDirector() {
        ArrayList<PersonName> directors = new ArrayList<PersonName>();
        directors.add(new PersonNameImpl("lastName1", "firstName1"));
        directors.add(new PersonNameImpl("lastName2", "firstName2"));
        directors.add(new PersonNameImpl("lastName3", "firstName3"));
        directors.add(new PersonNameImpl("lastName4", "firstName4"));

        Documentary b = new Documentary("id", "title", directors, null, null, "description", "language");

        String expected = "f. lastName1, f. lastName2, f. lastName3, f. lastName4";
        String actual = b.getDirectorsNames();
        Assert.assertEquals(
                "Avec plusieurs auteurs, la méthode getDirectorNames devrait renvoyer la chaîne \"lastName1, lastName2, ..., lastNameN\" où lastNameX sont les noms des l'auteurs.",
                expected, actual);
    }


    @Test
    /**
     * S'il y a plusieurs writers, la fonction doit renvoyer une chaîne qui contient
     * les noms des writers séparés par des virgules.
     */
    public void getWritersNames_severalWriters_shouldReturnCommaSeparatedListOfWriter() {
        ArrayList<PersonName> writers = new ArrayList<PersonName>();
        writers.add(new PersonNameImpl("lastName1", "firstName1"));
        writers.add(new PersonNameImpl("lastName2", "firstName2"));
        writers.add(new PersonNameImpl("lastName3", "firstName3"));
        writers.add(new PersonNameImpl("lastName4", "firstName4"));

        Documentary b = new Documentary("id", "title", null, writers, null, "description", "language");

        String expected = "f. lastName1, f. lastName2, f. lastName3, f. lastName4";
        String actual = b.getWritersNames();
        Assert.assertEquals(
                "Avec plusieurs auteurs, la méthode getWriterNames devrait renvoyer la chaîne \"lastName1, lastName2, ..., lastNameN\" où lastNameX sont les noms des l'auteurs.",
                expected, actual);
    }
}
