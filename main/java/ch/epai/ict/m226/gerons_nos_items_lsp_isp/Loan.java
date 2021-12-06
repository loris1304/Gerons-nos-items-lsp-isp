package ch.epai.ict.m226.gerons_nos_items_lsp_isp;

import java.time.LocalDate;

public interface Loan {
    
    public void returnCopy(LocalDate date);
    public boolean isReturned();
    public LocalDate getDueDate();
    public boolean isOverdue();
    public String getCopyId();
    public String getBorrowerId();
}
