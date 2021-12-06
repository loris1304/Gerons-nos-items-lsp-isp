package ch.epai.ict.m226.gerons_nos_items_lsp_isp;

import java.time.LocalDate;

public class LoanImpl implements Loan {

    private final int BORROW_DURATION_NUM_DAYS = 30;
    private String copyId;
    private LocalDate loanDate;
    private String borrowerId;
    private LocalDate returnDate;

    public LoanImpl(String copyId, LocalDate loanDate, String borrowerId) {
        this.copyId = copyId;

        if (loanDate == null) {
            this.loanDate = LocalDate.now();
        } else {
            this.loanDate = loanDate;
        }

        this.borrowerId = StringUtils.emptyStringIfNull(borrowerId);
    }

    public LocalDate getLoanDate() {
        return this.loanDate;
    }

    public LocalDate getReturnDate() {
        return this.returnDate;
    }

    @Override
    public void returnCopy(LocalDate date) {
        if (date == null) {
            this.returnDate = LocalDate.now();
        } else {
            this.returnDate = date;
        }

    }

    @Override
    public boolean isReturned() {
        if (this.returnDate != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public LocalDate getDueDate() {
        return loanDate.plusDays(BORROW_DURATION_NUM_DAYS);
    }

    @Override
    public boolean isOverdue() {
        if (!this.isReturned()) {
            return LocalDate.now().isAfter(getDueDate());
        }
        if (this.isReturned()) {
            return this.returnDate.isAfter(getDueDate());
        }
        return false;

    }

    @Override
    public String getCopyId() {
        return this.copyId;
    }

    @Override
    public String getBorrowerId() {
        return this.borrowerId;
    }
}
