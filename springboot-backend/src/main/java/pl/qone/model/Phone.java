package pl.qone.model;

import javax.persistence.*;

@Entity
@Table(name="phones")
public class Phone {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="producer")
	private String producer;
	@Column(name="model")
	private String model;
	@Column(name="system_version")
	private String system;
	@Column(name="url")
	private String url;
	
	
	public Phone() {}
	
	public Phone(String producer, String model, String system, String url) {
		super();
		this.producer = producer;
		this.model = model;
		this.system = system;
		this.url = url;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

}
