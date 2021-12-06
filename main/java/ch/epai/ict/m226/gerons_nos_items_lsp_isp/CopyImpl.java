package ch.epai.ict.m226.gerons_nos_items_lsp_isp;

public class CopyImpl implements Copy {
    
    private String id;
    private String location;
    private LibraryItem item;

    public CopyImpl(String id, String location, LibraryItem item){
        this.id = StringUtils.emptyStringIfNull(id);
        this.location = StringUtils.emptyStringIfNull(location);
        this.item = item;

    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getLocation() {
        return this.location;
    }

    @Override
    public LibraryItem getItem() {
        return this.item;
    }
}
