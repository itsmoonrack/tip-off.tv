package tv.tipoff.api.servlet;


import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;


public final class PMF {
	private static final PersistenceManagerFactory sPMFInstance = JDOHelper
	.getPersistenceManagerFactory("transactions-optional");
	private static PersistenceManager sPMInstance;

	private PMF() {
	}

	public static PersistenceManager getPersistenceManager() {
		sPMInstance = sPMFInstance.getPersistenceManager();
		sPMInstance.addInstanceLifecycleListener(new PersistHookListener(), PersistHooks.class);
		return sPMInstance;
	}
}