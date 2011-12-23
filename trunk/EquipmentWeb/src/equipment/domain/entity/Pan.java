package equipment.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "PAN")
public class Pan {
	@Id
	@Column(name="a")
	private Integer a;
	
	@Column(name="b")
	private Integer b;
	@Column(name="c")
	private Integer c;
	@Column(name="d")
	private Integer d;
	public Integer getA() {
		return a;
	}
	public void setA(Integer a) {
		this.a = a;
	}
	public Integer getB() {
		return b;
	}
	public void setB(Integer b) {
		this.b = b;
	}
	public Integer getC() {
		return c;
	}
	public void setC(Integer c) {
		this.c = c;
	}
	public Integer getD() {
		return d;
	}
	public void setD(Integer d) {
		this.d = d;
	}

	 
	
}
