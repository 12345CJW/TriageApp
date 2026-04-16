import java.util.Comparator;

public class TriageComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        // First: lower priority number = more urgent
        if (p1.getPriority() != p2.getPriority()) {
            return Integer.compare(p1.getPriority(), p2.getPriority());
        }

        // Second: older age first
        if (p1.getAge() != p2.getAge()) {
            return Integer.compare(p2.getAge(), p1.getAge());
        }

        // Third: earlier arrival first
        return Integer.compare(p1.getArrivalOrder(), p2.getArrivalOrder());
    }
}