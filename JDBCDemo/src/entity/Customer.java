package entity;

public class Customer {
  private String name;
  private String address;
  private String contactName;
  public Customer(String name, String address, String contactName) {
    this.name = name;
    this.address = address;
    this.contactName = contactName;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getContactName() {
    return contactName;
  }
  public void setContactName(String contactName) {
    this.contactName = contactName;
  }
  @Override
  public String toString() {
    return "Customer [name=" + name + ", address=" + address + ", contactName=" + contactName + "]";
  }

}
