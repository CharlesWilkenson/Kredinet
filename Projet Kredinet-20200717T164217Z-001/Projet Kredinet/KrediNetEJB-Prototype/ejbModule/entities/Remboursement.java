package entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value="Remboursement")
public class Remboursement extends Operation implements Serializable{

	private static final long serialVersionUID = 1L;



}
