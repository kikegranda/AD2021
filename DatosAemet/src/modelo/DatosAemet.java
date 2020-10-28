package modelo;

import java.util.Date;

public class DatosAemet {
	
	private Date fecha;
	private String indicativo, nombre, provincia;
	private Integer altitud;
	private Double tmed,  tmin;
	private String prec, horatmin;
	private Double tmax;
	private String horatmax;
	private Integer dir;
	private Double velmedia, racha;
	private String horaracha;
	private Double sol, presMax;
	private String horaPresMax;
	private Double presMin;
	private String horaPresMin;

	public DatosAemet(Date fecha, String indicativo, String nombre, String provincia, Integer altitud, Double tmed,
			String prec, Double tmin, String horatmin, Double tmax, String horatmax, Integer dir, Double velmedia,
			Double racha, String horaracha, Double sol, Double presMax, String horaPresMax, Double presMin,
			String horaPresMin) {
		this.fecha = fecha;
		this.indicativo = indicativo;
		this.nombre = nombre;
		this.provincia = provincia;
		this.altitud = altitud;
		this.tmed = tmed;
		this.prec = prec;
		this.tmin = tmin;
		this.horatmin = horatmin;
		this.tmax = tmax;
		this.horatmax = horatmax;
		this.dir = dir;
		this.velmedia = velmedia;
		this.racha = racha;
		this.horaracha = horaracha;
		this.sol = sol;
		this.presMax = presMax;
		this.horaPresMax = horaPresMax;
		this.presMin = presMin;
		this.horaPresMin = horaPresMin;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getIndicativo() {
		return indicativo;
	}

	public void setIndicativo(String indicativo) {
		this.indicativo = indicativo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Integer getAltitud() {
		return altitud;
	}

	public void setAltitud(Integer altitud) {
		this.altitud = altitud;
	}

	public Double getTmed() {
		return tmed;
	}

	public void setTmed(Double tmed) {
		this.tmed = tmed;
	}

	public String getPrec() {
		return prec;
	}

	public void setPrec(String prec) {
		this.prec = prec;
	}

	public Double getTmin() {
		return tmin;
	}

	public void setTmin(Double tmin) {
		this.tmin = tmin;
	}

	public String getHoratmin() {
		return horatmin;
	}

	public void setHoratmin(String horatmin) {
		this.horatmin = horatmin;
	}

	public Double getTmax() {
		return tmax;
	}

	public void setTmax(Double tmax) {
		this.tmax = tmax;
	}

	public String getHoratmax() {
		return horatmax;
	}

	public void setHoratmax(String horatmax) {
		this.horatmax = horatmax;
	}

	public Integer getDir() {
		return dir;
	}

	public void setDir(Integer dir) {
		this.dir = dir;
	}

	public Double getVelmedia() {
		return velmedia;
	}

	public void setVelmedia(Double velmedia) {
		this.velmedia = velmedia;
	}

	public Double getRacha() {
		return racha;
	}

	public void setRacha(Double racha) {
		this.racha = racha;
	}

	public String getHoraracha() {
		return horaracha;
	}

	public void setHoraracha(String horaracha) {
		this.horaracha = horaracha;
	}

	public Double getSol() {
		return sol;
	}

	public void setSol(Double sol) {
		this.sol = sol;
	}

	public Double getPresMax() {
		return presMax;
	}

	public void setPresMax(Double presMax) {
		this.presMax = presMax;
	}

	public String getHoraPresMax() {
		return horaPresMax;
	}

	public void setHoraPresMax(String horaPresMax) {
		this.horaPresMax = horaPresMax;
	}

	public Double getPresMin() {
		return presMin;
	}

	public void setPresMin(Double presMin) {
		this.presMin = presMin;
	}

	public String getHoraPresMin() {
		return horaPresMin;
	}

	public void setHoraPresMin(String horaPresMin) {
		this.horaPresMin = horaPresMin;
	}

	@Override
	public String toString() {
		return "DatosAemet [fecha=" + fecha + ", indicativo=" + indicativo + ", nombre=" + nombre + ", provincia="
				+ provincia + ", altitud=" + altitud + ", tmed=" + tmed + ", prec=" + prec + ", tmin=" + tmin
				+ ", horatmin=" + horatmin + ", tmax=" + tmax + ", horatmax=" + horatmax + ", dir=" + dir
				+ ", velmedia=" + velmedia + ", racha=" + racha + ", horaracha=" + horaracha + ", sol=" + sol
				+ ", presMax=" + presMax + ", horaPresMax=" + horaPresMax + ", presMin=" + presMin + ", horaPresMin="
				+ horaPresMin + "]";
	}	
}