import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class kullaniciAdiGirisPanel extends JFrame {

    public kullaniciAdiGirisPanel() {
        setTitle("Kullanıcı Adı Bulma Arayüzü");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel label = new JLabel("Kullanıcı Adı:");
        JTextField textField = new JTextField(20);
        JButton bulButton = new JButton("Bul");

        bulButton.addActionListener(new ActionListener() {




            @Override
            public void actionPerformed(ActionEvent e) {
                String kullaniciAdi = textField.getText();

  Users user = null;

  for (Users a:Main.kullanicilarArrayList.getKullanicilar()){

      if (kullaniciAdi.equals(a.getKullaniciAdi())){
          user = a;
          break;
      }



  }

  if(user == null){

      JOptionPane.showMessageDialog(null, "Kullanıcı adı geçerli değil!", "Uyarı", JOptionPane.WARNING_MESSAGE);


  }else{
      NewJFrame SS = new NewJFrame();
      SS.UsersEkle(user);
      SS.setVisible(true);



  }

            }
        });



        panel.add(label);
        panel.add(textField);
        panel.add(bulButton);

        add(panel, BorderLayout.CENTER);

        // Ekranı tam ortada konumlandırma
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            kullaniciAdiGirisPanel arayuz = new kullaniciAdiGirisPanel();
            arayuz.setVisible(true);
        });
    }
}