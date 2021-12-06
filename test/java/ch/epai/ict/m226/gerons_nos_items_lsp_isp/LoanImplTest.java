package ch.epai.ict.m226.gerons_nos_items_lsp_isp;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class LoanImplTest {

    /**
     * La classe Loan doit avoir un constructeur avec la signature Loan(Copy copy,
     * LocalDate loanDate, String borrower).
     */
    @Test
    public void constructor_shouldCreateInstance() {

        // Test case with all null parameters
        String copyExpected = null;
        LocalDate loanDateExpected = LocalDate.now();
        LocalDate returnDateExpected = null;
        String borrowerExpected = "";

        LoanImpl loan = new LoanImpl(null, null, null);
        Assert.assertNotNull(loan);
        Assert.assertTrue("La classe LoanImpl doit implémenter l'inter Loan", loan instanceof Loan);
        Assert.assertEquals("La valeur de l'identifiant de la copy doit être exactement celle qui est passée en paramètre", copyExpected, loan.getCopyId());
        Assert.assertEquals("Si la date passée en paramètre est null, la valeur de l'attribut loanDate doit être la date courante.", loanDateExpected, loan.getLoanDate());
        Assert.assertEquals("La valeur de l'attribut returnDate doit être null", returnDateExpected, loan.getReturnDate());
        Assert.assertEquals("Si la valeur de l'identifiant de l'emprunteur est null, la valeur de l'attribut borrowerId doit être une chaîne vide.", borrowerExpected, loan.getBorrowerId());

        copyExpected = "id";
        loanDateExpected = LocalDate.now();
        returnDateExpected = null;
        borrowerExpected = "Mr. Robot";

        loan = new LoanImpl("id", LocalDate.now(), "Mr. Robot");
        Assert.assertNotNull("L'objet loan ne peut pas être null.", loan);
        Assert.assertEquals("La copy enregistrée doit correspondre à la copy passée en paramètre", copyExpected,
                loan.getCopyId());
        Assert.assertEquals("La LocalDate du prêt doit entre iniaitalisée.", loanDateExpected, loan.getLoanDate());
        Assert.assertEquals("La LocalDate de retour doit être null.", returnDateExpected, loan.getReturnDate());
        Assert.assertEquals("L'emprenteur doit être initialisé.", borrowerExpected, loan.getBorrowerId());

    }

    /**
     * La méthode returnCopy doit enregistrer la date de retour de l'exemplaire.
     */
    @Test
    public void returnCopy_shouldStoreReturnDate() {

        LoanImpl loan = new LoanImpl("id", LocalDate.now(), "Mr. Robot");

        LocalDate returnDateExpected = LocalDate.now();

        loan.returnCopy(LocalDate.now());
        returnDateExpected = LocalDate.now();
        Assert.assertEquals("La LocalDate de retour doit être la LocalDate courente", returnDateExpected,
                loan.getReturnDate());
    }

    /**
     * La méthode isReturned doit renvoyer faux si la date de retour est null.
     */
    @Test
    public void isReturned_notReturned_shouldReturnFalse() {

        LocalDate loanDate = LocalDate.now();

        Loan loan = new LoanImpl("id", loanDate, "Mr. Robot");

        Assert.assertFalse("Si l'emprunt n'est pas revenu, isReturned doit renvoyer faux.", loan.isReturned());
    }

    /**
     * La méthode isReturned doit renvoyer vrai si la date de retour n'est pas null.
     */
    @Test
    public void isReturned_returned_shouldReturnTrue() {

        LocalDate loanDate = LocalDate.now();

        Loan loan = new LoanImpl("id", loanDate, "Mr. Robot");
        loan.returnCopy(loanDate);

        Assert.assertTrue("Si l'emprunt est revenu, isReturned doit renvoyer vrai.", loan.isReturned());
    }

    /**
     * La méthode getDueDate doit renvoyer la date d'emprunt plus 30 jours.
     */
    @Test
    public void getDueDate_shouldReturnLoanDatePlus30Days() {

        LocalDate loanDate = LocalDate.now();
        LocalDate dueDate = loanDate.plusDays(30);

        LocalDate dueDateExpected;
        Loan loan;

        dueDateExpected = dueDate;

        loan = new LoanImpl("id", loanDate, "Mr. Robot");

        Assert.assertEquals("La méthode getDueDate doit renvoyer la LocalDate d'emprunt plus 30 jours.",
                dueDateExpected, loan.getDueDate());

        loanDate = loanDate.plusMonths(-12);
        dueDate = loanDate.plusDays(30);
        dueDateExpected = dueDate;

        loan = new LoanImpl("id", loanDate, "Mr. Robot");

        Assert.assertEquals("La méthode getDueDate doit renvoyer la LocalDate d'emprunt plus 30 jours.",
                dueDateExpected, loan.getDueDate());
    }

    /**
     * La méthode isOverdue doit renvoyer faux si l'emprunt vient d'être créé.
     */
    @Test
    public void isOverdue_notReturnedNotOverdue_shouldReturnFalse() {

        LocalDate loanDate = LocalDate.now();

        Loan loan = new LoanImpl("id", loanDate, "Mr. Robot");

        Assert.assertFalse("Un emprunt qui vient d'être fait ne devrait pas être en retard.", loan.isOverdue());
    }

    /**
     * La méthode isOverdue doit renvoyer vrai ii l'emprunt a été fait il y a plus
     * de 30 jours et que la date de retour est null.
     */
    @Test
    public void isOverdue_notReturnedOverdue_shouldReturnTrue() {

        LocalDate loanDate = LocalDate.now().plusDays(-31);

        Loan loan = new LoanImpl("id", loanDate, "Mr. Robot");

        Assert.assertTrue("Un emprunt fait il y plus 30 jours et qui n'est pas revenu, devrait être en retard.",
                loan.isOverdue());
    }

    /**
     * La méthode isOverdue doit renvoyer faut si la date retour ne dépasse pas la
     * date d'emprunt plus 30 jours.
     */
    @Test
    public void isOverdue_returnedWithin30Days_shouldReturnFalse() {

        LocalDate loanDate = LocalDate.now().plusDays(-40);
        LocalDate returnDate = LocalDate.now().plusDays(-20);

        Loan loan = new LoanImpl("id", loanDate, "Mr. Robot");
        loan.returnCopy(returnDate);

        Assert.assertFalse(
                "Un emprunt fait il y plus 30 jours et qui est revenu dans les temps, ne devrait pas être en retard.",
                loan.isOverdue());
    }

    /**
     * La méthode isOverdue doit renvoyer vrai si la date de retour dépasse la date
     * d'emprunt de plus 30 jours. retard.
     */
    @Test
    public void isOverdue_returnedButNotWithin30Days_shouldReturnTrue() {

        LocalDate loanDate = LocalDate.now().plusDays(-40);
        LocalDate returnDate = LocalDate.now().plusDays(-5);

        Loan loan = new LoanImpl("id", loanDate, "Mr. Robot");
        loan.returnCopy(returnDate);

        Assert.assertTrue("Un emprunt qui est revenu mais pas dans les 30 jours, devrait être en retard.",
                loan.isOverdue());
    }

}
