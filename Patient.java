public class Patient {
    private String name;
    private int age;
    private String complaint;
    private int priority;
    private int arrivalOrder;

    public Patient(String name, int age, String complaint, int priority, int arrivalOrder) {
        this.name = name;
        this.age = age;
        this.complaint = complaint;
        this.priority = priority;
        this.arrivalOrder = arrivalOrder;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getComplaint() {
        return complaint;
    }

    public int getPriority() {
        return priority;
    }

    public int getArrivalOrder() {
        return arrivalOrder;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                " | Age: " + age +
                " | Complaint: " + complaint +
                " | Priority: " + priority +
                " | Arrival Order: " + arrivalOrder;
    }
}