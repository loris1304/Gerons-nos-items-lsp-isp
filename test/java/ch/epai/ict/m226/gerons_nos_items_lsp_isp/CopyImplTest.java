package ch.epai.ict.m226.gerons_nos_items_lsp_isp;

import org.junit.*;

public class CopyImplTest {

    /**
     * Les accesseurs doivent renvoyé les valeurs passées au constructeur.
     */
    @Test
    public void constructor_initWithBook_shouldReturnValues() {

        Book item = new Book("id", "title", "isbn", "publisher", "year", 10, null, BookFormat.HARDCOVER, "description",
                "language");
        CopyImpl copyBook = new CopyImpl("id", "location", item);
        Assert.assertTrue("La classe CopyImpl doit implémeter l'interface Copy", copyBook instanceof Copy);

        String expected;
        String actual;

        expected = "id";
        actual = copyBook.getId();
        Assert.assertEquals("L'accesseur getId doit renvoyer une chaîne vide après l'instanciation", expected, actual);

        expected = "location";
        actual = copyBook.getLocation();
        Assert.assertEquals("L'accesseur getLocation doit renvoyer une chaîne vide après l'instanciation", expected,
                actual);

        actual = copyBook.getId();
        Assert.assertSame("L'accesseur getId doit renvoyer une chaîne vide après l'instanciation", item,
                copyBook.getItem());

    }


    /**
     * Les accesseurs doivent renvoyé les valeurs passées au constructeur.
     */
    @Test
    public void constructor_initWithDocumentary_shouldReturnValues() {

        Documentary item = new Documentary("id", "title", null, null, null, "description", "language");
        Copy copyBookB = new CopyImpl("id", "location", item);

        String expected;
        String actual;

        expected = "id";
        actual = copyBookB.getId();
        Assert.assertEquals("L'accesseur getId doit renvoyer une chaîne vide après l'instanciation", expected, actual);

        expected = "location";
        actual = copyBookB.getLocation();
        Assert.assertEquals("L'accesseur getLocation doit renvoyer une chaîne vide après l'instanciation", expected,
                actual);

        actual = copyBookB.getId();
        Assert.assertSame("L'accesseur getId doit renvoyer une chaîne vide après l'instanciation", item,
                copyBookB.getItem());

    }

    /**
     * Les accesseurs doivent renvoyé les valeurs passées au constructeur.
     */
    @Test
    public void constructor_initWithPeriodical_shouldReturnValues() {

        Periodical item = new Periodical("id", "name", "issn", "publisher", null, "volume", "issue", "description", "language");
        Copy copyBookB = new CopyImpl("id", "location", item);

        String expected;
        String actual;

        expected = "id";
        actual = copyBookB.getId();
        Assert.assertEquals("L'accesseur getId doit renvoyer une chaîne vide après l'instanciation", expected, actual);

        expected = "location";
        actual = copyBookB.getLocation();
        Assert.assertEquals("L'accesseur getLocation doit renvoyer une chaîne vide après l'instanciation", expected,
                actual);

        actual = copyBookB.getId();
        Assert.assertSame("L'accesseur getId doit renvoyer une chaîne vide après l'instanciation", item,
                copyBookB.getItem());

    }
}
