import com.mojafirma.gui.MenuPanel;
import com.mojafirma.gui.TicketReservationPanel;

public class Main {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater (new Runnable() {
            public void run() {
                MenuPanel menuPanel = new MenuPanel();
                menuPanel.setVisible(true);
            }
        });
    }
}
