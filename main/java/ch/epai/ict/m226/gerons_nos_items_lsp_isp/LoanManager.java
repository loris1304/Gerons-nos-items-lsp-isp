package ch.epai.ict.m226.gerons_nos_items_lsp_isp;

import java.time.LocalDate;

public interface LoanManager {
    
    public void loanCopy(String copyId, String borrowerId);
    public void loanCopy(String copyId, String borrowerId, LocalDate date);
    public void returnCopy(String copyId);
    public void returnCopy(String copyId, LocalDate date);
    public LocalDate getDueDate(String copyId);
    public boolean isBorrowed(String copyId);
    public boolean isOverdue(String copyId);
    public Loan findCurrentLoan(String copyId);
}
