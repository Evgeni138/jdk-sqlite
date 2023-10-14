package hw_3;
//Создайте интерфейс, который определяет набор методов для работы с базой данных (например, сохранение, удаление,
//получение данных). Реализуйте этот интерфейс в конкретном классе.
import javax.xml.transform.Result;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;
        User user = new User();

        user.addData(2, "Tanya", "+79093214433");
        System.out.println();
        user.getData(2);
        System.out.println();
        user.getAll();
        user.deleteData(2);
        System.out.println();

        Task task = new Task();
        task.deleteData(1);
        task.addData(1, "Task1", 1);
        System.out.println();
        task.getData(1);
        System.out.println();

        user.getAll();
    }
}
