package org.jake.library.schedulers;

import lombok.RequiredArgsConstructor;
import org.jake.library.entities.BookLoan;
import org.jake.library.entities.Patron;
import org.jake.library.services.BookLoanService;
import org.jake.library.services.EmailService;
import org.jake.library.services.PatronService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private final EmailService emailService;
    private final BookLoanService bookLoanService;
    private final PatronService patronService;

    private static final Logger log = LoggerFactory.getLogger(EmailScheduler.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "0 0 9 * * *")
    public void overdueBookEmail() {
        bookLoanService.getOverduePatrons().forEach(integer -> {
            Patron p = patronService.getPatron(integer);
            List<BookLoan> bookLoanList = bookLoanService.getPatronOverdueBooks(integer);

            emailService.sendSimpleEmail(p.getEmail(), "Overdue books", "Dear " + p.getName() +
                    ",\n\nYou have " + bookLoanList.size() + " overdue books:\n" + overdueBookNames(bookLoanList)
                    + "\nPlease return them ASAP to avoid further fines.\n\nThis is an automated message, do not reply directly to this email.");
            log.info("Email sent to " + p.getEmail() + " at " + dateFormat.format(new Date()));
        });
    }

    public String overdueBookNames(List<BookLoan> bookLoanList) {
        StringBuilder stringBuilder = new StringBuilder("\n");
        bookLoanList.forEach((bookLoan) -> stringBuilder.append(bookLoan.getBook().getName() + "\n"));

        return stringBuilder.toString();
    }
}