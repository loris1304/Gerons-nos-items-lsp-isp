package ch.epai.ict.m226.gerons_nos_items_lsp_isp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Documentary implements LibraryItem {

    private String id;
    private String title;
    private ArrayList<PersonName> directors;
    private ArrayList<PersonName> writers;
    private LocalDate launchDate;
    private String description;
    private String language;

    public Documentary(String id, String title, ArrayList<PersonName> directors, ArrayList<PersonName> writers,
            LocalDate launchDate, String description, String language) {
        this.id = StringUtils.emptyStringIfNull(id);
        this.title = StringUtils.emptyStringIfNull(title);
        this.directors = new ArrayList<>();
        if (directors != null) {
            this.directors = directors;
        }
        
        this.writers = new ArrayList<>();
        if (writers != null) {
            this.writers = writers;
        }
        this.launchDate = launchDate;
        this.description = StringUtils.emptyStringIfNull(description);
        this.language = StringUtils.emptyStringIfNull(language);
    }

    public String getDirectorsNames() {
        String data = "";
        for (int i = 0; i < directors.size(); i += 1) {
            data += directors.get(i).getFullName();

            if (i < directors.size() - 1) {
                data = data + ", ";
            }
        }

        return data;
    }

    public String getWritersNames() {
        String data = "";
        for (int i = 0; i < writers.size(); i += 1) {
            data += writers.get(i).getFullName();

            if (i < writers.size() - 1) {
                data = data + ", ";
            }
        }

        return data;
    }

    public List<PersonName> getDirectors() {
        return Collections.unmodifiableList(this.directors);
    }

    public List<PersonName> getWriters() {
        return Collections.unmodifiableList(this.writers);
    }

    public String getLaunchDate() {
        if (launchDate != null) {
            return launchDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        }
        return "";
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
        return "DOCUMENTARY";
    }
}