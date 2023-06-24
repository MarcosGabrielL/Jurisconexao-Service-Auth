/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jurisconexao.auth.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Vendedor")
public class Vendedor {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    
     private String CNPJ;
     @Column(nullable = false, unique = false, length = 45)
        private String nomefantasia; 
     @Column(nullable = false, unique = false, length = 250)
           private String descricao;   
        private String Cidade;
        private String CEP;
        private String CFOP;
     private String razaosocial;
     @Column(nullable = false, unique = false, length = 45)
    private String rua;
    private String Bairro;
    private String Numero;
    private String Estado;
    private String Uf;
    @Column(nullable = false, unique = false, length = 45)
    private String telefone;
      @Column(nullable = false, unique = true, length = 45)
    private String email;
    private String Certificado;
    private String  NumeroSérie;
    /*
    0 - nenhum
    1 - Free
    2 - Medio
    3 - Top*/
     @Column(nullable = false, unique = false, length = 4)
    private int  ambiente;
     /*
     0- nada
    1 - Teste
    2 - Vencido
    3 - Pago*/
     
    @Column(nullable = false, unique = false, length = 4)
    private int serie;
    
    @Column(nullable = false, unique = false, length = 35)
     private String datainicio;
    
    @Column(nullable = false, unique = false, length = 35)
     private String datafim;
    private String CódigoRegimeTributario;
    private String ICMS;
    private String PIS;
    private String COFINS;
    private String IPI;
       private int CTipo;
        private String CSenha;
        private String CValidade;
        private String NCM;
        private String CST;
            private String CodigoCity;
            private String InscricaoEstadual;
            private String IBPT;

            private String IdToken;
            private String CSC;
            
             /*
    1 - Emiele
    2 - Jurisconexao
    */
    @Column(name = "instancia", nullable = false, length = 1)
    private String instancia;
   
    public String getInstancia() {
        return instancia;
    }

