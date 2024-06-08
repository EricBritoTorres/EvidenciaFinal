class Pacientes {
    private int idPaciente;
    private String nombrePaciente;

    public Pacientes() {}

    public Pacientes(int idPaciente, String nombrePaciente) {
        this.idPaciente = idPaciente;
        this.nombrePaciente = nombrePaciente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    @Override
    public String toString() {
        return "Pacientes{" +
                "idPaciente=" + idPaciente +
                ", nombrePaciente='" + nombrePaciente + '\'' +
                '}';
    }
}