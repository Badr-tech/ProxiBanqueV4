package ma.jit.entities;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

public class Conseiller extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Conseiller() {
		super();
		// TODO Auto-generated constructor stub
	}

}
