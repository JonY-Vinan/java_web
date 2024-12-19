package com.projecto.java.entidad;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.projecto.java.biblioteca.Util;

public class Reserva {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private int telefono;
    private LocalDate fechaReserva;
    private String hora;
    private int numeroPersonas;
    private EstadoReserva estado;

    private Map<String, String> errores = new HashMap<>();
    
    public Reserva() {
        super();
    }

    public Reserva(Long id, String nombre, String apellido, String email, int telefono, LocalDate fechaReserva,
            String hora, int numeroPersonas, EstadoReserva estado) {
        super();
        setId(id);
        setNombre(nombre);
        setApellido(apellido);
        setEmail(email);
        setTelefono(telefono);
        setFechaReserva(fechaReserva);
        setHora(hora);
        setNumeroPersonas(numeroPersonas);
        setEstado(estado);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {    
            this.id = id;
    }
    
    public void setId(String sId) {
		try {
			setId(sId.isBlank() ? null: Long.parseLong(sId));
		} catch (NumberFormatException e) {
			errores.put("id", "El id debe ser un número");
		}
	}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            errores.put("nombre", "El nombre no puede estar vacío");
        } else {
            this.nombre = nombre;
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.isBlank()) {
            errores.put("apellido", "El apellido no puede estar vacío");
        } else {
            this.apellido = apellido;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isBlank() || !email.contains("@")) {
            errores.put("email", "El email no puede estar vacío y debe ser válido");
        } else {
            this.email = email;
        }
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        if (String.valueOf(telefono).length() != 9) {
            errores.put("telefono", "El teléfono debe tener 9 dígitos");
        } else {
            this.telefono = telefono;
        }
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        if (fechaReserva == null || fechaReserva.isBefore(LocalDate.now())) {
            errores.put("fechaReserva", "La fecha de reserva no puede ser en el pasado");
        } else {
            this.fechaReserva = fechaReserva;
        }
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        if (hora == null || hora.isBlank()) {
            errores.put("hora", "La hora no puede estar vacía");
        } else {
            this.hora = hora;
        }
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        if (numeroPersonas <= 0) {
            errores.put("numeroPersonas", "El número de personas debe ser mayor que 0");
        } else {
            this.numeroPersonas = numeroPersonas;
        }
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        if (estado == null) {
            errores.put("estado", "El estado no puede estar vacío");
        } else {
            this.estado = estado;
        }
    }
    
    public Map<String, String> getErrores() {
		return errores;
	}
	
	public boolean isCorrecto() {
		return errores.size() == 0;
	}

    @Override
    public int hashCode() {
        return Objects.hash(apellido, email, estado, fechaReserva, hora, id, nombre, numeroPersonas, telefono);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reserva other = (Reserva) obj;
        return Objects.equals(apellido, other.apellido) && Objects.equals(email, other.email) && estado == other.estado
                && Objects.equals(fechaReserva, other.fechaReserva) && Objects.equals(hora, other.hora)
                && Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
                && numeroPersonas == other.numeroPersonas && telefono == other.telefono;
    }

    

    @Override
	public String toString() {
		return "Reserva [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", fechaReserva=" + fechaReserva + ", hora=" + hora + ", numeroPersonas="
				+ numeroPersonas + ", estado=" + estado + ", errores=" + errores + "]";
	}

	// Método setDatos
    public void setDatos() {
        nombre = Util.leerCadena("Nombre: ");
        apellido = Util.leerCadena("Apellido: ");
        email = Util.leerCadena("Email: ");
        telefono = Util.leerInt("Telefono: ");
        fechaReserva = Util.leerFecha("Fecha para hacer reserva");
        hora = Util.leerCadena("hora de reserva");
        numeroPersonas = Util.leerInt("Cuantas personas");
        estado = EstadoReserva.PENDIENTE;
    }
}
