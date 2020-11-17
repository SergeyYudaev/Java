package GeekBrainHW5;

public class employee {
    String name;
    String position;
    String email;
    String phone;
    int salary;
    int age;

    public employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void print() {
        System.out.println("Имя: " + name + ", Должность: " + position + ", e-mail: " + email + ", Телефон: " + phone + ", Зарплата: " + salary + ", Возраст: " + age + ".");
    }



    public static void main(String[] args) {
        employee[] staff = new employee[5];
        staff[0] = new employee("Ivanov Ivan", "slave", "slave@gmail.com", "88005553535", 0, 45);
        staff[1] = new employee("mr. President", "nekromant", "evil@gmail.com", "88002000002", 9999999, 600);
        staff[2] = new employee("Zalimhan Usinbaev", "security officer", "so@gmail.com", "88002000002", 10000, 16);
        staff[3] = new employee("Devochka Masha", "devochka", "devochka@gmail.com", "88002000002", 15000, 8);
        staff[4] = new employee("Sergey Yudaev", "dreamer", "SY@gmail.com", "88002000002", 11000, 24);
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].age > 40) staff[i].print();
        }
    }


}
