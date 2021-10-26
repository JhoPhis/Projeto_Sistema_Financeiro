package com.sistema.financeiro.sisfin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long Id;

    @Column(name="nome", nullable = false, length = 256)
    @JsonProperty(value="nome")
    String Nome;

    @Column(name="criado")
	@JsonProperty(value = "criado", access = JsonProperty.Access.READ_ONLY)
	@CreationTimestamp
	Date Criado;
	
	@Column(name="atualizado")
	@JsonProperty(value = "atualizado", access = JsonProperty.Access.READ_ONLY)
	@UpdateTimestamp
	Date Atualizado;
}
