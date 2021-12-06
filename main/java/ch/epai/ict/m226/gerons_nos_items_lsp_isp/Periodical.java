package ch.epai.ict.m226.gerons_nos_items_lsp_isp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Periodical implements LibraryItem {

    private String id;
    private String name;
    private String issn;
    private String publisher;
    private LocalDate publicationDate;
    private String volume;
    private String issue;
    private String description;
    private String language;

    public Periodical(String id, String name, String issn, String publisher, LocalDate publicationDate, String volume,
            String issue, String description, String language) {
        this.id = StringUtils.emptyStringIfNull(id);
        this.name = StringUtils.emptyStringIfNull(name);
        this.issn = StringUtils.emptyStringIfNull(issn);
        this.publisher = StringUtils.emptyStringIfNull(publisher);
        this.publicationDate = publicationDate;
        this.volume = StringUtils.emptyStringIfNull(volume);
        this.issue = StringUtils.emptyStringIfNull(issue);
        this.description = StringUtils.emptyStringIfNull(description);
        this.language = StringUtils.emptyStringIfNull(language);

    }

    public String getName() {
        return this.name;
    }

    public String getIssn() {
        return this.issn;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getPublicationDate() {
        if (publicationDate != null) {
            return this.publicationDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        }
        return "";

    }

    public String getVolume() {
        return this.volume;
    }

    public String getIssue() {
        return this.issue;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getTitle() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getLanguage() {
        return this.language;
    }

    @Override
    public String getKindOfItem() {
        return "PERIODICAL";
    }
}
