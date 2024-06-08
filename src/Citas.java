class Citas {
    private String fechaCita;
    private int idPaciente;
    private int idDoctor;
    private String especialidad;

    public Citas() {}

    public Citas(String fechaCita, int idPaciente, int idDoctor, String especialidad) {
        this.fechaCita = fechaCita;
        this.idPaciente = idPaciente;
        this.idDoctor = idDoctor;
        this.especialidad = especialidad;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Citas{" +
                "fechaCita='" + fechaCita + '\'' +
                ", idPaciente=" + idPaciente +
                ", idDoctor=" + idDoctor +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}