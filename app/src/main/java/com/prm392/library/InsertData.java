package com.prm392.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.prm392.library.entities.Customer;
import com.prm392.library.entities.Employee;
import com.prm392.library.entities.MasterData;
import com.prm392.library.repository.CustomerRepository;
import com.prm392.library.repository.EmployeeRepository;
import com.prm392.library.repository.MasterDataRepository;
import com.prm392.library.validation.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsertData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        try {
            MasterDataRepository masterDataRepository = new MasterDataRepository(this);

            EmployeeRepository employeeRepository = new EmployeeRepository(this);
            CustomerRepository customerRepository = new CustomerRepository(this);

            TextView tv = findViewById(androidx.core.R.id.text);

            Button btn = findViewById(R.id.add);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MasterData[] sampleData = new MasterData[]{
                            new MasterData(null, "ROLE", "EMPLOYEE_A", 1L, "", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "ROLE", "EMPLOYEE_B", 2L, "Who is the lowest level employee and is limited in some actions.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "ROLE", "MANAGER", 3L, "Who manage all staff and have highest authorization.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "BOOK_TYPE", "Novel", 1L, "Including fictional works with developed stories and characters, often divided into genres such as romance novels, science fiction novels, detective novels, historical novels, etc.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "CUSTOMER_STATUS", "Active", 1L, "Allowed to act.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "BOOK_STATUS", "In process", 1L, "The book return date is not overdue.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "BOOK_TYPE", "Science", 2L, "Including works on natural and social sciences, including books on physics, chemistry, biology, psychology, sociology, etc.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "BOOK_TYPE", "Instructional and self-help", 3L, "Including books on skills such as cooking, gardening, repairs, computer programming, etc.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "BOOK_TYPE", "Arts and culture", 4L, "Including books on art, music, film, culture, architecture, etc.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "BOOK_TYPE", "History", 5L, "Including works on world history, national history, and important historical events.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "BOOK_TYPE", "Autobiographies and memoirs", 6L, "Including works where the author recounts their life story or part of their life.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "BOOK_TYPE", "Business and finance", 7L, "Including works on business, management, investment, and personal finance.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "BOOK_TYPE", "Religious and spiritual", 8L, "Including works on various religions, philosophy, and the art of living.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "BOOK_TYPE", "Science fiction and fantasy", 9L, "Including works of fiction with elements of science fiction or magic.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "BOOK_TYPE", "Poetry", 10L, "Including collections of poems, often exploring themes of emotion, nature, and the human experience.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "BOOK_TYPE", "Mystery and thriller", 11L, "Including suspenseful stories often involving crime, detectives, and plot twists.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "BOOK_TYPE", "Travel", 12L, "Including guides, memoirs, and narratives about travel experiences and destinations around the world.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "CUSTOMER_STATUS", "Blocked", 2L, "Not allowed to act.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "BOOK_STATUS", "Done", 2L, "The book has been returned.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "BOOK_STATUS", "Out of date", 3L, "The deadline has passed but the book has not been returned.", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "BOOK_STATUS", "Blocked", 4L, "Books are damaged or recalled", new Date(), 1L, null, null, null, null),
                            new MasterData(null, "BOOK_STATUS", "Active", 5L, "", new Date(), 1L, null, null, null, null)
                    };

                    for (int i = 0; i < sampleData.length; i++) {
                        masterDataRepository.addMasterData(sampleData[i]);
                        Log.d("InsertData", "MasterData " + i + " added successfully");
                    }
                   // tv.setText(masterDataRepository.getAll().toString());
                    List<Employee> list = initEmployees();
                    for (int i = 0; i < list.size(); i++) {
                        employeeRepository.addEmployee(list.get(i));
                    }
                    List<Customer> listC = createCustomers();
                    for (int i = 0; i < listC.size(); i++) {
                        customerRepository.addEmployee(listC.get(i));
                    }
               tv.setText(customerRepository.getAll().toString());
                }
            });
        } catch (Exception e) {
            Log.e("InsertData", "Error adding MasterData ");
        }
    }
    public static List<Employee> initEmployees() {
        List<Employee> employees = new ArrayList<>();

        // Khởi tạo các nhân viên với thông tin cụ thể
        employees.add(new Employee("Nguyễn Tuấn Thành", "tuanthanh123", new Date(), 1L, "Hai Phong", "123456789", "killpenta2804@gmail.com", Utils.MANAGER, new Date(),null, null, null, null, null, "asserts/images/thanhnt.jpg"));
        employees.add(new Employee("Hà Quốc Việt", "haquocviet", new Date(), 2L, "Tuyen Quang", "0868046261", "haquocviet261@gmail.com", Utils.EMPLOYEE_A, new Date(), 1L,null, null, null, null, "asserts/images/viethq.jpg"));
        employees.add(new Employee("Tạ Việt Đức", "tavietduc", new Date(), 3L, "Tuyen Quang", "456123789", "ductaviet11@gmail.com", Utils.EMPLOYEE_B, new Date(), 1L,null,null, null, null, "asserts/images/ductv.jpg"));
        employees.add(new Employee("Trương Quốc Bảo", "truongquocbao", new Date(), 4L, "Ha Noi", "789456123", "baotq245@example.com", Utils.EMPLOYEE_A, new Date(),1L, null,null, null, null, "asserts/images/baotq.png"));
        employees.add(new Employee("Trần Đình Tuấn", "trandinhtuan", new Date(), 5L, "Ha Noi", "654987321", "tuantd101@gmail.com", Utils.EMPLOYEE_B, new Date(),1L, null, null, null, null, "asserts/images/tuantd.png"));

        return employees;
    }
    public static List<Customer> createCustomers() {
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer(null, "John Doe", new Date(), 1L, "123 Main St", "123456789", "manh3btq@gmail.com", 1L, new Date(), Utils.EMPLOYEE_A, null, null, null, null));
        customers.add(new Customer(null, "Jane Smith", new Date(), 2L, "456 Elm St", "987654321", "baotq245@gmail.com", 1L, new Date(), Utils.EMPLOYEE_B, null, null, null, null));
        customers.add(new Customer(null, "Alice Johnson", new Date(), 3L, "789 Oak St", "654321987", "alice@example.com", 1L, new Date(), Utils.EMPLOYEE_A, null, null, null, null));
        customers.add(new Customer(null, "Bob Brown", new Date(), 4L, "101 Pine St", "456789123", "bob@example.com", 1L, new Date(), Utils.EMPLOYEE_B, null, null, null, null));
        customers.add(new Customer(null, "Mary Taylor", new Date(), 5L, "202 Maple St", "987123654", "mary@example.com", 1L, new Date(), Utils.EMPLOYEE_B, null, null, null, null));

        return customers;
    }

}
