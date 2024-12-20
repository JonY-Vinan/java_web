package org.com.restaurante.entidades;

import java.time.LocalDate;

import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	@Size(min = 2, max = 50)
	private String nombre;

	@NotNull
	@NotBlank
	@Size(min = 2, max = 50)
	private String apellido;

	@NotNull
	@NotBlank
	@Size(max = 100)
	private String email;

	@NotNull
	@NotBlank
	@Size(min = 0, max = 9)
	private int telefono;
	
	@NotNull
	@NotBlank
	@FutureOrPresent
	private LocalDate fecha = LocalDate.now();
	
	@NotNull
	@NotBlank
	private String hora;
	
	@NotNull
	@NotBlank
	@Min(1)
	private int numeroPersonas;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	
	

}
