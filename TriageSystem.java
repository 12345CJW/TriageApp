import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class TriageSystem {
    private PriorityQueue<Patient> waitingList;
    private int arrivalCounter;

    public TriageSystem() {
        waitingList = new PriorityQueue<>(new TriageComparator());
        arrivalCounter = 1;
    }

    // Add a patient to the waiting list
    public void addPatient(String name, int age, String complaint, int priority) {
        Patient patient = new Patient(name, age, complaint, priority, arrivalCounter);
        arrivalCounter++;
        waitingList.add(patient);
    }

    // Treat and remove the next patient from the waiting list
    public Patient treatAndRemovePatient() {
        return waitingList.poll();
    }

    // Return all patients in sorted order
    public ArrayList<Patient> getAllPatients() {
        ArrayList<Patient> list = new ArrayList<>(waitingList);
        Collections.sort(list, new TriageComparator());
        return list;
    }

    // Update patient information
    public boolean updatePatient(String name, int newAge, String newComplaint, int newPriority) {
        ArrayList<Patient> tempList = new ArrayList<>();
        Patient found = null;

        while (!waitingList.isEmpty()) {
            Patient current = waitingList.poll();
            if (current.getName().equalsIgnoreCase(name) && found == null) {
                found = current;
            } else {
                tempList.add(current);
            }
        }

        waitingList.addAll(tempList);

        if (found == null) {
            return false;
        }

        found.setAge(newAge);
        found.setComplaint(newComplaint);
        found.setPriority(newPriority);
        waitingList.add(found);

        return true;
    }

    public boolean isEmpty() {
        return waitingList.isEmpty();
    }

    public int getWaitingCount() {
        return waitingList.size();
    }
}