package ch.epai.ict.m226.gerons_nos_items_lsp_isp;

public class PersonNameImpl implements PersonName{
    
    private String firstName;
    private String lastName;

    public PersonNameImpl(String lastName, String firstName){
        this.lastName = StringUtils.emptyStringIfNull(lastName);
        this.firstName = StringUtils.emptyStringIfNull(firstName);
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getFullName() {
        String data = "";
        if (this.firstName == "") {
            data = this.lastName;
        } else if (this.lastName == "") {
            data = this.firstName;
        } else {
            data = this.firstName.charAt(0) + ". " + this.lastName;
        }
        return data;
    }
}
