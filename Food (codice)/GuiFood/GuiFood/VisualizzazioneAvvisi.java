package GuiFood;


import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import Classi.Controller;
import java.awt.Color;
import javax.swing.JList;


import java.awt.Rectangle;
import java.util.List;


public class VisualizzazioneAvvisi extends JDialog {
    private static final long serialVersionUID = 1L;

    private Controller ctrl;      
    private DefaultListModel<String> defaultListModel;

    public VisualizzazioneAvvisi(Controller ctrl) {
        this.ctrl = ctrl;
        defaultListModel = new DefaultListModel<>();

        setBounds(new Rectangle(0, 13, 0, 0));
        setResizable(false);
        setForeground(new Color(255, 165, 0));
        setBackground(new Color(255, 165, 0));
        setBounds(100, 100, 329, 219);

        JList<String> listaErrori = new JList<>(defaultListModel);
        listaErrori.setBackground(Color.ORANGE);
        add(new JScrollPane(listaErrori));

        pack();
    }

    public void setMessaggiErrore(List<String> messaggiErrore) {
        defaultListModel.clear();

        for (String messaggioErrore : messaggiErrore) {
            defaultListModel.addElement(messaggioErrore);
        }
    }
}