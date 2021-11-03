package st_addressbook.model;

public record ContactData(String firstName, String lastName, String nickName, String company, String address,
                          String homePhone, String mobilePhone, String group) {
}
