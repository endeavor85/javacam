package endeavor85;

import java.awt.Toolkit;
import java.util.Iterator;
import java.util.Vector;

import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.MediaLocator;
import javax.media.format.VideoFormat;
import javax.swing.JFrame;

public class JavaCamFrame extends JFrame
{
	private static final long	serialVersionUID	= 1L;

	private static String		device				= "vfw:Microsoft WDM Image Capture (Win32):0";

	public static void main(String args[])
	{
		new JavaCamFrame();
	}

	public JavaCamFrame()
	{
		super("JavaCam");

		setSize(400, 300);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Vector<CaptureDeviceInfo> deviceList = CaptureDeviceManager.getDeviceList(new VideoFormat(VideoFormat.RGB));

		Iterator<CaptureDeviceInfo> iter = deviceList.iterator();
		while(iter.hasNext())
		{
			CaptureDeviceInfo deviceInfo = iter.next();
			System.out.println(deviceInfo.getName());
		}

		MediaLocator mediaLocator = CaptureDeviceManager.getDevice(device).getLocator();

		setContentPane(new PlayerPanel(mediaLocator));
		setVisible(true);
	}
}
