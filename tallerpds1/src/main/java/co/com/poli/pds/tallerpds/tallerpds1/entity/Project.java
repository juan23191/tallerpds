package co.com.poli.pds.tallerpds.tallerpds1.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "projects")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "projectName")
	private String projectName;
	
	@Column(name = "projectIdentifier")
	private String projectIdentifier;
	
	@Column(name = "description")
	private String description;
	
	@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	@Column(name = "startDate")
	private Date startDate;
	
	@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	@Column(name = "endDate")
	private Date endDate;
	

	@OneToOne(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BackLog backLog;
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
