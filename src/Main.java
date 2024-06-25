import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private LocalDate dateOfBirth;

    public Person(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}

class Employee extends Person {
    private BigDecimal salary;
    private String role;

    public Employee(String name, LocalDate dateOfBirth, BigDecimal salary, String role) {
        super(name, dateOfBirth);
        this.salary = salary;
        this.role = role;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Nome: " + getName() + 
               ", Data de Aniversário: " + getDateOfBirth().format(formatter) +
               ", Salário: " + String.format("%,.2f", salary).replace('.', ',') +
               ", Função: " + role;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
            new Employee("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
            new Employee("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
            new Employee("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
            new Employee("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
            new Employee("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
            new Employee("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
            new Employee("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
            new Employee("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
            new Employee("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
        ));

        employees.removeIf(employee -> employee.getName().equals("João"));

        System.out.println("Todos Funcionários:");
        employees.forEach(System.out::println);
        
        employees.forEach(employee -> employee.setSalary(employee.getSalary().multiply(new BigDecimal("1.10"))));

        Map<String, List<Employee>> employeesByRole = employees.stream().collect(Collectors.groupingBy(Employee::getRole));
        
        System.out.println("\nFuncionários agrupados por função:");
        employeesByRole.forEach((role, empList) -> {
            System.out.println(role + ":");
            empList.forEach(System.out::println);
        });

        System.out.println("\nFuncionários aniversariantes em outubro e dezembro");
        employees.stream()
                 .filter(employee -> employee.getDateOfBirth().getMonthValue() == 10 || employee.getDateOfBirth().getMonthValue() == 12)
                 .forEach(System.out::println);

        Employee oldestEmployee = employees.stream()
                                           .min(Comparator.comparing(Employee::getDateOfBirth))
                                           .orElse(null);
        if (oldestEmployee != null) {
            long age = ChronoUnit.YEARS.between(oldestEmployee.getDateOfBirth(), LocalDate.now());
            System.out.println("\nFuncionário mais antigo:");
            System.out.println("Nome: " + oldestEmployee.getName() + ", Idade: " + age);
        }

        System.out.println("\nFuncionários em ordem alfabética:");
        employees.stream()
                 .sorted(Comparator.comparing(Employee::getName))
                 .forEach(System.out::println);

        BigDecimal totalSalaries = employees.stream()
                                            .map(Employee::getSalary)
                                            .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal de Salários: " + String.format("%,.2f", totalSalaries).replace('.', ','));

        BigDecimal minimumWage = new BigDecimal("1212.00");
        System.out.println("\nSalários dos funcionários em salários mínimos:");
        employees.forEach(employee -> {
            @SuppressWarnings("deprecation")
            BigDecimal salaryInMinimumWages = employee.getSalary().divide(minimumWage, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(employee.getName() + ": " + String.format("%,.2f", salaryInMinimumWages).replace('.', ',') + " salário mínimo");
        });
    }
}
