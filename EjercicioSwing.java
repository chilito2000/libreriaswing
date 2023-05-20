
package ejercicio.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EjercicioSwing {


        

public class GuiEjemplo {
    private JFrame frame;
    private JLabel labelName;
    private JTextField textFieldName;
    private JLabel labelAge;
    private JTextField textFieldAge;
    private JLabel labelGender;
    private JComboBox<String> comboBoxGender;
    private JButton buttonSubmit;
    private ArrayList<JFrame> dataFrames;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GuiEjemplo swing   = new GuiEjemplo();
            swing.createGUI();
        });
    }

    private void createGUI() {
        // Crear una nueva ventana
        frame = new JFrame("Datos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2));

        // Crear componentes
        labelName = new JLabel("Nombre:");
        textFieldName = new JTextField(20);
        labelAge = new JLabel("Edad:");
        textFieldAge = new JTextField(3);
        labelGender = new JLabel("Género:");
        comboBoxGender = new JComboBox<>(new String[]{"Masculino", "Femenino", "Otro"});
        buttonSubmit = new JButton("Enviar");
        dataFrames = new ArrayList<>();

        // Agregar acción al botón de enviar
        buttonSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText();
                int age = Integer.parseInt(textFieldAge.getText());
                String gender = (String) comboBoxGender.getSelectedItem();

                showData(name, age, gender);
                clearFields();
            }
        });

        // Agregar componentes a la ventana
        frame.add(labelName);
        frame.add(textFieldName);
        frame.add(labelAge);
        frame.add(textFieldAge);
        frame.add(labelGender);
        frame.add(comboBoxGender);
        frame.add(buttonSubmit);

        // Ajustar el tamaño de la ventana y hacerla visible
        frame.pack();
        frame.setVisible(true);
    }

    private void showData(String name, int age, String gender) {
        // Crear una nueva ventana para mostrar los datos ingresados
        JFrame dataFrame = new JFrame("Reporte de Datos");
        dataFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dataFrame.setLayout(new GridLayout(3, 2));
        dataFrame.setSize(150, 100);

        // Crear componentes para mostrar los datos
        JLabel nameLabel = new JLabel("Nombre:");
        JLabel ageLabel = new JLabel("Edad:");
        JLabel genderLabel = new JLabel("Género:");
        JLabel nameValueLabel = new JLabel(name);
        JLabel ageValueLabel = new JLabel(Integer.toString(age));
        JLabel genderValueLabel = new JLabel(gender);

        // Agregar componentes a la ventana
        dataFrame.add(nameLabel);
        dataFrame.add(nameValueLabel);
        dataFrame.add(ageLabel);
        dataFrame.add(ageValueLabel);
        dataFrame.add(genderLabel);
        dataFrame.add(genderValueLabel);

        // Ajustar el tamaño de la ventana automáticamente
        dataFrames.add(dataFrame);

        // Hacer visible la ventana
        dataFrame.setVisible(true);
    }

    private void clearFields() {
        textFieldName.setText("");
        textFieldAge.setText("");
        comboBoxGender.setSelectedIndex(0);
    }
}
    }
    
}
