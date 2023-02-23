import controllers.InterfataController;
import View.View;


import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        View view=new View();
        InterfataController controller=new InterfataController(view);
    }
}
