
## Earthquake Triage System

# Overview
The Earthquake Triage System is a Java command-line application that simulates how a field hospital prioritizes patients after a major earthquake.
In disaster situations, patients are not treated in the order they arrive. Instead, they are treated based on the severity of their condition. This program models that behavior using a Priority Queue.

# Features
➕ Add patients with name, age, injury, and priority
📋 Display patients in correct triage order
🏥 Treat (remove) the highest-priority patient
🔄 Update a patient’s condition and priority
📊 Automatically sort patients by:
    Priority level
    Age (older patients first if same priority)
    Arrival order
    🧠 Triage Rules

# Patients are assigned priority levels:
Priority 1 (Immediate)
Life-threatening conditions (severe bleeding, breathing problems, shock)
Priority 2 (Urgent)
Serious but stable (broken bones, moderate injuries)
Priority 3 (Delayed)
Minor injuries (cuts, bruises)
Priority 4 (Minimal / Lowest)
Least urgent cases


# Project Structure
EarthquakeTriageSystem/
'''
Patient.java              # Stores patient data
TriageComparator.java    # Defines sorting rules
TriageSystem.java        # Handles logic and queue
EarthquakeTriageSystem.java  # Main program (CLI)
'''

# Class Roles
Patient → Stores patient information
TriageComparator → Determines patient order
TriageSystem → Manages PriorityQueue logic
EarthquakeTriageSystem → Handles user interaction

# How to Run
1. Compile the program
javac Patient.java TriageComparator.java TriageSystem.java EarthquakeTriageSystem.java
2. Run the program
java EarthquakeTriageSystem
