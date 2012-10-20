package tv.tipoff.infrastructure;

import javax.jdo.listener.InstanceLifecycleEvent;
import javax.jdo.listener.StoreLifecycleListener;

public class PersistHookListener implements StoreLifecycleListener {

	@Override
	public void postStore(InstanceLifecycleEvent ev) {
	}

	@Override
	public void preStore(InstanceLifecycleEvent ev) {
		((PersistHooks)ev.getPersistentInstance()).beforeSave();
	}

}
