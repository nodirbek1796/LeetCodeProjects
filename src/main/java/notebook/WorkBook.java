package notebook;

import java.io.IOException;

public class WorkBook {
    public static void main(String[] args) throws IOException {
        Employee employee = new Employee("John Smith", "+998932259747");
        Employee employee1 = new Employee("Ross Geller", "+998946594488");

        System.out.println(employee);
    }
}
