package ch.epai.ict.m226.gerons_nos_items_lsp_isp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoanManagerImpl implements LoanManager {

    private ArrayList<LoanImpl> loans;

    public LoanManagerImpl() {
        this.loans = new ArrayList<LoanImpl>();

    }

    public List<LoanImpl> getLoans() {
        return Collections.unmodifiableList(this.loans);

    }

    @Override
    public void loanCopy(String copyId, String borrowerId) {
        this.loanCopy(copyId, borrowerId, LocalDate.now());

    }

    @Override
    public void loanCopy(String copyId, String borrowerId, LocalDate date) {
        LoanImpl l = new LoanImpl(copyId, date, borrowerId);
        this.loans.add(l);

    }

    @Override
    public void returnCopy(String copyId) {
        returnCopy(copyId, null);

    }

    @Override
    public void returnCopy(String copyId, LocalDate date) {

        for (Loan loan : loans) {
            if (loan.getCopyId() == copyId) {
                loan.returnCopy(date);
            }
        }
    }

    @Override
    public LocalDate getDueDate(String copyId) {
        for (Loan loan : loans) {
            if (loan.getCopyId() == copyId) {
                return loan.getDueDate();
            }
        }
        return null;
    }

    @Override
    public boolean isBorrowed(String copyId) {
        Loan l = this.findCurrentLoan(copyId);
        return l != null;
    }

    @Override
    public boolean isOverdue(String copyId) {
        for (Loan loan : loans) {
            if (loan.getCopyId() == copyId) {
                return loan.isOverdue();
            }
        }
        return false;
    }

    @Override
    public Loan findCurrentLoan(String copyId) {
        for (int i = this.loans.size() - 1; i >= 0; i = i - 1) {
            Loan l = this.loans.get(i);
            if (!l.isReturned()) {
                return l;
            }
        }

        return null;
    }
}
