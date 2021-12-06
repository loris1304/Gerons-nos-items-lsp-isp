package ch.epai.ict.m226.gerons_nos_items_lsp_isp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book implements LibraryItem {

    private String id;
    private String title;
    private String isbn;
    private String publisher;
    private String year;
    private int numOfPages;
    private ArrayList<PersonNameImpl> authors;
    private BookFormat format;
    private String description;
    private String language;

    /**
     * 
     * @param id
     * @param title
     * @param isbn
     * @param publisher
     * @param year
     * @param numOfPages
     * @param authors
     * @param formant
     * @param description
     * @param language
     */
    public Book(String id, String title, String isbn, String publisher, String year, int numOfPages,
            ArrayList<PersonNameImpl> authors, BookFormat format, String description, String language) {
        this.id = StringUtils.emptyStringIfNull(id);
        this.title = StringUtils.emptyStringIfNull(title);
        this.isbn = StringUtils.emptyStringIfNull(isbn);
        this.publisher = StringUtils.emptyStringIfNull(publisher);
        this.year = StringUtils.emptyStringIfNull(year);
        this.numOfPages = numOfPages;
        if (authors != null) {
            this.authors = new ArrayList<PersonNameImpl>(authors);
        } else {
            this.authors = new ArrayList<PersonNameImpl>();
        }
        this.format = format;
        this.description = StringUtils.emptyStringIfNull(description);
        this.language = StringUtils.emptyStringIfNull(language);
    }

    public String getIsbn() {
        return this.isbn;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getYear() {
        return this.year;
    }

    public int getNumOfPages() {
        return this.numOfPages;
    }

    public String getAuthorsNames() {
        String result = "";
        for (int i = 0; i < this.authors.size(); i = i + 1) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + this.authors.get(i).getFullName();
        }
        return result;

    }

    public List<PersonNameImpl> getAuthors() {
        return Collections.unmodifiableList(this.authors);
    }

    public BookFormat getFormat() {
        return this.format;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getTitle() {
        return this.title;
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
        return "BOOK";
    }

}
