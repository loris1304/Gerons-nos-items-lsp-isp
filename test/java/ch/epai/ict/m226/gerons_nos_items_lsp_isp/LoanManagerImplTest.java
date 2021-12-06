package ch.epai.ict.m226.gerons_nos_items_lsp_isp;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class LoanManagerImplTest {

    /**
     * La classe LoanManger doit avoir un constructeur avec la signature
     * LoanManager().
     */
    @Test
    public void constructor_shouldCreateInstance() {
        LoanManagerImpl loanManager = new LoanManagerImpl();

        Assert.assertTrue("La classe LoanManagerImpl doit implémenter l'interface LoanManager.", loanManager instanceof LoanManager);
        Assert.assertNotNull("L'objet loanManager doit être instancié.", loanManager);
    }

    /**
     * loanCopy doit ajouter une entrée dans la liste de prêts à la date courante.
     */
    @Test
    public void loanCopy_shouldAddLoanAtCurrentDate() {

        String borrowerId = "Mr. Robot";
        String copyId = "id";

        LoanImpl loanExpected = new LoanImpl(copyId, LocalDate.now(), borrowerId);
        int loanSizeExpected = 0;
        LoanManagerImpl loanManager = new LoanManagerImpl();

        Assert.assertEquals(loanSizeExpected, loanManager.getLoans().size());

        loanManager.loanCopy(copyId, borrowerId);

        loanSizeExpected = 1;
        Assert.assertEquals(loanSizeExpected, loanManager.getLoans().size());

        Assert.assertEquals(loanExpected.getCopyId(), loanManager.getLoans().get(0).getCopyId());
        Assert.assertEquals(loanExpected.getBorrowerId(), loanManager.getLoans().get(0).getBorrowerId());
        Assert.assertEquals(loanExpected.getDueDate(), loanManager.getLoans().get(0).getDueDate());
    }

    /**
     * returnCopy doit ajouter la date de retour de l'exemplaire dans la liste des
     * prêts.
     */
    @Test
    public void returnCopy_shouldAddReturnDateIntoCorrectLoan() {
        String copyIdArray[] = { "id1","id2","id3" };
        String borrowerIdArray[] = { "Mr. Robot", "Mr. Jones", "Mrs. Raider" };

        LoanManagerImpl loanManager = new LoanManagerImpl();
        for (int i = 0; i < 3; i = i + 1) {
            loanManager.loanCopy(copyIdArray[i], borrowerIdArray[i]);
        }
        loanManager.returnCopy(copyIdArray[1]);

        LocalDate dateReturnedCopyExpected = LocalDate.now();
        Assert.assertEquals(dateReturnedCopyExpected, loanManager.getLoans().get(1).getReturnDate());
        Assert.assertEquals(null, loanManager.getLoans().get(0).getReturnDate());
        Assert.assertEquals(null, loanManager.getLoans().get(2).getReturnDate());
    }

    /**
     * getDueDate doit renvoyer la date de retour de l'exemplaire en prêt.
     */
    @Test
    public void getDueDate_shouldReturnDateOfReturn() {
        String borrower = "Mr. Robot";

        LocalDate loanDate = LocalDate.now();
        LocalDate dueDateExpected = loanDate.plusDays(30);

        LoanManager loanManager = new LoanManagerImpl();
        loanManager.loanCopy("id", borrower, loanDate);

        Assert.assertEquals(dueDateExpected, loanManager.getDueDate("id"));
    }

    /**
     * isBorrowed doit renvoyer vrai si une entrée de l'exemplaire est en prêt. Dans
     * tous les autres cas, elle doit retourner false.
     */
    @Test
    public void isBorrowed_shouldReturnTrueIfBorrowedElseFalse() {
        String copyIdArray[] = { "id1","id2","id3" };
        String borrowerIdArray[] = { "Mr. Robot", "Mr. Jones", "Mrs. Raider" };

        LoanManagerImpl loanManager = new LoanManagerImpl();
        for (int i = 0; i < 3; i = i + 1) {
            loanManager.loanCopy(copyIdArray[i], borrowerIdArray[i]);
        }
        loanManager.returnCopy(copyIdArray[1]);

        // Make a loan
        loanManager.loanCopy(copyIdArray[1], borrowerIdArray[1]);
        loanManager.returnCopy(copyIdArray[1]);
        loanManager.loanCopy(copyIdArray[1], borrowerIdArray[0]);

        Assert.assertTrue(loanManager.isBorrowed(copyIdArray[1]));

    }

    /**
     * isOverDue doit renvoyer vrai si l'exemplaire est en prêt et que l'échéance
     * est passée.
     */
    @Test
    public void isOverdue_shouldReturnTrueIfDateIsOverDueOtherwiseFalse() {
        String copyIdArray[] = { "id1","id2","id3" };
        String borrowerIdArray[] = { "Mr. Robot", "Mr. Jones", "Mrs. Raider" };

        LocalDate currentDate = LocalDate.now();
        LocalDate loanDate = currentDate.plusDays(-40);

        LoanManager loanManager = new LoanManagerImpl();
        for (int i = 0; i < 2; i = i + 1) {
            loanManager.loanCopy(copyIdArray[i], borrowerIdArray[i], loanDate);
            loanManager.returnCopy(copyIdArray[i], currentDate);
        }

        loanManager.loanCopy(copyIdArray[2], borrowerIdArray[2], loanDate);

        Assert.assertFalse(loanManager.isOverdue(copyIdArray[0]));
        Assert.assertFalse(loanManager.isOverdue(copyIdArray[1]));
        Assert.assertTrue(loanManager.isOverdue(copyIdArray[2]));
    }
}
