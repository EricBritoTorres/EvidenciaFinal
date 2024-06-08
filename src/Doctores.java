class Doctores {
    private int idDoctor;
    private String nombreDoctor;
    private String especialidad;

    public Doctores() {}

    public Doctores(int idDoctor, String nombreDoctor, String especialidad) {
        this.idDoctor = idDoctor;
        this.nombreDoctor = nombreDoctor;
        this.especialidad = especialidad;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Doctores{" +
                "idDoctor=" + idDoctor +
                ", nombreDoctor='" + nombreDoctor + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}