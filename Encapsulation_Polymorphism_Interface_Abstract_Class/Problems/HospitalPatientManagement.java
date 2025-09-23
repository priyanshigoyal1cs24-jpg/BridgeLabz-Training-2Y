import java.util.ArrayList;
import java.util.List;

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;

    public Patient(String patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    protected String getDiagnosis() {
        return diagnosis;
    }

    protected void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosis: " + diagnosis);
    }
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private List<String> records;

    public InPatient(String patientId, String name, int age, String diagnosis, int daysAdmitted, double dailyRate) {
        super(patientId, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return records;
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records;

    public OutPatient(String patientId, String name, int age, String diagnosis, double consultationFee) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return records;
    }
}

public class HospitalPatientManagement {
    public static void processPatient(Patient patient) {
        patient.getPatientDetails();
        System.out.println("Total Bill: $" + patient.calculateBill());

        if (patient instanceof MedicalRecord) {
            MedicalRecord record = (MedicalRecord) patient;
            System.out.println("Medical Records:");
            for (String rec : record.viewRecords()) {
                System.out.println("- " + rec);
            }
        }

        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        InPatient p1 = new InPatient("P1001", "Alice", 45, "Surgery", 5, 1200);
        p1.addRecord("Surgery successful.");
        p1.addRecord("Discharged on day 6.");

        OutPatient p2 = new OutPatient("P2002", "Bob", 30, "Fever", 300);
        p2.addRecord("Prescribed antibiotics.");
        p2.addRecord("Follow-up in 5 days.");

        Patient[] patients = { p1, p2 };

        for (Patient p : patients) {
            processPatient(p);
        }
    }
}
