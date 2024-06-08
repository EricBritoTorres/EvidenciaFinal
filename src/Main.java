

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static String username = "admin";
    static String password = "admin";
    static int opcion;

    static HashMap<String, Doctores> doctores = new HashMap<>();
    static HashMap<String, Pacientes> pacientes = new HashMap<>();
    static HashMap<String, Citas> citas = new HashMap<>();
    private static final String FILE_NAME = "database.txt";

    public static void main(String[] args) {
        loadDatabase();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menuPrincipal();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Authenticate();
                    break;
                case 2:
                    crearMedico();
                    break;
                case 3:
                    nuevoPaciente();
                    break;
                case 4:
                    nuevaCita();
                    break;
                case 5:
                    verCitas();
                    break;
                case 6:
                    saveDatabase();
                    System.exit(0);
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }

    public static void menuPrincipal() {
        System.out.println("1. Iniciar sesion");
        System.out.println("2. Crear Medico");
        System.out.println("3. Crear Paciente");
        System.out.println("4. Crear Cita");
        System.out.println("5. Ver Citas");
        System.out.println("6. Salir");
    }

    public static void Authenticate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa tu usuario");
        String inputUsername = scanner.nextLine();
        System.out.println("Ingresa tu contraseña");
        String inputPassword = scanner.nextLine();
        if (username.equals(inputUsername) && password.equals(inputPassword)) {
            System.out.println("Login exitoso");
        } else {
            System.out.println("Credenciales incorrectas");
        }
    }

    public static void crearMedico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nombre del medico");
        String nombreMedico = scanner.nextLine();
        System.out.println("Ingresa la especialidad");
        String especialidad = scanner.nextLine();
        System.out.println("Ingresa el id del medico");
        int idMedico = scanner.nextInt();
        scanner.nextLine();
        Doctores medico = new Doctores(idMedico, nombreMedico, especialidad);
        doctores.put(medico.getNombreDoctor(), medico);
        System.out.println("Medico creado exitosamente");
        saveDatabase();
    }

    public static void nuevoPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nombre del paciente");
        String nombrePaciente = scanner.nextLine();
        System.out.println("Ingresa el id del paciente");
        int idPaciente = scanner.nextInt();
        scanner.nextLine();
        Pacientes paciente = new Pacientes(idPaciente, nombrePaciente);
        pacientes.put(paciente.getNombrePaciente(), paciente);
        System.out.println("Paciente creado exitosamente");
        saveDatabase();
    }

    public static void nuevaCita() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la fecha de la cita");
        String fechaCita = scanner.nextLine();
        System.out.println("Ingresa el id del paciente");
        int idPaciente = scanner.nextInt();
        System.out.println("Ingresa el id del medico");
        int idDoctor = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.println("Ingresa la especialidad");
        String especialidad = scanner.nextLine();
        Citas cita = new Citas(fechaCita, idPaciente, idDoctor, especialidad);
        citas.put(cita.getFechaCita(), cita);
        System.out.println("Cita creada exitosamente");
        saveDatabase();
    }

    public static void verCitas() {
        for (Map.Entry<String, Citas> entry : citas.entrySet()) {
            System.out.println("Fecha: " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void loadDatabase() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    switch (parts[0]) {
                        case "DOCTOR":
                            Doctores doctor = new Doctores(Integer.parseInt(parts[1]), parts[2], parts[3]);
                            doctores.put(doctor.getNombreDoctor(), doctor);
                            break;
                        case "PACIENTE":
                            Pacientes paciente = new Pacientes(Integer.parseInt(parts[1]), parts[2]);
                            pacientes.put(paciente.getNombrePaciente(), paciente);
                            break;
                        case "CITA":
                            Citas cita = new Citas(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4]);
                            citas.put(cita.getFechaCita(), cita);
                            break;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveDatabase() {
        try (PrintWriter writer = new PrintWriter(new File(FILE_NAME))) {
            for (Doctores doctor : doctores.values()) {
                writer.println("DOCTOR," + doctor.getIdDoctor() + "," + doctor.getNombreDoctor() + "," + doctor.getEspecialidad());
            }
            for (Pacientes paciente : pacientes.values()) {
                writer.println("PACIENTE," + paciente.getIdPaciente() + "," + paciente.getNombrePaciente());
            }
            for (Citas cita : citas.values()) {
                writer.println("CITA," + cita.getFechaCita() + "," + cita.getIdPaciente() + "," + cita.getIdDoctor() + "," + cita.getEspecialidad());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}