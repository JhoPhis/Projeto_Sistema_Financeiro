package com.sistema.financeiro.sisfin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaFiscal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty(value="id")
    private Long Id;

    @Column(name="nome", nullable = false, length = 256)
    @JsonProperty(value="nome")
    private String Nome;

    @Column(name="descricao", nullable = false, length = 256)
    @JsonProperty(value="descricao")
    private String Descricao;

    @Column(name="data", nullable = false)
    @JsonProperty(value="data")
    @JsonFormat(pattern="yyyy/MM/dd")
    private Date Data;

    @Column(name="valor", nullable = false)
    @JsonProperty(value="valor")
    private Double Valor;

    @Column(name="ehDespesa", nullable = false)
    @JsonProperty(value="ehDespesa")
    private boolean ehDespesa;

    @Column(name="criadoEm")
	@JsonProperty(value = "criadoEm", access = JsonProperty.Access.READ_ONLY)
	@CreationTimestamp
	private Date CriadoEm;

    @Column(name="vencimento", nullable = true)
    @JsonProperty(value="vencimento")
    @JsonFormat(pattern="yyyy/MM/dd")
    private Date Vencimento;
}