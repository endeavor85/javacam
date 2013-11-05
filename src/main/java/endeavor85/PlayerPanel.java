package endeavor85;

import java.awt.Component;
import java.io.IOException;

import javax.media.CannotRealizeException;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.RealizeCompleteEvent;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel implements ControllerListener
{
	private static final long	serialVersionUID	= 1L;

	private Component			visualComponent;
	Player						player;

	public PlayerPanel(MediaLocator mediaLocator)
	{
		super();

		try
		{
			player = Manager.createRealizedPlayer(mediaLocator);
			player.addControllerListener(this);
			add(player.getControlPanelComponent());
			add(player.getVisualComponent());
			player.start();
		}
		catch(NoPlayerException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(CannotRealizeException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void controllerUpdate(ControllerEvent c)
	{
		if(player == null)
			return;

		if(c instanceof RealizeCompleteEvent)
		{
			if((visualComponent = player.getVisualComponent()) != null)
				add(visualComponent);
		}
	}
}
