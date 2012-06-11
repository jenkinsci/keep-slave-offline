package hudson.plugins.keepSlaveOffline;

import java.io.IOException;
import java.util.logging.Logger;

import hudson.Extension;
import hudson.model.Computer;
import hudson.model.Hudson;
import hudson.model.TaskListener;
import hudson.slaves.ComputerListener;
import hudson.slaves.OfflineCause;

@Extension
public class KeepOfflineListener extends ComputerListener{
	
	@Override
	public void onOnline(Computer c, TaskListener listener) throws IOException, InterruptedException {
                OfflineKeeper keeper = c.getNode().getNodeProperties().get(OfflineKeeper.class);
		if(keeper != null){
			LOGGER.info("This node (" + c.getNode().getDisplayName() + ") will be kept offline, slave is configured to be kept offline even after restart.");
                        c.setTemporarilyOffline(true,OfflineCause.SimpleOfflineCause.create(Messages._Node_Kept_Offline(keeper.getReason())));
		}
    }

	private static final Logger LOGGER = Logger.getLogger(Hudson.class.getName());
}
