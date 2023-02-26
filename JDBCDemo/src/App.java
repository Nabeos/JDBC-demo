import example.PreparedStatementExample;

public class App {
    public static void main(String[] args) throws Exception {
        PreparedStatementExample dao = new PreparedStatementExample();
        // System.out.println(dao.addNewCustomer("duy anh vu", "ha noi", "anh vu1"));

        dao.getCustomers().forEach(o->System.out.println(o.toString()));

    }
}
