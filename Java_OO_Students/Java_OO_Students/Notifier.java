import java.util.Iterator;
import java.util.Set;


public class Notifier {
	Set<? extends Notifiable> notifiables;
	
	public Notifier (Set<? extends Notifiable> n) {
		this.notifiables = Set.copyOf(n);
	}
	
	public void doNotifyAll(String message) {

		Iterator<? extends Notifiable> i = notifiables.iterator();
		while (i.hasNext()) {
			Notifiable next = i.next();
			next.notify(message);
		}
		
	}
}
