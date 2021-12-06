
package ch.epai.ict.m226.gerons_nos_items_lsp_isp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Test;

public class PeriodicalTest {

    /**
     * Les getter de la classe Periodical doivent renvoyer les valeurs passé au
     * constructeur lorsque ces valeurs ne sont pas null.
     */
    @Test
    public void constructor_noNullValue_shouldReturnSameValue() {

        LocalDate publicationDate = LocalDate.now();

        Periodical b = new Periodical("id", "name", "issn", "publisher", publicationDate, "volume", "issue",
                "description", "language");

        Assert.assertNotNull(b);

        String expected;
        String actual;

        expected = "id";
        actual = b.getId();
        Assert.assertEquals(
                "L'accesseur getId doit renvoyer la valeur passée au constructeur Periodical(String title).", expected,
                actual);

        expected = "name";
        actual = b.getTitle();
        Assert.assertEquals(
                "L'accesseur getTitle doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "name";
        actual = b.getName();
        Assert.assertEquals(
                "L'accesseur getName doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "issn";
        actual = b.getIssn();
        Assert.assertEquals(
                "L'accesseur getIssn doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "publisher";
        actual = b.getPublisher();
        Assert.assertEquals(
                "L'accesseur getPublisher doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = publicationDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        actual = b.getPublicationDate();
        Assert.assertEquals(
                "L'accesseur getPublicationDate doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
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

        expected = "PERIODICAL";
        actual = b.getKindOfItem();
        Assert.assertEquals("L'accesseur getKindOfItem doit renvoyer la chaîne PERIODICAL.", expected, actual);
    }

    /**
     * Les getter de la classe Periodical doivent renvoyer des chaînes vides lorsque
     * les valeurs passées au constructeurs sont null.
     */
    @Test
    public void constructor_nullValue_shouldResturnEmptyStrings() {

        Periodical b = new Periodical(null, null, null, null, null, null, null, null, null);

        Assert.assertNotNull(b);

        String expected;
        String actual;

        expected = "";
        actual = b.getId();
        Assert.assertEquals(
                "L'accesseur getId doit renvoyer la valeur passée au constructeur Periodical(String title).", expected,
                actual);

        expected = "";
        actual = b.getTitle();
        Assert.assertEquals(
                "L'accesseur getTitle doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "";
        actual = b.getName();
        Assert.assertEquals(
                "L'accesseur getName doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "";
        actual = b.getIssn();
        Assert.assertEquals(
                "L'accesseur getIssn doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "";
        actual = b.getPublisher();
        Assert.assertEquals(
                "L'accesseur getPublisher doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
                expected, actual);

        expected = "";
        actual = b.getPublicationDate();
        Assert.assertEquals(
                "L'accesseur getPublicationDate doit renvoyer une chaîne vide si la valeur passée au constructeur est null.",
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
    }
 }