    public void setIinstancia(String instancia) {
        this.instancia = instancia;
    }
			public Long getId() {
				return id;
			}
			public void setId(Long id) {
				this.id = id;
			}
			public String getCNPJ() {
				return CNPJ;
			}
			public void setCNPJ(String cNPJ) {
				CNPJ = cNPJ;
			}
			public String getNomefantasia() {
				return nomefantasia;
			}
			public void setNomefantasia(String nomefantasia) {
				this.nomefantasia = nomefantasia;
			}
			public String getDescricao() {
				return descricao;
			}
			public void setDescricao(String descricao) {
				this.descricao = descricao;
			}
			public String getCidade() {
				return Cidade;
			}
			public void setCidade(String cidade) {
				Cidade = cidade;
			}
			public String getCEP() {
				return CEP;
			}
			public void setCEP(String cEP) {
				CEP = cEP;
			}
			public String getCFOP() {
				return CFOP;
			}
			public void setCFOP(String cFOP) {
				CFOP = cFOP;
			}
			public String getRazaosocial() {
				return razaosocial;
			}
			public void setRazaosocial(String razaosocial) {
				this.razaosocial = razaosocial;
			}
			public String getRua() {
				return rua;
			}
			public void setRua(String rua) {
				this.rua = rua;
			}
			public String getBairro() {
				return Bairro;
			}
			public void setBairro(String bairro) {
				Bairro = bairro;
			}
			public String getNumero() {
				return Numero;
			}
			public void setNumero(String numero) {
				Numero = numero;
			}
			public String getEstado() {
				return Estado;
			}
			public void setEstado(String estado) {
				Estado = estado;
			}
			public String getUf() {
				return Uf;
			}
			public void setUf(String uf) {
				Uf = uf;
			}
			public String getTelefone() {
				return telefone;
			}
			public void setTelefone(String telefone) {
				this.telefone = telefone;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getCertificado() {
				return Certificado;
			}
			public void setCertificado(String certificado) {
				Certificado = certificado;
			}
			public String getNumeroSérie() {
				return NumeroSérie;
			}
			public void setNumeroSérie(String numeroSérie) {
				NumeroSérie = numeroSérie;
			}
			public int getAmbiente() {
				return ambiente;
			}
			public void setAmbiente(int ambiente) {
				this.ambiente = ambiente;
			}
			public int getSerie() {
				return serie;
			}
			public void setSerie(int serie) {
				this.serie = serie;
			}
			public String getDatainicio() {
				return datainicio;
			}
			public void setDatainicio(String datainicio) {
				this.datainicio = datainicio;
			}
			public String getDatafim() {
				return datafim;
			}
			public void setDatafim(String datafim) {
				this.datafim = datafim;
			}
			public String getCódigoRegimeTributario() {
				return CódigoRegimeTributario;
			}
			public void setCódigoRegimeTributario(String códigoRegimeTributario) {
				CódigoRegimeTributario = códigoRegimeTributario;
			}
			public String getICMS() {
				return ICMS;
			}
			public void setICMS(String iCMS) {
				ICMS = iCMS;
			}
			public String getPIS() {
				return PIS;
			}
			public void setPIS(String pIS) {
				PIS = pIS;
			}
			public String getCOFINS() {
				return COFINS;
			}
			public void setCOFINS(String cOFINS) {
				COFINS = cOFINS;
			}
			public String getIPI() {
				return IPI;
			}
			public void setIPI(String iPI) {
				IPI = iPI;
			}
			public int getCTipo() {
				return CTipo;
			}
			public void setCTipo(int cTipo) {
				CTipo = cTipo;
			}
			public String getCSenha() {
				return CSenha;
			}
			public void setCSenha(String cSenha) {
				CSenha = cSenha;
			}
			public String getCValidade() {
				return CValidade;
			}
			public void setCValidade(String cValidade) {
				CValidade = cValidade;
			}
			public String getNCM() {
				return NCM;
			}
			public void setNCM(String nCM) {
				NCM = nCM;
			}
			public String getCST() {
				return CST;
			}
			public void setCST(String cST) {
				CST = cST;
			}
			public String getCodigoCity() {
				return CodigoCity;
			}
			public void setCodigoCity(String codigoCity) {
				CodigoCity = codigoCity;
			}
			public String getInscricaoEstadual() {
				return InscricaoEstadual;
			}
			public void setInscricaoEstadual(String inscricaoEstadual) {
				InscricaoEstadual = inscricaoEstadual;
			}
			public String getIBPT() {
				return IBPT;
			}
			public void setIBPT(String iBPT) {
				IBPT = iBPT;
			}
			public String getIdToken() {
				return IdToken;
			}
			public void setIdToken(String idToken) {
				IdToken = idToken;
			}
			public String getCSC() {
				return CSC;
			}
			public void setCSC(String cSC) {
				CSC = cSC;
			}
			public Vendedor(Long id, String cNPJ, String nomefantasia, String descricao, String cidade, String cEP,
					String cFOP, String razaosocial, String rua, String bairro, String numero, String estado, String uf,
					String telefone, String email, String certificado, String numeroSérie, int ambiente, int serie,
					String datainicio, String datafim, String códigoRegimeTributario, String iCMS, String pIS,
					String cOFINS, String iPI, int cTipo, String cSenha, String cValidade, String nCM, String cST,
					String codigoCity, String inscricaoEstadual, String iBPT, String idToken, String cSC) {
				super();
				this.id = id;
				CNPJ = cNPJ;
				this.nomefantasia = nomefantasia;
				this.descricao = descricao;
				Cidade = cidade;
				CEP = cEP;
				CFOP = cFOP;
				this.razaosocial = razaosocial;
				this.rua = rua;
				Bairro = bairro;
				Numero = numero;
				Estado = estado;
				Uf = uf;
				this.telefone = telefone;
				this.email = email;
				Certificado = certificado;
				NumeroSérie = numeroSérie;
				this.ambiente = ambiente;
				this.serie = serie;
				this.datainicio = datainicio;
				this.datafim = datafim;
				CódigoRegimeTributario = códigoRegimeTributario;
				ICMS = iCMS;
				PIS = pIS;
				COFINS = cOFINS;
				IPI = iPI;
				CTipo = cTipo;
				CSenha = cSenha;
				CValidade = cValidade;
				NCM = nCM;
				CST = cST;
				CodigoCity = codigoCity;
				InscricaoEstadual = inscricaoEstadual;
				IBPT = iBPT;
				IdToken = idToken;
				CSC = cSC;
			}
			public Vendedor() {
				super();
				// TODO Auto-generated constructor stub
			}

   

   

}
