package Training;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
public class desktop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		





    try {
      URI uri = new URI("http://www.java2s.com");
      Desktop desktop = null;
      if (Desktop.isDesktopSupported()) {
        desktop = Desktop.getDesktop();
      }

      if (desktop != null)
        desktop.browse(uri);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    } catch (URISyntaxException use) {
      use.printStackTrace();
    }

  }

		
		
		

	}


