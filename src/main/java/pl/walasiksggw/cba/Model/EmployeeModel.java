package pl.walasiksggw.cba.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "employee")
@Table
@Component
public class EmployeeModel {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String name;
        private String surname;
        private String position;
        private double salary;
        private double salaryPerHour;
        private int numberOfHoursPerMonth;
        private int overtime;


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public int getNumberOfHoursPerMonth() {
            return numberOfHoursPerMonth;
        }

        public void setNumberOfHoursPerMonth(int numberOfHoursPerMonth) {
            this.numberOfHoursPerMonth = numberOfHoursPerMonth;
        }
        public double getSalaryPerHour() {
            return salaryPerHour;
        }

        public void setSalaryPerHour(double salaryPerHour) {
            this.salaryPerHour = salaryPerHour;
        }

        public int getOvertime() {
            return overtime;
        }

        public void setOvertime(int overtime) {
            this.overtime = overtime;
        }

        @Override
        public String toString() {
            return "EmployeeModelImpl{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", position='" + position + '\'' +
                    ", salary=" + salary +
                    ", salaryPerHour=" + salaryPerHour +
                    ", numberOfHoursPerMonth=" + numberOfHoursPerMonth +
                    ", overtime=" + overtime +
                    '}';
        }
}
